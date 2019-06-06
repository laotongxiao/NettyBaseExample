package com.test01;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.Socket;

public class OldIOClient {
    public static void main(String[] args)throws Exception{
        Socket socket = new Socket("localhost",8899);
        String fileString = "H:\\lao.txt";
        InputStream inputStream = new FileInputStream(fileString);
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        byte[] buffer = new byte[4096];
        int readCount;
        long total = 0;
        long startTime = System.currentTimeMillis();
        while ((readCount = inputStream.read(buffer))>=0){
            total += readCount;
            dataOutputStream.write(buffer);
        }
        System.out.println("发送总数节数:" + total + " 耗时:" + (System.currentTimeMillis()-startTime));
        dataOutputStream.close();
        socket.close();
        inputStream.close();
    }
}
