package com.liust.jd.designpatterns.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    private static int width = 800, height = 600;
    private Color color = Color.GRAY;

    private Tank tank = new Tank(40, 30, Dir.LEFT);
    private Bullet bullet = new Bullet(40, 30, Dir.DOWN);

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
                    case KeyEvent.VK_UP:
                        bU = false;
                        break;
                    case KeyEvent.VK_RIGHT:
                        bR = false;
                        break;
                    case KeyEvent.VK_DOWN:
                        bD = false;
                        break;
                    case KeyEvent.VK_BACK_SPACE:
                        quit();
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
                    case KeyEvent.VK_SPACE:
                        tank.fire();
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
    }

    private void quit() {
        System.exit(0);
    }

    @Override
    public void paint(Graphics g) {
        tank.paint(g);
//        bullet.paint(g);
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
