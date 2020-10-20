package cn.sxt.game;

import java.awt.*;

/**
 * @ClassName Boon
 * @Description FIXME 爆炸类 但是实现有问题，Bug未解决
 * @Author NightGlower
 * @Date 2020/5/23 17:11
 * @Version 1.0
 */
public class Boon {
    double x, y;

    public Boon(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //创建静态对象和图片
    static Image[] imgs = new Image[16];

    static {
        for (int i = 0; i <= 16; i++) {
            imgs[i] = GameUtil.getImage("images/boon/e" + (i + 1) + ".gif");
            imgs[i].getWidth(null);
        }
    }


    int count;

    //画出爆炸方法
    public void draw(Graphics g) {
        if (count <= 15) {
            g.drawImage(imgs[count], (int) x, (int) y, null);
            count++;
        }
    }

}
