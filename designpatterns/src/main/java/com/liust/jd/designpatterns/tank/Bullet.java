package com.liust.jd.designpatterns.tank;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Bullet {
    public int x, y;
    private int width =10, height = 10;
    private Dir dir = Dir.DOWN;
    private static final int speed = 10;
    private boolean living = true;
    private TankFrame tf = null;
    private BufferedImage image;
    private Group group;
    Rectangle rect =  new Rectangle();

    public Bullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;

        rect.x = this.getX();
        rect.y = this.getY();
        rect.height = this.getHeight();
        rect.width = this.getWidth();

        tf.bullets.add(this);
    }

    public void paint(Graphics g){
        if(!isLiving()){
            tf.bullets.remove(this);
//            return;
        }

        switch (getDir()){
            case LEFT:
                setImage(ResourceMgr.bulletL);
                break;
            case UP:
                setImage(ResourceMgr.bulletU);
                break;
            case RIGHT:
                setImage(ResourceMgr.bulletR);
                break;
            case DOWN:
                setImage(ResourceMgr.bulletD);
                break;
        }

        g.drawImage(getImage(), x, y, null);
        move();
    }

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    private void move() {
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

        // update
        rect.x = this.getX();
        rect.y = this.getY();

        if(x < 0 || y < 0 || x - tf.getX() > tf.getWidth() || y - tf.getY() > tf.getHeight()){
            die();
        }
    }

    public void die() {
        this.setLiving(false);
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

    public static int getSpeed() {
        return speed;
    }

    public TankFrame getTf() {
        return tf;
    }

    public void setTf(TankFrame tf) {
        this.tf = tf;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Rectangle getRect() {
        return rect;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }
}
