package com.liust.jd.msb.juc;

import java.util.concurrent.Phaser;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
//        System.out.println("ajax is async");
    }

    public void write(String msg){
        try{
            lock.lock();
        }finally {
            lock.unlock();
        }
    }
}
