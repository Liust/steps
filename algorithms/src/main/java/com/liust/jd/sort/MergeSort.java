package com.liust.jd.sort;

public class MergeSort {
    public static void main(String[] args) {
        System.out.println("hello world, mergeSort !! ");
        int[] arr = buildArray(13, 20);
        Utils.printlnArray(arr);
        process(arr, 0, arr.length - 1);
        Utils.printlnArray(arr);
    }

    private static int[] buildArray(int size, int max) {
        if(size < 1){
            return null;
        }

        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = Utils.genInt(max);
        }
        return data;
    }

    /**
     * mergeSort main process
     *
     *  //todo some check point
     *  // 1 array is null , length is 0, 1, 2, 3
     */
    public static void process(int[] arr, int left, int right){

        if(left == right){
            return;
        }

        int mid = left + ((right-left)>>1);
        process(arr, left, mid);
        process(arr, mid+1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right){
        int p1 = left;
        int p2 = mid+1;
        int[] data = new int[right - left + 1];

        int index = 0;
        while(p1<=mid && p2<=right ){
            data[index++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1<=mid) {
            data[index++] = arr[p1++];
        }

        while (p2<=right){
            data[index++] = arr[p2++];
        }

        for (int i = 0; i < data.length; i++) {
            arr[left+i] = data[i];
        }

    }

    public static void anotherPro(int[] arr, int left, int right){

        int step = 1;
        while (step < arr.length){

            int index = 0;
            while (index < arr.length){
//                merge(arr, index ,);
            }

            step <<= 1;
        }

    }
}