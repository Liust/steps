package com.liust.jd.msb.juc.dcl;

public class Dcl {//1
    private static Dcl instance;
    private Dcl(){}

    static {
        instance = new Dcl();
    }

    public static Dcl getInstance(){
        return instance;
    }

}

class Singleton{//2
    private static Singleton instance;
    private Singleton(){}

    public static Singleton getInstance(){
        if(instance == null){//not thread safe
            instance = new Singleton();
        }

        return instance;
    }
}


class SingletonB{//3
    private static SingletonB instance;
    private SingletonB(){}

    public synchronized static SingletonB getInstance(){// lock SingletonB.class
        if(instance == null){
            instance = new SingletonB();
        }

        return instance;
    }
}

class SingletonC{///4
    private static SingletonC instance;
    private SingletonC(){}

    public synchronized static SingletonC getInstance(){
        if(instance == null){
            synchronized(SingletonC.class) {
                //biz logic
                instance = new SingletonC();
            }
        }

        return instance;
    }
}

class SingletonD{//5
    /**
     * volatile 可以防止指令重排序，
     * 对于 new 一个对象 的具体执行过程是： 分配内存空间， 执行初始化（执行构造方法？？）， 赋值给引用三步，
     * 如果没有volatile限制，这个过程可能会被重排序，把没有初始化好的对象赋值给引用
     * 导致使用一个未初始化好的对象存在潜在问题
     *
     * */
    private volatile static SingletonD instance;
    private SingletonD(){}

    public synchronized static SingletonD getInstance(){
        if(instance == null){
            synchronized(SingletonC.class) {
                if(instance == null) {
                    instance = new SingletonD();
                }
            }
        }

        return instance;
    }
}

class Six{ // 6

    private static Six instance;
    private Six(){}

    public static Six getInstance(){
        return instance;
    }
}


class Seven{//7

}
