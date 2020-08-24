package com.liust.jd.sort;

import java.util.Random;

public class Data {
    private static int[] arr = {2,9,3,5,1,2,1,6,1,7,8,4,9};
    private static Random random = new Random();

    public static int[] getData(){
        return arr;
    }

    public static int getRandomNum(){
        return random.nextInt(1000);
    }

    public static int[] getRandomDataArr(int n){
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = getRandomNum();
        }

        return data;
    }
}
