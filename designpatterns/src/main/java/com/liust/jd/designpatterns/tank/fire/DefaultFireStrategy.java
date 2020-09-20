package com.liust.jd.designpatterns.tank.fire;

import com.liust.jd.designpatterns.tank.*;

public class DefaultFireStrategy implements FireStrategy {

    private static DefaultFireStrategy fire = new DefaultFireStrategy();
    private DefaultFireStrategy(){}

    public static DefaultFireStrategy getInstance(){
        return fire;
    }

    @Override
    public void fire(int x, int y, Dir dir, Group group, TankFrame tf) {
        Bullet bullet = new Bullet(x, y, dir, group, tf);

        new Thread( ()->{
            new Audio(Audio.TANK_FIRE).play();
        }).start();

        tf.bullets.add(bullet);

    }
}
