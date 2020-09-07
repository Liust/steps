package com.liust.jd.designpatterns.tank;

import java.awt.*;

public class Explode {
    public static int x, y;
    private boolean living = true;
    private TankFrame tf = null;
    private int step = 0;

    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
    }

    public void paint(Graphics g){
        g.drawImage(ResourceMgr.explodes[step++], this.getX(), this.getY(), null);
        if(step >= 16){
            this.setLiving(false);
        }
    }



    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public TankFrame getTf() {
        return tf;
    }

    public void setTf(TankFrame tf) {
        this.tf = tf;
    }
}
