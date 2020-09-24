package com.liust.jd.designpatterns.tank.factory;

import com.liust.jd.designpatterns.tank.*;
import com.liust.jd.designpatterns.tank.fire.FireStrategy;

public class RectFactory extends GameObjectFactory {
    @Override
    public Tank createGoodTank(TankFrame tf) {
        return null;
    }

    @Override
    public Tank createBadTank(TankFrame tf) {
        return null;
    }

    @Override
    public Bullet createBullet(Postion postion, Dir dir, Group group, TankFrame tf, FireStrategy fireStrategy) {
        return null;
    }

    @Override
    public Explode createExplore(int x, int y, TankFrame tf) {
        return null;
    }
}
