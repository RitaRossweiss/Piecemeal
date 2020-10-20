package util;


import javax.swing.*;
import java.awt.*;

/**
 * @ClassName CircleProgressBar
 * @Description 这是一个组件类，用于显示生成环形进度条。
 * 该类中也提供了基本的控制方法。
 * @Author NightGlower
 * @Date 2020/6/27 12:46
 * @Version 1.0
 */
public class CircleProgressBar extends JPanel {
    private int minimumProgress;     //最小进度
    private int maximumProgress;     //最大进度
    private int progress;   //标准进度
    private String progressText;    //进度文本
    private Color backgroundColor;  //背景色
    private Color foregroundColor;  //前景色

    //初始化构造方法
    public CircleProgressBar() {
        minimumProgress = 0;
        maximumProgress = 100;
        progressText = "0%";
    }

    /**
     * 该方法 paint(Graphics g) 生成圆环组件，先知道怎么用就行了。
     * 又不是不能用系列。
     *
     * @param g
     */
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D graphics2d = (Graphics2D) g;
        // 开启抗锯齿
        graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int x = 0;
        int y = 0;
        int width = 0;
        int height = 0;
        int fontSize = 700;
        if (getWidth() >= getHeight()) {
            x = (getWidth() - getHeight()) / 2 + 25;
            y = 25;
            width = getHeight() - 50;
            height = getHeight() - 50;
            fontSize = getWidth() / 8;
        } else {
            x = 25;
            y = (getHeight() - getWidth()) / 2 + 25;
            width = getWidth() - 50;
            height = getWidth() - 50;
            fontSize = getHeight() / 8;
        }

        graphics2d.setStroke(new BasicStroke(20.0f));   //圆环粗度
        graphics2d.setColor(backgroundColor);
        graphics2d.drawArc(x, y, width, height, 0, 360);
        graphics2d.setColor(foregroundColor);
        graphics2d.drawArc(x, y, width, height, 90,
                -(int) (360 * ((progress * 1.0) / (maximumProgress - minimumProgress))));
        graphics2d.setFont(new Font("黑体", Font.BOLD, fontSize));
        FontMetrics fontMetrics = graphics2d.getFontMetrics();
        int digitalWidth = fontMetrics.stringWidth(progressText);
        int digitalAscent = fontMetrics.getAscent();
        graphics2d.setColor(foregroundColor);
        graphics2d.drawString(progressText, getWidth() / 2 - digitalWidth / 2, getHeight() / 2 + digitalAscent / 2);
    }

    /**
     * 获取进度
     *
     * @return progress 返回一个 int 类型的进度值
     */
    public int getProgress() {
        return progress;
    }

    /**
     * 设置进度，调用 repaint() 方法直接重画。
     *
     * @param progress int类型，代表想设置的进度参数。
     */
    public void setProgress(int progress) {
        //规范数据范围的合法性。
        if (progress >= minimumProgress && progress <= maximumProgress)
            this.progress = progress;
        //规范数据范围的合法性，防止进度参数设置过大。
        if (progress > maximumProgress)
            this.progress = maximumProgress;

        this.progressText = String.valueOf(progress + "%");

        this.repaint();
    }

    /**
     * 获取圆环的背景颜色。
     *
     * @return 返回当前背景颜色
     */
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * 设置圆环当前的背景颜色，调用 repaint() 方法直接重画。
     *
     * @param backgroundColor 你想设置的某种颜色值。
     */
    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        this.repaint();
    }

    /**
     * 获取圆环的前景色。
     *
     * @return 返回当前前景颜色
     */
    public Color getForegroundColor() {
        return foregroundColor;
    }


    /**
     * 设置圆环当前的前景色，调用 repaint() 方法直接重画。
     *
     * @param foregroundColor 你想设置的某种颜色值。
     */
    public void setForegroundColor(Color foregroundColor) {
        this.foregroundColor = foregroundColor;
        this.repaint();
    }


}
