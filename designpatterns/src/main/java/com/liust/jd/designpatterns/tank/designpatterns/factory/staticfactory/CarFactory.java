package com.liust.jd.designpatterns.tank.designpatterns.factory.staticfactory;

import com.liust.jd.designpatterns.tank.designpatterns.factory.Car;

public class CarFactory {
    public Car getCar(){
        return new Car();
    }
}
