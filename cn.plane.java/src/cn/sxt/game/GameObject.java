package cn.sxt.game;

import java.awt.*;

/**
 * @ClassName GameObject
 * @Description 该类是从所有物体中抽离出来的属性而形成的根类
 * @Author NightGlower
 * @Date 2020/5/21 18:19
 * @Version 1.0
 */
public class GameObject {
    int hp;
    Image img;
    double x, y;
    int speed;
    int width, height;

    // 三个构造函数
    public GameObject() {
    }

    public GameObject(Image img, double x, double y) {
        this.img = img;
        this.x = x;
        this.y = y;
    }

    public GameObject(Image img, double x, double y, int speed, int width, int height) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;
    }

    //返回物体的坐标和矩形信息，便于检测碰撞
    public Rectangle getRect() {
        return new Rectangle((int) x, (int) y, width, height);
    }

}
