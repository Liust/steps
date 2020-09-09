package com.liust.jd.designpatterns.tank;

public class BootStrap {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();

        for (int i = 0; i < 5; i++) {
            tf.tanks.add(new Tank((tf.getX() + 30 )+ i*80, tf.getY() + 60, Dir.DOWN, Group.BAD, tf));
        }

        while (true){
            Thread.sleep(100);
            tf.repaint();
        }
    }
}
