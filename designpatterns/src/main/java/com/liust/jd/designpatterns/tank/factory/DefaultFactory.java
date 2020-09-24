package com.liust.jd.designpatterns.tank.factory;

import com.liust.jd.designpatterns.tank.*;
import com.liust.jd.designpatterns.tank.fire.DefaultFireStrategy;
import com.liust.jd.designpatterns.tank.fire.FireStrategy;
import com.liust.jd.designpatterns.tank.fire.HighFireStrategy;

public class DefaultFactory extends GameObjectFactory {


    @Override
    public Tank createGoodTank(TankFrame tf) {
        return new Tank(150, 150, Dir.DOWN, Group.GOOD, tf, HighFireStrategy.getInstance());
    }

    @Override
    public Tank createBadTank(TankFrame tf) {
        return new Tank((tf.getX() + 30 )+ tf.getY() + 80, tf.getY() + 60, Dir.DOWN, Group.BAD, tf, DefaultFireStrategy.getInstance());
    }

    @Override
    public Bullet createBullet(Postion postion, Dir dir, Group group, TankFrame tf, FireStrategy fireStrategy) {
        Bullet bullet = new Bullet(postion.getX(), postion.getY(), dir, group, tf);

        new Thread( ()->{
            new Audio(Audio.TANK_FIRE).play();
        }).start();
        return bullet;
    }

    @Override
    public Explode createExplore(int x, int y, TankFrame tf) {
        return new Explode(x, y, tf);
    }
}
