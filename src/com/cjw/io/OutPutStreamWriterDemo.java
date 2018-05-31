package com.cjw.io;

import java.io.*;

/**
 * @author codeAC
 * @date 2018/5/31 18:29
 *  转换流
 *    java.io.OutputStreamWriter 继承Writer类
 *    就是一个字符输出流，写文本文件
 *    write()字符，字符数组，字符串
 *
 *    字符通向字节的桥梁，将字符流转字节流
 *
 *    OutputStreamWriter 使用方式
 *     构造方法：
 *       OutputStreamWriter(OuputStream out)接收所有的字节输出流
 *       但是： 字节输出流：  FileOutputStream
 *
 *      OutputStreamWriter(OutputStream out, String charsetName)
 *      String charsetName 传递编码表名字 GBK  UTF-8
 *
 *      OutputStreamWriter 有个子类，  FileWriter
 */
public class OutPutStreamWriterDemo {
    public static String path = "F:\\Demo\\b.txt";
    public static void main(String[] args) throws IOException {
        WriterGBK("你好");
        readGBK();
    }
    public static void WriterGBK(String str) throws IOException {
        FileOutputStream fos = new FileOutputStream(path);
        OutputStreamWriter osw = new OutputStreamWriter(fos,"GBK");
        osw.write(str);
        osw.close();

    }
    public static void readGBK() throws IOException {
        FileInputStream fis = new FileInputStream(path);
        InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
        char[] chars = new char[1024];
        int len = isr.read(chars);
        System.out.println(new String(chars,0,len));
        isr.close();
    }
}
