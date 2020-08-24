package com.liust.jd.sort;

public class SortInsertion extends SortBase{
    @Override
    public void sort(int[] nums, boolean isAsc) {
        if(!needSort(nums)){
            return;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = i-1; j >= 0; j--) {
                if(needSwap(nums[j], nums[j+1], isAsc)){
                    swap(nums, j, j+1);
                }
            }
        }
    }
}
