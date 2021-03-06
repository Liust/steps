package com.liust.jd.utils;

public class CheckUtil {
    public static boolean needSort(int[] arr){
        return !(arr == null || arr.length < 2);
    }
    public static boolean needSort(long[] arr){
        return !(arr == null || arr.length < 2);
    }
    public static boolean needSort(float[] arr){
        return !(arr == null || arr.length < 2);
    }
    public static boolean needSort(double[] arr){
        return !(arr == null || arr.length < 2);
    }

    public static void main(String[] args) {
        System.out.println(" let`s go ! ");
    }

    public static void swap(int[] nums, int index, int anotherIndex){
        int temp = nums[index];
        nums[index] = nums[anotherIndex];
        nums[anotherIndex] = temp;
    }

    public static boolean isNull(Object obj){
        return obj == null;
    }

    public static boolean isEmpty(int[] nums){
        return isNull(nums) || nums.length == 0;
    }
}
