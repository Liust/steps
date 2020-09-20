package com.liust.jd.designpatterns.tank.designpatterns.singleton;

/**
 * singleton 8 ways
 * 1.  饿汉式
 * 2. 饿汉式,static init
 * 3. lazy init
 * 4. method lock
 * 5. statement lock
 * 6. double check way
 * 7. static inner class
 * 8. perfect mode : effective java way: enum
 *
 *
 */
public class Mgr06 {
    private static volatile Mgr06 instance;

    private Mgr06(){}

    public static Mgr06 getInstance(){
        if(null == instance){
            synchronized (Mgr06.class){
                if(null == instance){
                    instance = new Mgr06();
                }
            }
        }

        return instance;
    }
}
