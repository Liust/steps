package com.liust.jd.msb.interv.a1b2;

import sun.jvm.hotspot.runtime.Threads;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class Solution {
    private static TransferQueue transferQueue = new LinkedTransferQueue();
    public static void main(String[] args) throws InterruptedException {
        char[] chars = "abcdefghij".toCharArray();
        char[] nums = "0123456789".toCharArray();

        Thread t1 = new Thread("t1"){
            @Override
            public void run(){
                for (int i=0; i<chars.length; i++){
                    String num = null;
                    try {
                        num = (String)transferQueue.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print(num);
                    try {
                        transferQueue.transfer(chars[i]+"");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }

        };

        Thread t2 = new Thread("t2"){
            @Override
            public void run(){
                for (int i=0; i<nums.length; i++){
                    try {
                        transferQueue.transfer(nums[i] + "");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String ch = null;
                    try {
                        ch = (String)transferQueue.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print(ch);
                }
            }

        };


        t1.start();
        t2.start();

    }
}
