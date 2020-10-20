package cn.sxt.game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Date;

/**
 * @ClassName Plane
 * @Description 飞机类，重要的一个类
 * @Author NightGlower
 * @Date 2020/5/21 18:36
 * @Version 1.0
 */
public class Plane extends GameObject {
    boolean left, right, up, down;


    //飞机的构造方法
    public Plane(Image img, double x, double y, int speed, int hp) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.hp = hp;
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
    }

    //封装，画出飞机实现键盘操控
    public void drawSelf(Graphics g) {
        g.drawImage(img, (int) x, (int) y, null);
        if (left) {
            x -= speed;
        }
        if (right) {
            x += speed;
        }
        if (up) {
            y -= speed;
        }
        if (down) {
            y += speed;
        }
    }

    //飞机的死亡方法
    public void die() {
        System.out.println("Game Over,坚持了" + MyGameFrame.time + "秒");
        if (MyGameFrame.time > 10) {
            System.out.println("哼，被你发现了么");
        } else System.out.println("辣鸡");
        System.exit(0);
    }

    //操控飞机:按下某个键位的效果
    public void addDirection(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                up = true;
                break;
            case KeyEvent.VK_S:
                down = true;
                break;
            case KeyEvent.VK_A:
                left = true;
                break;
            case KeyEvent.VK_D:
                right = true;
                break;

            //TODO 方便测试，一键自爆
            case KeyEvent.VK_Z:
                die();
        }
    }

    //操控飞机:松开某个键位的效果
    public void minusDirection(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                up = false;
                break;
            case KeyEvent.VK_S:
                down = false;
                break;
            case KeyEvent.VK_A:
                left = false;
                break;
            case KeyEvent.VK_D:
                right = false;
                break;
        }
    }
}
