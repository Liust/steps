package com.liust.jd.designpatterns.tank.fire;

import com.liust.jd.designpatterns.tank.Bullet;
import com.liust.jd.designpatterns.tank.Dir;
import com.liust.jd.designpatterns.tank.Group;
import com.liust.jd.designpatterns.tank.TankFrame;

public interface FireStrategy {
    void fire(int x, int y, Dir dir, Group group, TankFrame tf);
}
