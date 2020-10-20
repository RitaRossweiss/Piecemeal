package util;

import gui.page.SpendPage;
import gui.panel.WorkingPanel;
import service.SpendService;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName SpendPanel
 * @Description 消费一览界面
 * @Author NightGlower
 * @Date 2020/6/29 21:41
 * @Version 1.0
 */
public class SpendPanel extends WorkingPanel {


    //单例模式，为的是后续的监听器访问这个容器里的组件的便利性。
    public static SpendPanel instance = new SpendPanel();
    //各种组件都整成 public 属性，也是为了监听器方便获取组件
    public JLabel lMonthSpend = new JLabel("本月消费");
    public JLabel lTodaySpend = new JLabel("今日消费");
    public JLabel lAvgSpendPerDay = new JLabel("日均消费");
    public JLabel lMonthLeft = new JLabel("本月剩余");
    public JLabel lDayAvgAvailable = new JLabel("日均可用");
    public JLabel lMonthLeftDay = new JLabel("距离月末");

    public JLabel vMonthSpend = new JLabel("￥2300");
    public JLabel vTodaySpend = new JLabel("￥25");
    public JLabel vAvgSpendPerDay = new JLabel("￥120");
    public JLabel vMonthAvailable = new JLabel("￥2084");
    public JLabel vDayAvgAvailable = new JLabel("￥389");
    public JLabel vMonthLeftDay = new JLabel("15天");

    //环形进度条
    CircleProgressBar bar;

    public SpendPanel() {
        this.setLayout(new BorderLayout());
        //实例化环形进度条
        bar = new CircleProgressBar();
        bar.setBackgroundColor(ColorUtil.blueColor);

        //给各种组件设置颜色
        GUIUtil.setColor(ColorUtil.grayColor, lMonthSpend, lTodaySpend, lAvgSpendPerDay, lMonthLeft, lDayAvgAvailable, lMonthLeftDay, vAvgSpendPerDay, vMonthAvailable, vDayAvgAvailable, vMonthLeftDay);
        GUIUtil.setColor(ColorUtil.blueColor, vMonthSpend, vTodaySpend);

        //  [本月消费] 和 [今日消费] 需要特别设置一下字体。
        vMonthSpend.setFont(new Font("微软雅黑", Font.BOLD, 23));
        vTodaySpend.setFont(new Font("微软雅黑", Font.BOLD, 23));

        //设置整体布局，消费一览界面的布局大致分为两块，位置分别在 BorderLayout 的 “北边”  和 “南边” 。
        this.add(center(), BorderLayout.CENTER);
        this.add(south(), BorderLayout.SOUTH);
    }

    /**
     * 北布局，自身分中西两部分，环形进度条在中
     *
     * @return
     */
    private JPanel center() {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        //设置 “北布局” 的西边
        p.add(west(), BorderLayout.WEST);
        ////设置 “北布局” 的中边，也就是设置环形进度条
        p.add(center2(), BorderLayout.CENTER);
        return p;
    }

    /**
     * @return 返回一个环形进度条
     */
    private Component center3() {
        return bar;
    }


    /**
     * @return 返回一个环形进度条
     */
    private Component center2() {
        return bar;
    }

    /**
     * “北布局” 的西边
     *
     * @return 返回一个已经设置好的 JPanel 面板
     */
    private Component west() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(4, 1));
        p.add(lMonthSpend);
        p.add(vMonthSpend);
        p.add(lTodaySpend);
        p.add(vTodaySpend);
        return p;
    }

    /**
     * 设置 “南布局” ，由于南布局不需要什么进度条，所以一个方法就他妈够了。
     * @return 返回一个已近设置好的 “南布局” 容器。
     */
    private JPanel south() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2, 4));

        p.add(lAvgSpendPerDay);
        p.add(lMonthLeft);
        p.add(lDayAvgAvailable);
        p.add(lMonthLeftDay);
        p.add(vAvgSpendPerDay);
        p.add(vMonthAvailable);
        p.add(vDayAvgAvailable);
        p.add(vMonthLeftDay);

        return p;
    }


    @Override
    public void updateData() {
        SpendPage spend = new SpendService().getSpendPage();
        vMonthSpend.setText(spend.monthSpend);
        vTodaySpend.setText(spend.todaySpend);
        vAvgSpendPerDay.setText(spend.avgSpendPerDay);
        vMonthAvailable.setText(spend.monthAvailable);
        vDayAvgAvailable.setText(spend.dayAvgAvailable);
        vMonthLeftDay.setText(spend.monthLeftDay);

        bar.setProgress(spend.usagePercentage);
        if (spend.isOverSpend) {
            vMonthAvailable.setForeground(ColorUtil.warningColor);
            vMonthSpend.setForeground(ColorUtil.warningColor);
            vTodaySpend.setForeground(ColorUtil.warningColor);

        } else {
            vMonthAvailable.setForeground(ColorUtil.grayColor);
            vMonthSpend.setForeground(ColorUtil.blueColor);
            vTodaySpend.setForeground(ColorUtil.blueColor);
        }
        bar.setForegroundColor(ColorUtil.getByPercentage(spend.usagePercentage));
        addListener();
    }

    @Override
    public void addListener() {

    }
}
