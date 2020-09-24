package com.liust.jd.designpatterns.tank.factory;

import com.liust.jd.designpatterns.tank.*;
import com.liust.jd.designpatterns.tank.fire.FireStrategy;

public abstract class GameObjectFactory {
    public abstract Tank createGoodTank(TankFrame tf);
    public abstract Tank createBadTank(TankFrame tf);
    public abstract Bullet createBullet(Postion postion, Dir dir, Group group, TankFrame tf, FireStrategy fireStrategy);
    public abstract Explode createExplore(int x, int y, TankFrame tf);
}
