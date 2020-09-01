package com.liust.jd.designpatterns.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    private static int width=400, height = 300;
    int x=40, y = 30;

    public boolean bL = false, bU=false, bR = false, bD=false;
    public boolean moving = true;

    TankFrame(){
        setSize(width, height);
        setResizable(false);
        setTitle("Tank");
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
//                System.out.println("released");
//                x+=30;
//                repaint();

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

                    default:
                        break;
                }
            }

            @Override
            public void keyPressed(KeyEvent e){
//                System.out.println("pressed");
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
                        moving = !moving;
                        break;

                    default:
                        break;
                }
            }
        });
    }

    @Override
    public void paint(Graphics g) {
//        System.out.println("paint");
        g.fillRect(x, y, 50, 50);
//        x += 10;
//        y += 10;
        if(bL){
            x -= 10;
        }

        if(bU){
            y -=10;
        }

        if(bR){
            x += 10;
        }

        if(bD){
            y += 10;
        }

    }
}
