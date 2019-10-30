package com.liust.jd.msb.interv.a1b2;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class Solution2 {
    public static void main(String[] args) throws InterruptedException {
        char[] chars = "abcdefghij".toCharArray();
        char[] nums = "0123456789".toCharArray();
        Object lock = new Object();

        Thread t1 = new Thread("t1"){
            @Override
            public void run(){
                synchronized (lock) {
                    for (int i = 0; i < chars.length; i++) {
                        System.out.print(chars[i]);
                        try {
                            lock.notify();
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    lock.notify();

                }
            }

        };

        Thread t2 = new Thread("t2"){
            @Override
            public void run(){
                synchronized (lock) {
                    for (int i = 0; i < nums.length; i++) {
                        System.out.print(nums[i]);
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }

                }
            }

        };
        t2.start();

        t1.start();

    }
}
