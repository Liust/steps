package com.liust.jd.sort.merge;

import com.liust.jd.sort.Utils;

public class Merge_MoreThanRightTwice {
    public static void main(String[] args) {
        int[] data = Utils.buildArray(10, 30);
        Utils.printlnArray(data);
    }

    public static void rightTwice(int[] data){
        if(!Utils.needSort(data)){
            return;
        }

        process(data, 0, data.length-1);
    }
    public static void process(int[] data, int l, int r){
        if(l==r){
            return;
        }

        int mid = l + ((r-l)>>1);
        process(data, l, mid);
        process(data, mid+1, r);
        merge(data, l, mid, r);
    }


    public static void merge(int[] data, int l, int mid, int r) {

    }
}
