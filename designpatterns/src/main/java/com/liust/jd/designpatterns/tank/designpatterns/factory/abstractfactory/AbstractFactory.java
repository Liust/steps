package com.liust.jd.designpatterns.tank.designpatterns.factory.abstractfactory;

public abstract class AbstractFactory {
    abstract Food createFood();
    abstract Weapon createWeapon();
    abstract Vehicle createVehicle();
}
