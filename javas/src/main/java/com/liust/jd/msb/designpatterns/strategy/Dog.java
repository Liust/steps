package com.liust.jd.msb.designpatterns.strategy;

import java.util.Date;

public class Dog implements Animal, Comparable<Dog> {

    int height, weight;
    Date brithDate;
//
//    @Override
//    public int compareTo(Dog d) {
//        if(this.weight > d.weight) {
//            return 1;
//        }else if( this.weight < d.weight){
//            return -1;
//        }else {
//            return 0;
//        }
//    }
    @Override
    public int compareTo(Dog d) {
        if(this.height > d.height) {
            return 1;
        }else if( this.height < d.height){
            return -1;
        }else {
            return 0;
        }
    }

    @Override
    public long getAge() {
        return (System.currentTimeMillis() - brithDate.getTime());
    }

    @Override
    public String toString(){
        return "dog[height:" + this.height + ",weight:" + this.weight
                + ", age:" + this.getAge() + "]";
    }

    public Dog(int height, int weight, Date brithDate){
        this.height = height;
        this.weight = weight;
        this.brithDate = brithDate;
    }
}
