package cn.sxt.game;

import java.awt.*;

/**
 * @ClassName Bg
 * @Description 背景类，没什么好说的
 * @Author NightGlower
 * @Date 2020/5/21 18:49
 * @Version 1.0
 */
public class Bg extends GameObject {

    public Bg(Image img, double x, double y) {
        super(img, x, y);
    }

    //封装，画出背景
    public void drawSelf(Graphics g) {
        g.drawImage(img, (int) x, (int) y, null);
    }


}
