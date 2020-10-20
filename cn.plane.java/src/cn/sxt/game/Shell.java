package cn.sxt.game;

import java.awt.*;

/**
 * @ClassName Shell
 * @Description 子弹类
 * @Author NightGlower
 * @Date 2020/5/21 22:12
 * @Version 1.0
 */
public class Shell extends GameObject {
    double degree;

    //重构出自带属性
    public Shell() {
        x = 200;
        y = 200;
        width = 20;
        height = 20;
        speed = 10;
        //生成一个随机数，也就是飞行的角度
        degree = Math.random() * Math.PI * 2;
    }

    public void draw(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillOval((int) x, (int) y, width, height);

        //子弹沿着任意的角度去飞行
        x += speed * Math.cos(degree);
        y += speed * Math.sin(degree);

        //让子弹拥有反弹效果
        if (x < 0 || x > Constant.GAME_WIDTH - width) {
            degree = Math.PI - degree;
        }
        if (y < 30 || y > Constant.GAME_HEIGHT - height) {
            degree = -degree;
        }

        //归还颜色
        g.setColor(c);
    }


}
