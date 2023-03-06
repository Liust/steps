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
}