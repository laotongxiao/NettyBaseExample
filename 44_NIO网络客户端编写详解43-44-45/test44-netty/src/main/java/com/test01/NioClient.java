package com.test01;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NioClient {
    public static void main(String[] args) throws IOException {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress(8899));

            Selector selector = Selector.open();
            socketChannel.register(selector, SelectionKey.OP_CONNECT);

            while (true){
                selector.select();
                Set<SelectionKey> selectionKeys = selector.keys();
                for(SelectionKey selectionKey : selectionKeys){
                    if(selectionKey.isConnectable()){
                        SocketChannel client = (SocketChannel) selectionKey.channel();
                        /**
                         * 是否处天连接过程当中,如果是就完成连接
                         */
                        if (client.isConnectionPending()){
                            client.finishConnect();
                            ByteBuffer writeByteBuffer = ByteBuffer.allocate(1024);
                            writeByteBuffer.put((LocalDateTime.now().toString() + "连接成功").getBytes());
                            writeByteBuffer.flip();
                            client.write(writeByteBuffer);
                            /**
                             * 创建单线程线程池接受键盘输入
                             */
                            ExecutorService executorService = Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
                            executorService.submit(()->{
                                while (true){
                                    try {
                                        writeByteBuffer.clear();
                                        InputStreamReader input = new InputStreamReader(System.in);
                                        BufferedReader br = new BufferedReader(input);
                                        String message = br.readLine();
                                        writeByteBuffer.put(message.getBytes());
                                        client.write(writeByteBuffer);
                                    } catch (Exception e){
                                        e.printStackTrace();
                                    }
                                }
                            });
                        }
                    }
                }
                /**
                 * 不可以用forEach,有io异常,有点不明白,所以用上面的for来代替它
                 */
//              selectionKeys.forEach(selectionKey -> {
//
//              });
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
