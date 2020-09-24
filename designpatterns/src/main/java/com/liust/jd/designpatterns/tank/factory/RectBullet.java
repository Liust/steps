package com.liust.jd.designpatterns.tank.factory;

import com.liust.jd.designpatterns.tank.Bullet;
import com.liust.jd.designpatterns.tank.Dir;
import com.liust.jd.designpatterns.tank.Group;
import com.liust.jd.designpatterns.tank.TankFrame;

public class RectBullet extends Bullet {
    public RectBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        super(x, y, dir, group, tf);
    }
}
