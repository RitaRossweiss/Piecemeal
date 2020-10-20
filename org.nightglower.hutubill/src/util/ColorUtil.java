package util;

import java.awt.*;

/**
 * @ClassName ColorUtil
 * @Description 颜色工具类，将常用的颜色抽象出来方便调用。
 * @Author NightGlower
 * @Date 2020/6/26 20:54
 * @Version 1.0
 */
public class ColorUtil {
    public static Color blueColor = Color.decode("#3399FF");   //淡蓝色
    public static Color grayColor = Color.decode("#999999");   //灰色
    public static Color backgroundColor = Color.decode("#eeeeee");   //背景色
    public static Color warningColor = Color.decode("#FF3333");   //警告红

    /**
     * 根据进度获取不同的颜色。通过 RGB 三原色的数值调整来实现渐变。
     * 当进度是接近0的时候，就会显示绿色。当进度接近100的时候，就会显示红色。并在不同的颜色间过渡。
     * 修改此方法需要一点调色方面的知识。
     * 该方法主要用于 [消费一览] 中圆环的颜色渐变显示。
     * @param
     *      per : 该参数表示圆环的百分比。
     * @return
     *      color 返回根据百分比 per 生成的颜色值。
     */
    public static Color getByPercentage(int per){
        if (per>100){
            per = 100;
        }

        int r = 51;
        int g = 255;
        int b = 51;
        float rate = per / 100f;
        r = (int) ( (255-51) * rate + 51 );
        g = 255 - r + 51;
        Color color = new Color(r,g,b);
        return color;
    }


}
