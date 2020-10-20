package gui.panel;

import gui.listener.ToolBarListener;
import util.CenterPanel;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName MainPanel
 * @Description 原型设计，主窗体面板，采用 BorderLayerout 布局方式。
 * @Author NightGlower
 * @Date 2020/6/29 14:46
 * @Version 1.0
 */
public class MainPanel extends JPanel {
    //因为该类使用的是单例模式，所以要使用静态初始化块优先加载皮肤。
    //静态初始化块中调用 LookAndFeel，设置水晶皮肤。
    static {
        GUIUtil.useLNF();
    }

    //单例模式，为的是后续的监听器访问这个容器里的组件的便利性。
    public static MainPanel instance = new MainPanel();

    //设置按钮，声明 public 属性，也是为了后续的监听器访问这个容器里的组件的便利性。
    public JToolBar tb = new JToolBar();
    public JButton bSpend = new JButton();
    public JButton bRecord = new JButton();
    public JButton bCategory = new JButton();
    public JButton bReport = new JButton();
    public JButton bConfig = new JButton();
    public JButton bBackup = new JButton();
    public JButton bRecover = new JButton();

    public CenterPanel workingPanel;
    //使用 GUI.setImageIcon() 设置这些按钮的图标、文字和提示。
    public MainPanel(){
        GUIUtil.setImageIcon(bSpend, "home.png", "消费一览");
        GUIUtil.setImageIcon(bRecord, "record.png", "记一笔");
        GUIUtil.setImageIcon(bCategory, "category2.png", "消费分类");
        GUIUtil.setImageIcon(bReport, "report.png", "消费报表");
        GUIUtil.setImageIcon(bConfig, "config.png", "设置");
        GUIUtil.setImageIcon(bBackup, "backup.png", "备份");
        GUIUtil.setImageIcon(bRecover, "restore.png", "恢复");

        tb.add(bSpend);
        tb.add(bRecord);
        tb.add(bCategory);
        tb.add(bReport);
        tb.add(bConfig);
        tb.add(bBackup);
        tb.add(bRecover);
        tb.setFloatable(false);

        workingPanel = new CenterPanel(0.8);

        //这里的 MainPanel 继承了 JPanel ，继承了 JPanel 里面的 setLayout() 方法。
        //直接调用就是调用 MainPanel 自己的 setLayout() 方法。
        setLayout(new BorderLayout());
        add(tb, BorderLayout.NORTH);
        add(workingPanel, BorderLayout.CENTER);

        addListener();
    }

    public void  addListener(){
        ToolBarListener listener = new ToolBarListener();
        bSpend.addActionListener(listener);
        bRecord.addActionListener(listener);
        bCategory.addActionListener(listener);
        bReport.addActionListener(listener);
        bConfig.addActionListener(listener);
        bBackup.addActionListener(listener);
        bRecover.addActionListener(listener);
    }



}
