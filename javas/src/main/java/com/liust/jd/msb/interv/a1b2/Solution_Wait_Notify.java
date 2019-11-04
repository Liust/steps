package com.liust.jd.msb.interv.a1b2;

/**
 *
 * to me
 * 锁哪个对象，用哪个对象wait, notify
 * 如下： synchronized(lock) lock.wait() lock.notify()
 *
 */

public class Solution_Wait_Notify {
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
                        try {
                            lock.wait();
                            System.out.print(nums[i]);
                            lock.notify();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }

                    lock.notify();

                }
            }

        };
        t2.start();

        t1.start();

    }
}
