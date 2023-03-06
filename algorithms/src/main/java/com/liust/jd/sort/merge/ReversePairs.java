package com.liust.jd.sort.merge;

import com.liust.jd.sort.Utils;

public class ReversePairs {
    public static void main(String[] args) {
        int[] data = Utils.buildArray(8, 100);
        Utils.printlnArray(data);
        Utils.printlnSplitLine();
    }

    public static void mergeSort(int[] data){
        if(!Utils.needSort(data)){
            return;
        }

        process(data, 0, data.length-1);
    }

    public static void process(int[] data, int left, int right){
        if(left==right){
            return;
        }
        int mid = left + ((right-left)>>1);
        process(data,left,mid);
        process(data,mid+1,right);
        merge(data, left, mid, right);
    }

    public static void merge(int[] data, int left, int mid, int right){
        int p1=left,p2=mid+1;
        int size = (right-left+1);
        int[] help = new int[size];
        int index = 0;

        while (p1<=mid && p2<=right){
            help[index++] = data[p1]<=data[p2]?data[p1++]:data[p2++];
        }

        while (p1<=mid){
            help[index++] = data[p1++];
        }

        while (p2<=right){
            help[index++] = data[p2++];
        }

        for (int i = 0; i < help.length; i++) {
            data[left+i] = help[i++];
        }
    }
}
