package com.liust.jd.sort;

import java.util.Objects;
import java.util.Random;

public class Utils {
    static Random random = new Random();
    public static int genInt(int max){
        return random.nextInt(max);
    }

    public static void main(String[] args) {
        System.out.println("Hello world util random");
        System.out.println(genInt(100));
    }

    public static void printlnArray(int[] data){
        if(Objects.isNull(data) || data.length < 1){
            System.out.println(" array is empty ! ");
        }

        for (int d : data){
            System.out.print("[" + d + "],");
        }

        System.out.println();
    }

    public static void printlnLine(String line){
        for (int i = 0; i < 50; i++) {
            System.out.print(line);
        }

        System.out.println();
    }

    public static int[] buildArray(int size, int max) {
        if(size < 1){
            return null;
        }

        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = Utils.genInt(max);
        }
        return data;
    }
}