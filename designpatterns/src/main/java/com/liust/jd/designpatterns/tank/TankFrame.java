package com.liust.jd.designpatterns.tank;

import com.liust.jd.designpatterns.tank.fire.BasicFire;
import com.liust.jd.designpatterns.tank.fire.HighFire;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {
    private static int width = 800, height = 600;
    private Color color = Color.GRAY;

    private Tank tank = new Tank(150, 150, Dir.DOWN, Group.GOOD, this, HighFire.getInstance());
    public List<Bullet> bullets = new ArrayList<Bullet>();
    public List<Tank> tanks = new ArrayList<Tank>();
    public List<Explode> explodes = new ArrayList<Explode>();

    TankFrame(){
        setSize(width, height);
        setResizable(false);
        setBackground(Color.GRAY);
        setTitle("Tank");
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                quit();
            }
        });

        addKeyListener(new KeyAdapter() {

            public boolean bL = false, bU = false, bR = false, bD = false;

            @Override
            public void keyReleased(KeyEvent e) {

                int key = e.getKeyCode();
                switch (key) {
                    case KeyEvent.VK_LEFT:
                        bL = false;
                        break;
//                    case KeyEvent.VK_A:
//                        bL = false;
//                        break;
                    case KeyEvent.VK_UP:
                        bU = false;
                        break;
//                    case KeyEvent.VK_W:
//                        bU = false;
//                        break;
                    case KeyEvent.VK_RIGHT:
                        bR = false;
                        break;
//                    case KeyEvent.VK_D:
//                        bR = false;
//                        break;
                    case KeyEvent.VK_DOWN:
                        bD = false;
                        break;
//                    case KeyEvent.VK_S:
//                        bD = false;
//                        break;
                    case KeyEvent.VK_BACK_SPACE:
                        quit();
                        break;
                    case KeyEvent.VK_SPACE:
                        tank.fire();
                        break;

                    default:
                        break;
                }

                setMainTankDir();
            }

            @Override
            public void keyPressed(KeyEvent e){
                int key = e.getKeyCode();
                switch (key) {
                    case KeyEvent.VK_LEFT:
                        bL = true;
                        break;
                    case KeyEvent.VK_UP:
                        bU = true;
                        break;
                    case KeyEvent.VK_RIGHT:
                        bR = true;
                        break;
                    case KeyEvent.VK_DOWN:
                        bD = true;
                        break;

                    default:
                        break;
                }

                setMainTankDir();
            }

            void setMainTankDir(){
                if(!(bL || bU || bR || bD)){
                    tank.setMoving(false);
                }else {
                    tank.setMoving(true);
                    if (bL) tank.setDir(Dir.LEFT);
                    if (bU) tank.setDir(Dir.UP);
                    if (bR) tank.setDir(Dir.RIGHT);
                    if (bD) tank.setDir(Dir.DOWN);
                }
            }
        });

//        Audio a = new Audio("audio/war1.wav");
//        a.loop();
    }

    private void quit() {
        System.exit(0);
    }

    @Override
    public void paint(Graphics g) {

        g.drawString("B数量：" + bullets.size(), 10, 60);
        g.drawString("T数量：" + tanks.size(), 110, 60);
        g.drawString("E数量：" + explodes.size(), 210, 60);

        tank.paint(g);
//        bullet.paint(g);
//        for(Bullet b : bullets){
//            b.paint(g);
//        }

        //碰撞检测
        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < tanks.size(); j++) {
                pengTest(bullets.get(i), tanks.get(j));
            }
        }

        for(int i = 0; i < bullets.size(); i++){
            Bullet b = bullets.get(i);
            b.paint(g);
        }

        for(int i = 0; i < tanks.size(); i++){
            Tank b = tanks.get(i);
            b.paint(g);
        }

        for(int i = 0; i < explodes.size(); i++){
            Explode b = explodes.get(i);
            if(b.isLiving()) {
                b.paint(g);
            }else {
                explodes.remove(b);
            }
        }
    }

    private void pengTest(Bullet bullet, Tank tank) {
        if(bullet.getGroup() == tank.getGroup()){
            return;
        }

        if(bullet.getRect().intersects(tank.getRect())){
            bullet.die();
            tank.die();
            explodes.add(new Explode(tank.getX(), tank.getY(), this));
        }
    }

    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if(null == offScreenImage){
            offScreenImage = this.createImage(width, height);
        }

        Graphics graphics = offScreenImage.getGraphics();
        Color c = graphics.getColor();
        graphics.setColor(color);
        graphics.fillRect(0, 0, width, height);
        graphics.setColor(c);
        paint(graphics);

        g.drawImage(offScreenImage, 0, 0, null);

    }
}
