package com.liust.jd.sort;

import com.liust.jd.sort.utils.CheckUtil;

public abstract class SortBase {

    public static boolean needSwap(int first, int second, boolean asc){
        return ( first > second == asc);
    }
    public static boolean needSwap(long first, long second, boolean asc){
        return ( first > second == asc);
    }
    public static boolean needSwap(float first, float second, boolean asc){
        return ( first > second == asc);
    }
    public static boolean needSwap(double first, double second, boolean asc){
        return ( first > second == asc);
    }

    public static void swap(int[] nums, int index, int anotherIndex){
        int temp = nums[index];
        nums[index] = nums[anotherIndex];
        nums[anotherIndex] = temp;
    }

    public static void swap(long[] nums, int index, int anotherIndex){
        long temp = nums[index];
        nums[index] = nums[anotherIndex];
        nums[anotherIndex] = temp;
    }

    public static void swap(float[] nums, int index, int anotherIndex){
        float temp = nums[index];
        nums[index] = nums[anotherIndex];
        nums[anotherIndex] = temp;
    }

    public static void swap(double[] nums, int index, int anotherIndex){
        double temp = nums[index];
        nums[index] = nums[anotherIndex];
        nums[anotherIndex] = temp;
    }

    public static boolean needSort(int[] nums){
        return (CheckUtil.needSort(nums));
    }

    public static boolean needSort(long[] nums){
        return (CheckUtil.needSort(nums));
    }

    public static boolean needSort(float[] nums){
        return (CheckUtil.needSort(nums));
    }

    public static boolean needSort(double[] nums){
        return (CheckUtil.needSort(nums));
    }

    public abstract void sort(int[] nums, boolean isAsc);
}
