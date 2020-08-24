package com.liust.jd.sort.utils;

import java.io.PrintStream;

public class PrintUtil {
    private static PrintStream printStream = System.out;
    public static void println(int[] nums){
        print("msg:[");
        for (int num:nums) {
            print(num);
            print(",");
        }
        println("]");
    }
    public static void print(int num){
        getPrintStream().print(num);
    }
    public static void print(String msg){
        getPrintStream().print(msg);
    }
    public static void println(String msg){
        getPrintStream().println(msg);
    }

    public static PrintStream getPrintStream(){
        return printStream;
    }

    public void setPrintStream(PrintStream printStream){
        this.printStream = printStream;
    }
}
