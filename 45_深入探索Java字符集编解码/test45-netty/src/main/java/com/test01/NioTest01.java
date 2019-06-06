package com.test01;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * MappedByteBuffer,只要带ByteBuffer 字节都是ascii码即是数字组成的字符串
 * decoder把字节数组装每个字符的ascii码转成字节数组装每个字符 如byte[0]=65,byte[1]=66;变成 byte[0]='a',byte[1]='b';
 * encoder把字节数组装每个字符转成字节数组装字符的ascii码 如byte[0]='a',byte[1]='b'; 变成 byte[0]=65,byte[1]=66;
 */
public class NioTest01 {
    public static void main(String[] args) throws Exception{
        String inputFileString = "inputFile.txt";
        String outputFileString = "outputFile.txt";
        RandomAccessFile inputFile = new RandomAccessFile(inputFileString, "r");
        RandomAccessFile outputFile = new RandomAccessFile(outputFileString, "rw");
        FileChannel inputFileChannel = inputFile.getChannel();
        FileChannel outputFileChannel = outputFile.getChannel();
        long inputFileLength = new File(inputFileString).length();
        MappedByteBuffer inputData = inputFileChannel.map(FileChannel.MapMode.READ_ONLY, 0, inputFileLength);

        Charset charset = Charset.forName("utf-8");
        CharsetEncoder charsetEncoder = charset.newEncoder();
        CharsetDecoder charsetDecoder = charset.newDecoder();

        CharBuffer charBuffer = charsetDecoder.decode(inputData);
        ByteBuffer byteBuffer = charsetEncoder.encode(charBuffer);
        outputFileChannel.write(byteBuffer);
        inputFile.close();
        outputFile.close();
    }
}
