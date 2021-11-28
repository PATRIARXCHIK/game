package main;

import entity.Entity;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler  implements KeyListener {

    public boolean  upPressed, downPressed, leftPressed, rightPressed, speedy;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {




int code = e.getKeyCode();


if (code == KeyEvent.VK_SHIFT){
    speedy = true;
}



        if(code == KeyEvent.VK_W){
 upPressed = true;
        }



        if(code == KeyEvent.VK_S){
downPressed = true;
        }



        if(code == KeyEvent.VK_A){
leftPressed = true;
        }



        if(code == KeyEvent.VK_D){
rightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
 int code = e.getKeyCode();

        if (code == KeyEvent.VK_SHIFT){
            speedy = false;
        }



        if(code == KeyEvent.VK_W){
            upPressed = false;
        }



        if(code == KeyEvent.VK_S){
            downPressed = false;
        }



        if(code == KeyEvent.VK_A){
            leftPressed = false;
        }



        if(code == KeyEvent.VK_D){
            rightPressed = false;
        }
    }
}
