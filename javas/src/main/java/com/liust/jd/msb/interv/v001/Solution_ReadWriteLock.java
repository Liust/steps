package com.liust.jd.msb.interv.v001;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 *  collection, two threads :
 *  a) a thread add element to collection
 *  b) a thread exec biz when collection.size == 5
 *
 */
public class Solution_ReadWriteLock {

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

        Solution_ReadWriteLock solution = new Solution_ReadWriteLock();
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Thread addThread = new Thread(() -> {
            String threadName = Thread.currentThread().getName();

            for (int i = 0; i < loopSize; i++) {
                solution.log(i + "." + threadName + " | ");
                solution.add(new Dog(i));

                if(solution.size() == 5){

                }
            }
            System.out.println(threadName + " run over ");
        });

        Thread sizeThread = new Thread(()->{
            if (solution.size() != 5) {

            }

            String getName = " **" + Thread.currentThread().getName() + "** ";
            solution.add(new Dog(100));
            solution.log(getName);

            System.out.println(Thread.currentThread().getName() + " run over ");

        });

        addThread.start();
        sizeThread.start();

        System.in.read();

        System.out.println( " log info: " + solution.getLogs());
        solution.print();
    }

}
