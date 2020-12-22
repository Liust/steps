package com.liust.jd.msb.interv.v001;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *  collection, two threads :
 *  a) a thread add element to collection
 *  b) a thread exec biz when collection.size == 5
 *
 */
public class Solution {

    StringBuilder sb = new StringBuilder();
    JdCollection collection = new JdCollection();
    Object lock = new Object();
    static final int loopSize = 10;

    public void addLogic(){
        String threadName = Thread.currentThread().getName();

        synchronized (lock) {
            for (int i = 0; i < loopSize; i++) {
                log(i + "." + threadName + " | ");
                collection.add(new Dog(i));

                if(collection.size() == 5){
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println(threadName + " run over ");

    }

    public void sizeLogic(){
        synchronized (lock) {
            if (collection.size() != 5) {

                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            String getName = " **" + Thread.currentThread().getName() + "** ";
            collection.add(new Dog(100));
            log(getName);

            lock.notify();
        }

        System.out.println(Thread.currentThread().getName() + " run over ");

    }

    public void log(String argName){

        String getName = Thread.currentThread().getName();
        sb.append(argName);
    }

    public String getLogs(){
        return sb.toString();
    }


    public static void main(String[] args) throws Exception{
        Solution solution = new Solution();

        Thread addThread = new Thread(solution::addLogic);
        Thread sizeThread = new Thread(solution::sizeLogic);

        addThread.start();
        sizeThread.start();

        System.in.read();

        System.out.println( " log info: " + solution.getLogs());
        solution.collection.print();
    }

}

class JdCollection{
    volatile List list = new ArrayList();

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
}

class Dog{
    int age;
    Dog(int age){
        this.age = age;
    }

    @Override
    public String toString() {
        return "dog.age:" + age;
    }
}
