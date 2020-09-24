package com.liust.jd.designpatterns.tank.designpatterns.factory.factorymethod;

import com.liust.jd.designpatterns.tank.designpatterns.factory.AK47;

public class AK47Factory {
    public AK47 getAK47(){
        return new AK47();
    }
}
