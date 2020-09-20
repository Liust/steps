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
public enum Mgr08 {
    INSTANCE;

    public static Mgr08 getInstance(){
        return INSTANCE;
    }
}
