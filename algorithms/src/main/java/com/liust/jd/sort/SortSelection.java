package com.liust.jd.sort;

import com.liust.jd.sort.utils.CheckUtil;
import com.liust.jd.sort.utils.PrintUtil;

public class SortSelection extends SortBase{
    /**
     * selection sort
     * eg: asc select the min num in rest nums of the array, then swap
     *  desc select the max num in rest nums of the array, then swap
     * @param nums
     * @param asc
     */
    public void sort(int[] nums, boolean asc){
        if(!CheckUtil.needSort(nums)){
            return;
        }

        int minIndex = 0;
        for(int i=0; i< nums.length; i++){
            minIndex = i;
            for(int j=i+1; j<nums.length; j++){
                if(SortBase.needSwap(nums[minIndex], nums[j], asc)){
                    minIndex = j;
                }
            }
            CheckUtil.swap(nums, minIndex, i);
        }
    }

    public static void main(String[] args) {
        SortSelection sortSelection = new SortSelection();
        int[] nums = Data.getData();
        PrintUtil.println(nums);
        sortSelection.sort(nums, false);
        PrintUtil.println(nums);
        sortSelection.sort(nums, true);
        PrintUtil.println(nums);
    }
}
