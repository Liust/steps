package com.liust.jd.designpatterns.tank.factory;

import com.liust.jd.designpatterns.tank.Explode;
import com.liust.jd.designpatterns.tank.TankFrame;

public class RectExplode extends Explode {
    public RectExplode(int x, int y, TankFrame tf) {
        super(x, y, tf);
    }
}
