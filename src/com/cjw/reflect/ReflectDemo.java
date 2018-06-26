package com.cjw.reflect;

/**
 * @author codeAC
 * @Date: 2018/6/25
 * @Time: 22:09
 */
public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取类对象的3种方式(Class是描述字节码文件对象的类)
        ReflectDemo reflectDemo = new ReflectDemo();
        //1:通过Object类中的getClass()方法
        Class aClass = reflectDemo.getClass();
        System.out.println(aClass);
        //2：通过静态变量class获取(class是每一个类都有的静态变量，但是是隐藏的)
        Class aClass1 = ReflectDemo.class;
        System.out.println(aClass1);
        //3: 通过Class的静态方法forName()
        Class aClass2 = Class.forName("com.cjw.reflect.ReflectDemo");
        System.out.println(aClass2);
        //判断获取的类对象是否一致
        System.out.println(aClass == aClass1);
        //true
        System.out.println(aClass1 == aClass2);
        //true
        System.out.println(aClass.equals(aClass1));
    }
}
