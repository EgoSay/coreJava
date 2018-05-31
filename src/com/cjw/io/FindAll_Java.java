package com.cjw.io;

import java.io.File;
import java.io.FileFilter;

/**
 * @author codeAC
 * @date 2018/5/26 20:54
 * 用于遍历目录下所有Java文件
 */
class MyFilter implements FileFilter{
    /**
     *文件过滤器
     */
    @Override
    public boolean accept(File pathname) {
        if(pathname.isDirectory()){
            return true;
        }
        else {
            String name = pathname.getName().toLowerCase();
            return name.endsWith(".java");
        }
    }
}
public class FindAll_Java {


    public static void main(String[] args)  {
        String pathName = "F:\\Demo";
        File file = new File(pathName);
        getAll(file);
    }
    public static void getAll(File file){

        File[] files = file.listFiles(new MyFilter());
        for(File f:files){
            if (f.isDirectory()){
                getAll(f);
            }else {
                System.out.println(f);
            }
            ;
        }
    }
}
