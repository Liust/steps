package com.liust.jd.msb.interv.v001;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 *
 *  collection, two threads :
 *  a) a thread add element to collection
 *  b) a thread exec biz when collection.size == 5
 *
 */
public class Solution_Semaphore {

    StringBuilder sb = new StringBuilder();

    ArrayList list = new ArrayList();
    volatile int size = 0;

    public void print() {
        for(Object o: list){
            System.out.println(o);
        }
    }

    public int size(){
        return  size;
    }

    public void add(Object o){
        list.add(o);
        size++;
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
        for (int i = 0; i < 2; i++) {
            test(list);
        }

        for (String str: list) {
            System.out.println(str);
        }

    }

    public static void test(List<String> list){
        Solution_Semaphore solution = new Solution_Semaphore();
        Semaphore addSemaphore = new Semaphore(1);
        Semaphore sizeSemaphore = new Semaphore(1);

        CountDownLatch latch = new CountDownLatch(2);

        Thread addThread = new Thread(() -> {
            String threadName = Thread.currentThread().getName();

            try {
                sizeSemaphore.acquire();

                for (int i = 0; i < loopSize; i++) {
                    solution.log(i + "." + threadName + " | ");
                    solution.add(new Dog(i));

                    if(solution.size() == 5){
                        sizeSemaphore.release();
                        addSemaphore.acquire();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            latch.countDown();
        });

        Thread sizeThread = new Thread(()->{
            try{
                addSemaphore.acquire();
                sizeSemaphore.acquire();
                if (solution.size() != 5) {
                    sizeSemaphore.release();
                    sizeSemaphore.acquire();
                }

                String getName = " **" + Thread.currentThread().getName() + "** ";
                solution.add(new Dog(100));
                solution.log(getName);

                addSemaphore.release();
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
