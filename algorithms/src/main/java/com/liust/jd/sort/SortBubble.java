package com.liust.jd.sort;

import com.liust.jd.utils.CheckUtil;

import java.util.Arrays;

public class SortBubble extends SortBase{
    @Override
    public void doSort(int[] nums, boolean isAsc) {
        if(!CheckUtil.needSort(nums)){
            return;
        }

        for(int i=0; i< nums.length; i++){
            for(int j=0; j<nums.length-i-1; j++){
                if(needSwap(nums[j],nums[j+1], isAsc)){
                    swap(nums, j, j+1);
                }
            }
        }
    }

    public static void comparator(int[] arr){
        Arrays.sort(arr);
    }

    public static int[] copyArray(int[] arr){
//        int[] targetArr = new int[arr.length];
        return Arrays.copyOf(arr, arr.length);
    }
}
