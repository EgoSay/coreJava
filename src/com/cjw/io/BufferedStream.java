package com.cjw.io;

import java.io.*;

/**
 * @author codeAC
 * @date 2018/5/31 20:04
 *
 *  字节输入流的缓冲流
 *    java.io.BufferedInputStream
 *     继承InputStream,标准的字节输入流
 *     读取方法  read() 单个字节,字节数组
 *
 *    构造方法:
 *      BufferedInputStream(InputStream in)
 *      可以传递任意的字节输入流,传递是谁,就提高谁的效率
 *      可以传递的字节输入流 FileInputStream
 */
public class BufferedStream {
    private static String path = "F:\\Demo\\b.txt";
    public static void main(String[] args) throws IOException {
        read();
        write();
    }
    private static void read() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
        byte[] bytes = new byte[10];
        int len = 0;
        if (( bis.read(bytes))!=-1){
            System.out.println(new String(bytes));
        }
    }
    private static void write() throws IOException{
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path));
        /*
        *并不会直接写入这个整数，而是把这个整数对应的Ascii码字符写入
         */
        bos.write(88);
        byte[] bytes = "Hello".getBytes();
        bos.write(bytes);
        bos.close();
    }
}
