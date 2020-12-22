package com.liust.jd.leetcode.v001;

public class Foo {
    ThreadLocal<String> names = new ThreadLocal<>();

    public static void main(String[] args) {

    }


    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        names.set("name");

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    public void one() { print("one"); }
    public void two() { print("two"); }
    public void three() { print("three"); }

    public static void print(String msg){
        System.out.println(msg);
    }

}
