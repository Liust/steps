package com.liust.jd.msb.designpatterns.strategy;

public class DogHeightCompartor implements Compartor<Dog> {

    @Override
    public int compares(Dog d1, Dog d2) {
        if(d1.height > d2.height){
            return 1;
        }else if(d1.height < d2.height){
            return -1;
        }else {
            return 0;
        }
    }
}
