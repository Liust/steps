package com.liust.jd.sort;

import com.liust.jd.utils.PrintUtil;

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

    public static int getRandomNum(int bound){
        return random.nextInt(bound);
    }

    public static int[] getRandomDataArr(int n){
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = getRandomNum();
        }

        return data;
    }

    /**
     * 获得随机数 数组
     * @param bound
     * @param length
     * @return
     */
    public static int[] getRandomDataArr(int bound, int length){
        int[] data = new int[length];
        for (int i = 0; i < length; i++) {
            data[i] = getRandomNum(bound);
        }

        return data;
    }

    public static void main(String[] args) {
        int[] nums ;
        for(int i=1; i<20; i++){
            nums = getRandomDataArr(i*100, i);
            PrintUtil.println(nums);
        }
    }
}
