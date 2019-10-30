package com.liust.jd.msb.tanks;

public class Starter {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame("Tank War");

        while (true){
            Thread.sleep(100);
            tf.repaint();
        }
    }
}
