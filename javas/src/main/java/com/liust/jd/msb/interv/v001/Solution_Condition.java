package com.liust.jd.msb.interv.v001;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 *  collection, two threads :
 *  a) a thread add element to collection
 *  b) a thread exec biz when collection.size == 5
 *
 */
public class Solution_Condition {

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
    static volatile boolean singalled = false;

    public static void main(String[] args) throws Exception{

        Solution_Condition solution = new Solution_Condition();
        ReentrantLock lock = new ReentrantLock();
        Condition addOk = lock.newCondition();
        Condition sizeOk = lock.newCondition();

        CountDownLatch latch = new CountDownLatch(2);

        Thread addThread = new Thread(() -> {

            System.out.println("add thread wait");

            lock.lock();
            String threadName = Thread.currentThread().getName();

            for (int i = 0; i < loopSize; i++) {
                solution.log(i + "." + threadName + " | ");
                solution.add(new Dog(i));

                if(solution.size() == 5){
                    addOk.signal();
                    singalled = true;
                    try {
                        sizeOk.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            lock.unlock();
            latch.countDown();
//            System.out.println(threadName + " run over ");
        });

        Thread sizeThread = new Thread(()->{
            lock.lock();
            try {
                if(!singalled ) {
                    addOk.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String getName = " **" + Thread.currentThread().getName() + "** ";
            solution.add(new Dog(100));
            solution.log(getName);

            sizeOk.signal();

            lock.unlock();
            latch.countDown();

//            System.out.println(Thread.currentThread().getName() + " run over ");

        });

        sizeThread.start();

        addThread.start();

        latch.await();

        System.out.println( " log info: " + solution.getLogs());
        solution.print();
    }

}
