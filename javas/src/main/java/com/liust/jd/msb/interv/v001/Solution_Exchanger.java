package com.liust.jd.msb.interv.v001;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Exchanger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 *  collection, two threads :
 *  a) a thread add element to collection
 *  b) a thread exec biz when collection.size == 5
 *
 */
public class Solution_Exchanger {

    StringBuilder sb = new StringBuilder();

    List list = new ArrayList();

    public void print() {
        for(Object o: list){
            System.out.println(o);
        }
    }

    public int size(){
        return  list.size();
    }

    public void add(Object o){
        list.add(o);
    }


    static final int loopSize = 10;

    public void log(String logInfo){
        sb.append(logInfo);
    }

    public String getLogs(){
        return sb.toString();
    }


    public static void main(String[] args) throws Exception{


        List<String> list = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            test(list);
        }

        for (String str: list) {
            System.out.println(str);
        }


    }

    static void test(List<String> list){
        Solution_Exchanger solution = new Solution_Exchanger();
        CountDownLatch latch = new CountDownLatch(2);
        Exchanger exchanger = new Exchanger();

        Thread addThread = new Thread(() -> {
            String threadName = Thread.currentThread().getName();

            for (int i = 0; i < loopSize; i++) {
                solution.log(i + "." + threadName + " | ");
                solution.add(new Dog(i));

                if(solution.size() == 5){
                    try {
                        exchanger.exchange("b");
                        exchanger.exchange("b");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            latch.countDown();
        });

        Thread sizeThread = new Thread(()->{
            if (solution.size() != 5) {
                try {
                    exchanger.exchange("s");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            String getName = " **" + Thread.currentThread().getName() + "** ";
            solution.add(new Dog(100));
            solution.log(getName);

            try {
                exchanger.exchange("1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            latch.countDown();

        });

        addThread.start();
        sizeThread.start();

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        list.add(solution.getLogs());
    }

}