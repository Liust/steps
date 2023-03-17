package com.liust.jd.sort.quick;

import com.liust.jd.sort.Utils;

/**
 * 1 <= , >
 * 2 <, =, >
 */
public class netherLand {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
//            testQuick1(8, 15);
//            testQuick2(7, 10);
            testQuick3(7, 4);
        }

    }

    public static void testQuick1(int size, int max) {
        int[] data = Utils.buildArray(size, max);
        Utils.printlnArray(data);
        Utils.printlnSplitLine();
        quickSortPro1(data, 0, data.length - 1);
        Utils.printlnArray(data);
        Utils.printlnSplitLine("-");
    }

    public static void testQuick2(int size, int max) {
        int[] data = Utils.buildArray(size, max);
        Utils.printlnArray(data);
        Utils.printlnSplitLine();
        quickSortPro2(data, 0, data.length - 1);
        Utils.printlnArray(data);
        Utils.printlnSplitLine("*");
    }

    public static void testQuick3(int size, int max) {
        int[] data = Utils.buildArray(size, max);
        Utils.printlnArray(data);
        Utils.printlnSplitLine();
        quickSortPro3(data, 0, data.length - 1);
        Utils.printlnArray(data);
        Utils.printlnSplitLine("*");
    }

    public static void testNetherLand2() {

        int[] data = Utils.buildArray(8, 5);
        Utils.printlnArray(data);
        Utils.printlnSplitLine();
        netherLand2(data);
        Utils.printlnArray(data);
        Utils.printlnSplitLine("-");
    }

    public static void netherLand1(int[] data) {
        if (!Utils.needSort(data)) {
            return;
        }

        netherLandPro1(data, 0, data.length - 1);
    }

    public static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void netherLandPro1(int[] data, int l, int r) {
        if (l == r) {
            return;
        }

        int lessIndex = l - 1;
        int cur = l;
        int val = data[r];

        while (cur <= r) {
            if (data[cur] <= val) {
                swap(data, ++lessIndex, cur++);
            } else {
                cur++;
            }
        }

    }

    public static void netherLand2(int[] data) {

        if (!Utils.needSort(data)) {
            return;
        }

        netherLandPro2(data, 0, data.length - 1);
    }

    public static void netherLandPro2(int[] data, int l, int r) {
        if (l == r) {
            return;
        }

        int val = data[r];
        int cur = l;
        int lessIndex = l - 1;
        int moreIndex = r + 1;

        while (cur < moreIndex) {
            if (data[cur] < val) {// < val
                swap(data, ++lessIndex, cur++);
            } else if (data[cur] == val) { // == val
                cur++;
            } else {//>val
                swap(data, --moreIndex, cur);
            }
        }
    }

    /**
     * 1 quick sort 1
     * 2 quick sort 2
     * 3 quick sort 3
     *
     * @param data
     */
    public static void quickSort1(int[] data) {
        if (!Utils.needSort(data)) {
            return;
        }

        quickSortPro1(data, 0, data.length - 1);
    }

    private static void quickSortPro1(int[] data, int l, int r) {
        if (l >= r) {
            return;
        }

        int pos = partition1(data, l, r);

        quickSortPro1(data, l, pos - 1);

        quickSortPro1(data, pos + 1, r);

    }

    private static int partition1(int[] data, int l, int r) {

        int index = Integer.MAX_VALUE;

        int val = data[r];
        int cur = l, lessIndex = l - 1;
        while (cur < r) {
            if (data[cur] < val) {
                swap(data, ++lessIndex, cur++);
            } else if (data[cur] == val) {
                swap(data, ++lessIndex, cur++);
            } else {
                cur++;
            }
        }

        swap(data, ++lessIndex, r);
        index = lessIndex;

        return index;
    }

    private static int[] partition2(int[] data, int l, int r) {
        int[] pos = new int[2];

        int lessIndex = l - 1;
        int moreIndex = r, cur = l;
        while (cur < moreIndex) {
            if (data[cur] < data[r]) {
                swap(data, ++lessIndex, cur++);
            } else if (data[cur] == data[r]) {
                cur++;
            } else {
                swap(data, --moreIndex, cur);
            }
        }

        swap(data, moreIndex, r);

        pos[0] = lessIndex + 1;
        pos[1] = moreIndex;

        return pos;
    }

    private static void quickSortPro2(int[] data, int l, int r) {
        if (l >= r) {
            return;
        }

        int[] pos = partition2(data, l, r);

        quickSortPro2(data, l, pos[0] - 1);

        quickSortPro2(data, pos[1] + 1, r);
    }

    /**
     * todo: random index as the target value
     *
     * @param data
     * @param l
     * @param r
     */
    private static void quickSortPro3(int[] data, int l, int r) {
        if (l >= r) {
            return;
        }

        int index = l + Utils.genInt(r - l + 1);
        swap(data, index, r);
        int[] pos = partition3(data, l, r);
        quickSortPro3(data, l, pos[0] - 1);
        quickSortPro3(data, pos[1] + 1, r);
    }

    public static int[] partition3(int[] data, int l, int r) {
        int lessIndex = l - 1, moreIndex = r;
        int val = data[r], index = l;

        while (index < moreIndex) {
            if (data[index] < val) {
                swap(data, ++lessIndex, index++);
            } else if (data[index] == val) {
                index++;
            } else {
                swap(data, index, --moreIndex);
            }
        }

        swap(data, r, moreIndex);

        int[] pos = new int[2];
        pos[0] = lessIndex+1;
        pos[1] = moreIndex;

        return pos;
    }

    /**
     * todo:  with stack and no recursive
     *
     * @param data
     * @param l
     * @param r
     */
    private static void quickSortProNoRecursive(int[] data, int l, int r) {

    }
}
