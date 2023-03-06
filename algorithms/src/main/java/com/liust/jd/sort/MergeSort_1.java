package com.liust.jd.sort;

/**
 * merge sort
 * 1 recursive way
 * 2 no recursive way
 */
public class MergeSort_1 {
    public static void main(String[] args) {
        System.out.println("Hello world !! ");
        int[] data = Utils.buildArray(6, 50);
        Utils.printlnArray(data);
        Utils.printlnLine("-");
        process2(data);
        Utils.printlnArray(data);
    }

    public static void mergeSort(int[] arr, int left, int right){

        if(left == right){
            return;
        }

        int mid = left + ((right - left)>>1);
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);

    }

    public static void merge(int[] arr, int left, int mid, int right){
        int size = right - left + 1;
        int[] help = new int[size];

        int index = 0, p1 = left;
        int p2 = mid + 1;

        while (p1 <= mid && p2 <= right){
            help[index++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid){
            help[index++] = arr[p1++];
        }

        while (p2<=right){
            help[index++] = arr[p2++];
        }

        for (int i = 0; i < help.length; i++) {
            arr[left+i] = help[i];
        }

    }

    public static void mergeSortNoRecursion(int[] arr, int left, int right){

        int step = 1;
        int size = (right - left + 1);


        while (step < size){
            int l = left;

            while (getMid(l, step) <= right){

                int mid = getMid(l, step);
                int r = Math.min(mid + step, right);
                merge(arr, l, mid, r);

                l = r+1;
            }

            if(step > (size >> 1)){
                break;
            }

            step <<= 1;
        }
    }

    public static int getMid(int left, int step){
        return left + step -1;
    }

    public static boolean needSort(int[] data){
        if(data == null || data.length < 2){
            return false;
        }

        return true;
    }

    public static void process(int[] data){
        if(!needSort(data)){
            return;
        }
        mergeSort(data, 0, data.length-1);
    }

    public static void process2(int[] data){
        if(!needSort(data)){
            return;
        }
        mergeSortNoRecursion(data, 0, data.length-1);
    }




















}
