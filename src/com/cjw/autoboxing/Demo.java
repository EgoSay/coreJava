package com.cjw.autoboxing;


/**
 * @author codeAC
 * @date 2018/5/28 20:28
 * 在装箱的时候自动调用的是valueOf()方法。而在拆箱的时候自动调用的是xxxValue方法
 */
@SuppressWarnings("ALL")
public class Demo {
    public static void main(String[] args) {
//        test1();
        test2();
    }

    /**
     * 在通过valueOf方法创建Integer对象的时候，
     * 如果数值在[-128,127]之间，便返回指向IntegerCache.cache中已经存在的对象的引用
     * 否则创建一个新的Integer对象
     */
    public static void test1(){
        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 200;
        Integer i4 = 200;
        System.out.println(i1==i2);  //true
        System.out.println(i3==i4);  //false
    }

    /**
     * 因为在某个范围内的整型数值的个数是有限的，而浮点数却不是
     * 所以Double类的valueOf方法会采用与Integer类的valueOf方法不同的实现
     */
    public static void test2(){
        Double d1 = 100.0;
        Double d2 = 100.0;
        Double d3 = 200.0;
        Double d4 = 200.0;
        System.out.println(d1.intValue()==d2);  //false
        System.out.println(d3==d4);  //false
    }

}
