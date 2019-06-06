package com.test01;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class OldIOServer {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(8899);
        while (true){
            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            try {
                byte[] byteArray = new byte[4096];
                long countLength = 0;
                while (true){
                    int readcount = dataInputStream.read(byteArray, 0, byteArray.length);
                    countLength += readcount;
                    if(readcount == -1){
                        break;
                    }
                }
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
