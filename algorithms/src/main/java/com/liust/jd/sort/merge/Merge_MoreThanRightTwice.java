package com.liust.jd.sort.merge;

import com.liust.jd.sort.Utils;

public class Merge_MoreThanRightTwice {
    public static void main(String[] args) {
        int[] data = Utils.buildArray(6, 20);
        Utils.printlnArray(data);
        Utils.printlnSplitLine();
        int count = rightTwice(data);
        Utils.printlnArray(data);
        Utils.println(count);
    }

    public static int rightTwice(int[] data) {
        if (!Utils.needSort(data)) {
            return 0;
        }

//        process(data, 0, data.length - 1);
        return processAndCount(data, 0, data.length - 1);
    }

    public static void process(int[] data, int l, int r) {
        if (l == r) {
            return;
        }

        int mid = l + ((r - l) >> 1);
        process(data, l, mid);
        process(data, mid + 1, r);
        merge(data, l, mid, r);
    }

    public static int processAndCount(int[] data, int l, int r) {
        if (l == r) {
            return 0;
        }

        int mid = l + ((r - l) >> 1);
        return processAndCount(data, l, mid) + processAndCount(data, mid + 1, r) + mergeAndCountTwice(data, l, mid, r);
    }

    /**
     * //todo there is bug in the code
     * @param data
     * @param l
     * @param mid
     * @param r
     * @return
     */
    public static int mergeAndCountTwice(int[] data, int l, int mid, int r) {
        int p1 = mid, p2 = r;
        int size = r - l + 1, index = size-1;
        int[] help = new int[size];
        int count = 0;

        while (p1 >= l && p2 >= mid+1) {
            if (data[p1] > data[p2] * 2) {
                count += (mid - p1 + 1) * (p2 - mid);
            }
            help[index--] = data[p1] > data[p2] ? data[p1--] : data[p2 --];
        }

        while (p1 >= l) {
            help[index--] = data[p1--];
        }

        while (p2 >= mid+1) {
            help[index--] = data[p2--];
        }

        for (int i = 0; i < help.length; i++) {
            data[l + i] = help[i];
        }

        return count;
    }


    public static void merge(int[] data, int l, int mid, int r) {
        int p1 = l, p2 = mid + 1;
        int index = 0, size = (r - l + 1);
        int[] help = new int[size];

        while (p1 <= mid && p2 <= r) {
            help[index++] = data[p1] > data[p2] ? data[p2++] : data[p1++];
        }

        while (p1 <= mid) {
            help[index++] = data[p1++];
        }

        while (p2 <= r) {
            help[index++] = data[p2++];
        }

        for (int i = 0; i < help.length; i++) {
            data[l + i] = help[i];
        }

    }
}
