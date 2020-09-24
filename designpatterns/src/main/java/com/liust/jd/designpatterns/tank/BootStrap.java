package com.liust.jd.designpatterns.tank;

public class BootStrap {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();
        Integer tankCount = Integer.parseInt((String)PropertyMgr.get("initTankCount"));

        for (int i = 0; i < tankCount; i++) {
            tf.tanks.add(tf.getFactory().createBadTank(tf));
        }

        new Thread( () ->{
            new Audio(Audio.BGM).loop();
        }).start();

        while (true){
            Thread.sleep(100);
            tf.repaint();
        }
    }
}
