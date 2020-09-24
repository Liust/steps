package com.liust.jd.designpatterns.tank.factory;

import com.liust.jd.designpatterns.tank.Dir;
import com.liust.jd.designpatterns.tank.Group;
import com.liust.jd.designpatterns.tank.Tank;
import com.liust.jd.designpatterns.tank.TankFrame;
import com.liust.jd.designpatterns.tank.fire.FireStrategy;

public class RectTank extends Tank {
    public RectTank(int x, int y, Dir dir, Group group, TankFrame tf, FireStrategy fireStrategy) {
        super(x, y, dir, group, tf, fireStrategy);
    }
}
