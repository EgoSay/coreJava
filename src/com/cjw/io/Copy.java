package com.cjw.io;

import java.io.*;

/**
 * @author codeAC
 * @date 2018/5/31 20:55
 */
public class Copy {
    private static File src= new File("F:\\Demo\\b.txt");
    private static File target = new File("F:\\Demo\\a\\1.txt");
    public static void main(String[] args) throws IOException{
        long start = System.currentTimeMillis();
        copy_2(src,target);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
    /**
     * 方法,实现文件复制
     *  1. 字节流读写单个字节
     */
    public static void copy_1(File src, File desc)throws IOException {
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(desc);
        int len ;
        while((len = fis.read())!=-1){
            fos.write(len);
        }
        fos.close();
        fis.close();
    }
    /**
     * 方法,实现文件复制
     *  2. 字节流读写字节数组
     */
    public static void copy_2(File src,File desc)throws IOException{
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(desc);
        int len = 0 ;
        byte[] bytes = new byte[1024];
        while((fis.read(bytes))!=-1){
            fos.write(bytes);
        }
        fos.close();
        fis.close();
    }
    /**
     * 方法,实现文件复制
     *  3. 字节流缓冲区流读写单个字节
     */
    public static void copy_3(File src,File desc)throws IOException{
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(desc));
        int len = 0 ;
        while((len = bis.read())!=-1){
            bos.write(len);
        }
        bos.close();
        bis.close();
    }
    /**
     * 方法,实现文件复制
     *  4. 字节流缓冲区流读写字节数组
     */
    public static void copy_4(File src,File desc)throws IOException{
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(desc));
        int len = 0 ;
        byte[] bytes = new byte[1024];
        while((len = bis.read(bytes))!=-1){
            bos.write(bytes,0,len);
        }
        bos.close();
        bis.close();
    }
    /**
     * 5.字符流读写
     */
    public static void copy_5(File src,File desc)throws IOException{
        BufferedReader bfr = new BufferedReader(new FileReader(src));
        BufferedWriter bfw = new BufferedWriter(new FileWriter(desc));
        //读取文本行, 读一行,写一行,写换行
        String line = null;
        while((line = bfr.readLine())!=null){
            bfw.write(line);
            bfw.newLine();
            bfw.flush();
        }
        bfw.close();
        bfr.close();
    }

}
