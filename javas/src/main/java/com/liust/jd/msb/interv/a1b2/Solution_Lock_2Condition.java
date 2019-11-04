package com.liust.jd.msb.interv.a1b2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Solution_Lock_2Condition {

    public static void main(String[] args) throws InterruptedException {
        char[] chars = "ABCDEFGHIJ".toCharArray();
        char[] nums = "0123456789".toCharArray();
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Condition condition2 = lock.newCondition();
        String msg = "implement by reentrantLock 2 conditions";

        Thread t1 = new Thread("t1"){
            @Override
            public void run(){
                lock.lock();
                    for (char c : chars) {
                        System.out.print(c);

                        condition2.signal();
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    condition2.signal();
                    lock.unlock();
                }

        };

        Thread t2 = new Thread("t2"){
            @Override
            public void run(){
                    lock.lock();
                    for (char c : nums) {
                        try {
                            condition2.await();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.print(c);

                        condition.signal();

                    }
                    condition.signal();

                    lock.unlock();

            }

        };

        t1.start();
        t2.start();

        System.out.println(msg);

    }
}
