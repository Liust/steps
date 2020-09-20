package com.liust.jd.designpatterns.tank.fire;

import com.liust.jd.designpatterns.tank.*;

public class HighFireStrategy implements FireStrategy {

    private static HighFireStrategy instance = new HighFireStrategy();
    private HighFireStrategy(){}
    public static HighFireStrategy getInstance(){
        return instance;
    }


    @Override
    public void fire(int x, int y, Dir dir, Group group, TankFrame tf) {

        Bullet bullet = new Bullet(x, y, dir, group, tf);
        Bullet bulletDown = new Bullet(x, y, Dir.DOWN, group, tf);
        tf.bullets.add(bullet);
        tf.bullets.add(bulletDown);

        new Thread( ()->{
            new Audio(Audio.TANK_FIRE).play();
        }).start();

    }
}
