package com.liust.jd.designpatterns.tank.designpatterns.factory.factorymethod;

import com.liust.jd.designpatterns.tank.designpatterns.factory.Bread;

public class BreadFactory {
    public Bread createBread(){
        return new Bread();
    }
}
