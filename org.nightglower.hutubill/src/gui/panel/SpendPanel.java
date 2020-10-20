package gui.panel;

import javax.swing.*;

/**
 * @ClassName SpeedPanel
 * @Description 单例模式的面板类，用于监听器访问组件。
 * @Author NightGlower
 * @Date 2020/6/26 11:02
 * @Version 1.0
 */
public class SpendPanel {

    /***
     * 将这个类设计为单例模式，声明静态属性，并提供 private 构造方法。
     * 这种单例设计模式并不常见，但对于本项目来说刚好够用。
     */
    public static SpendPanel instance = new SpendPanel();

    private SpendPanel() {
    }


    //  [ 消费一览 ] 中的面板容器，显示说明文字，后期基本上不需要变动了。
    JLabel lMonthSpeed = new JLabel("本月消费");
    JLabel lTodaySpeed = new JLabel("今日消费");
    JLabel lAvgSpeedPerDay = new JLabel("日均消费");
    JLabel lMonthLeft = new JLabel("本月剩余");
    JLabel lDayAvgAvailable = new JLabel("日均可用");
    JLabel lMonthLeftDay = new JLabel("距离月末");
    //  [ 消费一览 ] 中的面板容器，显示软妹币的具体数值，暂时没有数据。
    JLabel vMonthSpeed = new JLabel("¥null");
    JLabel vTodaySpeed = new JLabel("¥null");
    JLabel vAvgSpeedPerDay = new JLabel("¥null");
    JLabel vMonthLeft = new JLabel("¥null");
    JLabel vDayAvgAvailable = new JLabel("¥null");
    JLabel vMonthLeftDay = new JLabel("¥null");

}
