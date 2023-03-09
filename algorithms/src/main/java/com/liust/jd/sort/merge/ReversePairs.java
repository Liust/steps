package com.liust.jd.sort.merge;

import com.liust.jd.sort.Utils;

public class ReversePairs {
    public static void main(String[] args) {
        int[] data = Utils.buildArray(5, 100);
        Utils.printlnArray(data);
        Utils.printlnSplitLine();
        Utils.println(reversePairCount(data));
        Utils.printlnArray(data);

    }

    public static int reversePairCount(int[] data) {
        if (!Utils.needSort(data)) {
            return 0;
        }

        return process(data, 0, data.length - 1);
    }

    public static int process(int[] data, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + ((right - left) >> 1);
        int countLeft = process(data, left, mid);
        int countRight = process(data, mid + 1, right);
        int countMid = merge(data, left, mid, right);

        return countLeft + countMid + countRight;
    }

    public static int merge(int[] data, int left, int mid, int right) {
        int p1 = left, p2 = mid + 1;
        int size = (right - left + 1);
        int[] help = new int[size];
        int index = 0, count = 0;

        while (p1 <= mid && p2 <= right) {
            if (data[p1] > data[p2]) {
                help[index++] = data[p2++];
                count += (mid - p1 + 1);
            } else {
                help[index++] = data[p1++];
            }
        }

        while (p1 <= mid) {
            help[index++] = data[p1++];
        }

        while (p2 <= right) {
            help[index++] = data[p2++];
        }

        for (int i = 0; i < help.length; i++) {
            data[left + i] = help[i];
        }

        return count;
    }
}
