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

        Dir[] dirs = Dir.values();
        for(Dir d : dirs) {
            Bullet bullet = new Bullet(x, y, d, group, tf);
            tf.bullets.add(bullet);
        }

        new Thread( ()->{
            new Audio(Audio.TANK_FIRE).play();
        }).start();

    }
}
