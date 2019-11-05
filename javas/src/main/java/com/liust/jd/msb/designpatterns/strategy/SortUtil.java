package com.liust.jd.msb.designpatterns.strategy;

public class SortUtil<T> {
//    public void sort(Comparable[] data){
//        for(int i=0; i<data.length; i++){
//
//            for(int j=i; j<data.length; j++){
//                if(data[i].compareTo(data[j]) > 0 ){
//                    swap(data, i, j);
//                }
//            }
//        }
//    }

    public void sort(T[] data, Compartor<T> c){
        for(int i=0; i<data.length; i++){

            for(int j=i; j<data.length; j++){
                if(c.compares(data[i],data[j]) > 0 ){
                    swap(data, i, j);
                }
            }
        }
    }

    private void swap(T[] data, int i, int j){
        T c = data[i];
        data[i] = data[j];
        data[j] = c;
    }
}
