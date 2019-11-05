package com.liust.jd.msb.designpatterns.strategy;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Dog[] dogs = {new Dog(5,2,new Date()),
                new Dog(8,6,new Date()),
                new Dog(1,4,new Date()),
                new Dog(7,5,new Date()),
                new Dog(3,1,new Date()),
                new Dog(6,6,new Date())};

        print(dogs);

        SortUtil<Dog> sortUtil = new SortUtil<Dog>();
        DogWeightCompartor comparator = new DogWeightCompartor();
        sortUtil.sort(dogs, comparator);

        print(dogs);
    }

    public static void print(Object[] objs){
        for(Object o : objs){
            System.out.print(o + ",");
        }
        System.out.println();

    }
}
