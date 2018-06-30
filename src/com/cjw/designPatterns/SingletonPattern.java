package com.cjw.designPatterns;

/**
 * @author codeAC
 * @Date: 2018/6/30
 * @Time: 11:04
 */
public class SingletonPattern {

}
//饿汉式单例模式
class EagerSingleton{
    private static final EagerSingleton eagerSingleton = new EagerSingleton();

    public static EagerSingleton getEagerSingleton() {
        return eagerSingleton;
    }
}
/**
 * 懒汉式单例
 * 这种虽然解决了线程安全问题，但是每次调用获取实例时都需要进行线程锁定判断，性能不好
 */
class LazySingleton{
    private static LazySingleton lazySingleton = null;
     synchronized public static LazySingleton getLazySingleton(){
        if(lazySingleton == null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}

/**
 * 错误的双重检查锁定
 * 这里代码执行到第一次检查时，读取到对象实例不为空时，因为指令重排序，引用的对象有可能还没有完成初始化
 */
class DoubleCheckLocking{
    private static DoubleCheckLocking doubleCheckLocking;
    public static DoubleCheckLocking getDoubleCheckLocking(){
        if(doubleCheckLocking == null){                         //第一次检查
            synchronized (DoubleCheckLocking.class){            //加锁
                if(doubleCheckLocking == null){                 //第二次检查
                    doubleCheckLocking = new DoubleCheckLocking();
                }
            }
        }
        return doubleCheckLocking;
    }
}

/**
 * 基于volatile的解决方案
 */
class SafeDoubleCheckedLocking{
    private volatile static SafeDoubleCheckedLocking safeDoubleCheckLocking;
    public static SafeDoubleCheckedLocking getSafeDoubleCheckLocking(){
        if(safeDoubleCheckLocking == null){                         //第一次检查
            synchronized (SafeDoubleCheckedLocking.class){            //加锁
                if(safeDoubleCheckLocking == null){                 //第二次检查
                    safeDoubleCheckLocking = new SafeDoubleCheckedLocking();
                }
            }
        }
        return safeDoubleCheckLocking;
    }
}

/**
 * 基于类的初始化解决方案
 * JVM在类的初始化阶段(即在Class被加载后，且被线程使用前）,会执行类的初始化
 * 在这期间，JVM回去获取一个锁，这个锁可以同步多个线程对同一个类的初始化
 */
class InstanceFactory{
    private static class InstanceHolder{
        private static InstanceFactory instance = new InstanceFactory();
    }
    public InstanceFactory getInstance(){
        return InstanceHolder.instance;
    }
}
