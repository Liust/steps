package com.liust.jd.designpatterns.tank.designpatterns.factory.factorymethod;

import com.liust.jd.designpatterns.tank.designpatterns.factory.Car;

public class CarFactory {
    public Car getCar(){
        return new Car();
    }
}
