package com.liust.jd.sort;

public class MinSum{

    public static void main(String[] args) {
        int[] arr = {32,1,43};
        mergeByStep(arr);
        System.out.println("ok");
    }

    public static void mergeByStep(int[] arr){
        int step = 1;
        while (step < arr.length){

            int index = 0;
            while (index < arr.length){
                int leftEnd = index+step-1;
                int right = index+step;
                int rightEnd = Math.min(right+step-1, arr.length-1);
                if(leftEnd >= arr.length || right >= arr.length){
                    break;
                }

                merge(arr, index, leftEnd, right, rightEnd);
                index += rightEnd+1;
            }

            if(step > arr.length/2){
                break;
            }
            step <<=1;
        }
    }
    
    public static int process(int[] arr, int left, int right){
        if(left == right){
            return 0;
        }

        int mid = left + (right - left)>>1;
        int minLeft = process(arr, left, mid);
        int minRight = process(arr, mid+1, right);

        int mergeSum = mergeAndGetMinSum(arr, left, mid, mid + 1, right);

        return minLeft + minRight + mergeSum;
    }


    public static int mergeAndGetMinSum(int[] arr, int left, int leftEnd,
                                        int right, int rightEnd){

        int minSum = 0;

        int p1=left, p2=right;
        int size = (leftEnd-left + 1) + (rightEnd - right + 1);
        int[] data = new int[size];
        int index=0;
        for (;p1<=leftEnd && p1<=rightEnd; index++){
            if(arr[p1] < arr[p2]){
                minSum += (rightEnd-p2 + 1) * arr[p1];
            }
            data[index] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1<=leftEnd){
            data[index++] = arr[p1++];
        }

        while (p2<=rightEnd){
            data[index++] = arr[p2++];
        }

        index = 0;
        p1=left;
        p2=right;

        while (p1<=leftEnd){
            arr[p1++] = data[index++];
        }
        while (p2<=rightEnd){
            arr[p2++] = data[index++];
        }

        return minSum;
    }




    private static void merge(int[] arr, int left, int leftEnd, int right, int rightEnd) {

        int p1 = left;
        int p2 = right;
        int size = leftEnd - left + 1 + (rightEnd - right + 1);
        int[] data = new int[size];
        int index = 0;
        while (p1<=leftEnd && p2<=rightEnd){
            data[index++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= leftEnd){
            data[index++] = arr[p1++];
        }

        while (p2 <= rightEnd){
            data[index++] = arr[p2++];
        }

        index = 0;
        p1=left;
        p2=right;

        while (p1 <= leftEnd){
            arr[p1++] = data[index++];
        }
        while (p2<=rightEnd){
            arr[p2++] = data[index++];
        }
    }
}
