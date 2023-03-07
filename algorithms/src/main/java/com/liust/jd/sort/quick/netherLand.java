package com.liust.jd.sort.quick;

import com.liust.jd.sort.Utils;

/**
 * 1 <= , >
 * 2 <, =, >
 */
public class netherLand {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            testNetherLand2();
        }

    }

    public static void testNetherLand2(){

        int[] data = Utils.buildArray(8, 5);
        Utils.printlnArray(data);
        Utils.printlnSplitLine();
        netherLand2(data);
        Utils.printlnArray(data);
        Utils.printlnSplitLine("-");
    }

    public static void netherLand1(int[] data){
        if(!Utils.needSort(data)){
            return;
        }

        netherLandPro1(data, 0, data.length - 1);
    }

    public static void swap(int[] data, int i, int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void netherLandPro1(int[] data, int l, int r){
        if(l==r){
            return;
        }

        int lessIndex = l-1;
        int cur = l;
        int val = data[r];

        while (cur <= r){
            if(data[cur] <= val){
                swap(data, ++lessIndex, cur++);
            }else{
                cur++;
            }
        }

    }

    public static void netherLand2(int[] data){

        if(!Utils.needSort(data)){
            return;
        }

        netherLandPro2(data, 0, data.length - 1);
    }

    public static void netherLandPro2(int[] data, int l, int r){
        if(l==r){
            return;
        }

        int val = data[r];
        int cur = l;
        int lessIndex = l-1;
        int moreIndex = r+1;

        while (cur < moreIndex){
            if(data[cur] < val){// < val
                swap(data, ++lessIndex, cur++);
            }else if(data[cur] == val){ // == val
                cur++;
            }else{//>val
                swap(data, --moreIndex,cur);
            }
        }
    }

    /**
     * 1 quick sort 1
     * 2 quick sort 2
     * 3 quick sort 3
     * @param data
     */
    public static void quickSort1(int[] data){
        if(!Utils.needSort(data)){
            return;
        }

        quickSortPro1(data, 0, data.length-1);
    }

    private static void quickSortPro1(int[] data, int i, int r) {

    }
}
