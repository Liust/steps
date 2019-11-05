package com.liust.jd.msb.designpatterns.strategy;

public class DogWeightCompartor implements Compartor<Dog> {

    @Override
    public int compares(Dog d1, Dog d2) {
        if(d1.weight > d2.weight){
            return 1;
        }else if(d1.weight < d2.weight){
            return -1;
        }else {
            return 0;
        }
    }
}
