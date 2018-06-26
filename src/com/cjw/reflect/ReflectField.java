package com.cjw.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author codeAC
 * @Date: 2018/6/26
 * @Time: 19:37
 */
public class ReflectField {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        /*
         *通过反射获取成员变量及set/get操作
         */
        Class FieldClass = Class.forName("com.cjw.reflect.Person");
        Field[] fields = FieldClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        Field ageField = FieldClass.getDeclaredField("age");
        System.out.println(ageField);


        Constructor test = FieldClass.getConstructor(String.class,int.class);

        ageField.setAccessible(true);
        Object test1 = test.newInstance("test", 19);
        Object o = ageField.get(test1);
        System.out.println(o);
        ageField.set(test1,66);
        System.out.println(ageField.get(test1));

        /*
         * 创建对象，调用指定的方法
         */
        Method eat = FieldClass.getMethod("eat");
        eat.invoke(test1);
        //获取私有方法并调用
        Method playGame = FieldClass.getDeclaredMethod("playGame");
        playGame.setAccessible(true);
        playGame.invoke(test1);

    }
}
