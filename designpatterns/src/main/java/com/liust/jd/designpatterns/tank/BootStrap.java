package com.liust.jd.designpatterns.tank;

public class BootStrap {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();

        while (true){
            Thread.sleep(100);
            tf.repaint();
        }
    }
}
