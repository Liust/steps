package com.liust.jd.designpatterns.tank;

import com.liust.jd.designpatterns.tank.fire.FireStrategy;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Tank {
    private int x, y;
    private int width = 50, height = 50;
    private Dir dir = Dir.DOWN;
    private static final int speed = 8;
    public boolean moving = true;
    private boolean living = true;
    private TankFrame tf = null;
    private BufferedImage image = null;
    private Random random = new Random();
    private Group group;
    Rectangle rect =  new Rectangle();
    FireStrategy fireStrategy;

    public Tank(int x, int y, Dir dir, Group group, TankFrame tf, FireStrategy fireStrategy) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
        this.fireStrategy = fireStrategy;

        rect.x = this.getX();
        rect.y = this.getY();
        rect.height = this.getHeight();
        rect.width = this.getWidth();
    }

    public void die() {
        this.setLiving(false);
    }

    public void paint(Graphics g){

        if(!isLiving()){
            tf.tanks.remove(this);
            return;
        }

        move();
//        g.fillRect(x, y, width, height);
        BufferedImage tank = null;
        switch (getDir()){
            case LEFT:
                tank = (group == Group.BAD ? ResourceMgr.badTankL : ResourceMgr.goodTankL);
                break;
            case UP:
                tank = (group == Group.BAD ? ResourceMgr.badTankU : ResourceMgr.goodTankU);
                break;
            case RIGHT:
                tank = (group == Group.BAD ? ResourceMgr.badTankR : ResourceMgr.goodTankR);
                break;
            case DOWN:
                tank = (group == Group.BAD ? ResourceMgr.badTankD : ResourceMgr.goodTankD);
                break;
        }
        g.drawImage(tank, x, y, null);
        this.setImage(tank);

        if(getGroup() == Group.BAD && random.nextInt(100) > 90){
            this.fire();
        }

        if(getGroup() == Group.BAD && random.nextInt(100) > 90){
            this.randomDir();
        }

        boundsCheck();
    }

    private void boundsCheck() {
        // left
        if(getX() - tf.getX() < 2){
            this.setX(2);
        }

        // right
        if(this.getX() - tf.getX() > tf.getWidth() - this.getWidth()){
            setX(tf.getX()+ tf.getWidth() - this.getWidth());
        }

        // up todo there is a bug
        if(getY() - tf.getY() < getHeight() + 50){
            this.setY(getHeight() + 50);
        }

        // down
        if(this.getY() - tf.getY() > tf.getHeight()- this.getHeight()){
            setY(tf.getY() + tf.getHeight() - this.getHeight());
        }

    }

    private void randomDir() {
        this.setDir(Dir.values()[random.nextInt(4)]);
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
        // update
        rect.x = this.getX();
        rect.y = this.getY();
    }

    public void fire(){

//        fire.fire();
        Postion postion = computeBulletPos();
        fireStrategy.fire(postion.getX(), postion.getY(), this.getDir(), getGroup(), this.tf);

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

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
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

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public Rectangle getRect() {
        return rect;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }
}
