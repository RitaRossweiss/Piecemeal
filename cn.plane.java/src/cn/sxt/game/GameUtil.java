package cn.sxt.game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * @ClassName GameUtil
 * @Description TODO 返回指定文件路径的图片对象,待完善
 * @Author NightGlower
 * @Date 2020/5/19 22:55
 * @Version 1.0
 */
public class GameUtil {
    //构造器私有化
    private GameUtil() {
    }

    public static Image getImage(String path) {
        BufferedImage bi = null;
        try {
            URL u = GameUtil.class.getClassLoader().getResource(path);
            bi = ImageIO.read(u);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bi;
    }
}
