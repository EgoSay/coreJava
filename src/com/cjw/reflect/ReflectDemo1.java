package com.cjw.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author codeAC
 * @Date: 2018/6/26
 * @Time: 18:43
 */
public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        /*
          通过反射获取构造方法并使用
         */
        Class aClass = Class.forName("com.cjw.reflect.Person");
        Constructor[] constructors = aClass.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        Constructor con1 = aClass.getConstructor(null);
        Constructor con2 = aClass.getConstructor(String.class,int.class);
        System.out.println(con1);
        System.out.println(con2);
        /*
         *通过反射获取构造方法并创建对象
         */
        Object o = con1.newInstance();
        Object o1 = con2.newInstance("cjw",22);
        System.out.println(o);
        System.out.println(o1);

        /*
         * 通过反射方式，获取私有构造方法，创建对象
         * getDeclaredConstructors()获取所有的构造方法,包括私有的
         */
        Constructor con3 = aClass.getDeclaredConstructor(int.class, String.class);
        con3.setAccessible(true);
        Object test_private = con3.newInstance(18, "test private");
        System.out.println(test_private);
    }
}
