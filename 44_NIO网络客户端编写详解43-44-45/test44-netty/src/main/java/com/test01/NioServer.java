package com.test01;


import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 *为自已为参考点，自已给别人为写，别个给自已为读
 * selector.select()在阻塞中临听每个通道事件
 * 一当服务器和客户端连接成功,系统就会随机分配另一个通道channel进行数据传送,不再是8899
 * 所以这个随机通道final SocketChannel client;也要注册到select中
 * Set<SelectionKey> selectionKeys = selector.selectedKeys();注意这一定要取一份出来,做为本次操作条件控制
 * Map<String,SocketChannel> clientMap = new HashMap<String,SocketChannel>() 这个只要是用来保存多个
 * 客户端的标示
 * selectionKeys 表示所有通道事做集合如channel01.event01;channel01.event02;channel02.event01;channel02.event02;
 */
public class NioServer {
    private static Map<String,SocketChannel> clientMap = new HashMap<String,SocketChannel>();
    public static void main(String[] args)throws Exception{

            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            ServerSocket serverSocket = serverSocketChannel.socket();
            serverSocket.bind(new InetSocketAddress(8899));

            Selector selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            while (true){
                try {
                    selector.select();
                    /**
                     * 表示返回值是一个SelectionKey集合set
                     */
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    selectionKeys.forEach(selectionKey -> {
                    final SocketChannel client;
                    try {
                            if(selectionKey.isAcceptable()){
                                ServerSocketChannel server = (ServerSocketChannel)selectionKey.channel();
                                client = server.accept();
                                client.configureBlocking(false);
                                /**
                                 * 随机通道Channel注册到select中
                                 */
                                client.register(selector,SelectionKey.OP_READ);
                                String key = "[" + UUID.randomUUID().toString() + "]";
                                clientMap.put(key,client);
                                System.out.println("客户端 " + key + "连接成功加入!");
                            } else if(selectionKey.isReadable()){
                                client = (SocketChannel) selectionKey.channel();
                                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                                int count = client.read(readBuffer);
                                if (count > 0){
                                    readBuffer.flip();
                                    Charset charset = Charset.forName("utf-8");
                                    String receiveMessage = String.valueOf(charset.decode(readBuffer).array());
                                    System.out.println(client + ":" + receiveMessage);
                                    /**
                                     * 由当前客户端socketChannel找到它的标示key
                                     */
                                    String sendKey = null;
                                    for(Map.Entry<String,SocketChannel> entry : clientMap.entrySet()){
                                        if(client == entry.getValue()){
                                            sendKey = entry.getKey();
                                        }
                                    }
                                    /**
                                     * 给所有客户端写数据
                                     */
                                    for (Map.Entry<String,SocketChannel> entry : clientMap.entrySet()){
                                        SocketChannel valueChannel = entry.getValue();
                                        ByteBuffer writeByteBuffer = ByteBuffer.allocate(1024);
                                        writeByteBuffer.put((sendKey + ":" + receiveMessage + "\r\n").getBytes());
                                        writeByteBuffer.flip();
                                        valueChannel.write(writeByteBuffer);
                                    }
                                }
                            }
                        } catch (Exception e){
                            e.printStackTrace();
                        }

                    });
                    selectionKeys.clear();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


    }
}
