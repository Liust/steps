package com.liust.jd.msb.interv.a1b2;

import java.util.concurrent.locks.LockSupport;

public class Solution_LockSupport {
    static Thread t2 = null;
    public static void main(String[] args) throws InterruptedException {
        char[] chars = "abcdefghij".toCharArray();
        char[] nums = "0123456789".toCharArray();

        Thread t1 = new Thread("t1"){
            @Override
            public void run(){
                    for (int i = 0; i < chars.length; i++) {
                        System.out.print(chars[i]);
                        LockSupport.unpark(t2);
                        LockSupport.park();
                    }
                }

        };

        t2 = new Thread("t2"){
            @Override
            public void run(){
                    for (int i = 0; i < nums.length; i++) {
                        LockSupport.park();
                        System.out.print(nums[i]);
                        LockSupport.unpark(t1);

                    }

            }

        };

        t1.start();
        t2.start();

    }
}
