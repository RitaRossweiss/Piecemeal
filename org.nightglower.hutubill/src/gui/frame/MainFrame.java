package gui.frame;

import gui.panel.MainPanel;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName MainFrame
 * @Description 启动类，整个程序只有一个顶级容器主Frame。
 * 该程序仍留有优化的余地，有些地方需要被改进：
 * 1.不支持非整数类型的记录，待优化。
 * 2.鼠标的放置组件提示基本上没用，待优化。
 * 3.用户输入负数的判断问题，属于Bug,待改进。
 * @Author NightGlower
 * @Date 2020/6/26 10:31
 * @Version 1.0
 */
public class MainFrame extends JFrame {
    public static MainFrame instance = new MainFrame();

    private MainFrame(){
        this.setSize(500,450);
        this.setTitle("一本糊涂账");
        this.setContentPane(MainPanel.instance);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        instance.setVisible(true);
    }
}
