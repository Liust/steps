package com.liust.jd.designpatterns.tank;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Tank {
    private int x, y;
    private int width = 50, height = 50;
    private Dir dir = Dir.DOWN;
    private static final int speed = 5;
    public boolean moving = true;
    private boolean living = true;
    private TankFrame tf = null;

    List<Bullet> bulletList = new ArrayList<Bullet>();

    public Tank(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g){
        move();
        g.fillRect(x, y, width, height);

        for(Bullet bullet : bulletList){
            bullet.paint(g);
        }
    }

    private void move() {
        if(!moving) return;
        switch (dir){
            case LEFT:
                x -= speed;
                break;
            case UP:
                y -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
            case DOWN:
                y += speed;
                break;
            default:
                break;
        }
    }

    public void fire(){
        Postion postion = computeBulletPos();
        Bullet bullet = new Bullet(postion.getX(), postion.getY(), this.getDir(), this.tf);
//        bulletList.add(bullet);
        tf.bullets.add(bullet);

    }

    public Postion computeBulletPos(){
        Postion pos = new Postion();
        int x = this.getX();
        int y = this.getY();

        switch (this.dir){
            case LEFT:
                y = y + this.getHeight()/2;
                x = x;
                break;
            case UP:
                y = y;
                x = x + this.getWidth() / 2;
                break;
            case RIGHT:
                y = y + this.getHeight()/2;
                x = x + this.getWidth();
                break;
            case DOWN:
                y = y + this.getHeight();
                x = x + this.getWidth() / 2;
                break;
            default:
                break;
        }

        pos.setX(x);
        pos.setY(y);
        return pos;
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

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
