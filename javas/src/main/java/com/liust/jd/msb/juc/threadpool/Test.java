package com.liust.jd.msb.juc.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class Test {
    public static void main(String[] args) {
        ExecutorService single = Executors.newSingleThreadExecutor();
        ExecutorService cached = Executors.newCachedThreadPool();
        ExecutorService fixed = Executors.newFixedThreadPool(3);
        ExecutorService schedule = Executors.newScheduledThreadPool(2);

        ExecutorService stealing = Executors.newWorkStealingPool();
        ExecutorService forkJoin = new ForkJoinPool();

    }
}
