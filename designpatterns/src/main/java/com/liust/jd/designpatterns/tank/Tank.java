package com.liust.jd.designpatterns.tank;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Tank {
    private int x, y;
    private int width = 50, height = 50;
    private Dir dir = Dir.DOWN;
    private static final int speed = 5;
    public boolean moving = false;
    private boolean living = true;
    private TankFrame tf = null;
    private BufferedImage image = null;
    private Group group;

    List<Bullet> bulletList = new ArrayList<Bullet>();

    public Tank(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
    }

    public void paint(Graphics g){
        move();
//        g.fillRect(x, y, width, height);
        BufferedImage tank = null;
        switch (getDir()){
            case LEFT:
                tank = ResourceMgr.tankL;
                break;
            case UP:
                tank = ResourceMgr.tankU;
                break;
            case RIGHT:
                tank = ResourceMgr.tankR;
                break;
            case DOWN:
                tank = ResourceMgr.tankD;
                break;
        }
        g.drawImage(tank, x, y, null);
        this.setImage(tank);
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
        Bullet bullet = new Bullet(postion.getX(), postion.getY(), this.getDir(), getGroup(), this.tf);
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

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
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
        if(getImage() != null){
            return getImage().getWidth();
        }
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        if(getImage() != null){
            return getImage().getHeight();
        }
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
