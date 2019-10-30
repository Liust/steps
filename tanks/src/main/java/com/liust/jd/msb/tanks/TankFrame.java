package com.liust.jd.msb.tanks;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class TankFrame extends Frame {

    int x=100, y=100;

    public TankFrame(String title){
        setVisible(true);
        setSize(800, 600);
        setResizable(true);
        setTitle(title);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        addKeyListener( new lKeyListener());

    }

    class lKeyListener extends KeyAdapter{
        boolean bL = false;
        boolean bR = false;
        boolean bU = false;
        boolean bD = false;

        /**
         * key press 确定方向
         * @param e
         */
        @Override
        public void keyPressed(KeyEvent e) {
            char c = e.getKeyChar();
            if(c == 'a'){
                bL = true;
//                x-= 10;
            }else if(c == 'd'){
                bR = true;
//                x += 10;
            }else if(c == 'w'){
                bU = true;
//                y -= 10;
            }else if(c == 's'){
                bD = true;
//                y += 10;
            }else if(c == 'q'){
                System.exit(0);
            }else {
                System.out.println("key pressed : " + c);
            }

//            int key = e.getKeyCode();
//
//            switch (key)
//            case KeyEvent.VK_UP:
//                break;
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("key released");
            repaint();
        }
    }

    @Override
    public void paint(Graphics g){
        System.out.println("paint: " + System.currentTimeMillis());
        g.fillRect(x, y, 100,100);
//        x += 10;
//        y += 10;
    }


}
