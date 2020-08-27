package com.liust.jd.sort;

import com.liust.jd.utils.PrintUtil;

public class TestUtil {
    public static void main(String[] args) {
        SortBase sortBase = getSortBase();
//        SortBase sortBase = new SortBubble();

        int[] data = Data.getRandomDataArr(10);
        PrintUtil.println(data);
        boolean isAsc = true;
        sortBase.sort(data, isAsc);
        PrintUtil.println(data);
        sortBase.sort(data, (!isAsc));
        PrintUtil.println(data);

    }

    public static SortBase getSortBase(){
        return new SortInsertion();
//        return new SortSelection();
    }
}
