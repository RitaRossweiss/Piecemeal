package gui.panel;

import javax.swing.*;

/**
 * @ClassName WorkingPanel
 * @Description 功能需求抽象类
 * @Author NightGlower
 * @Date 2020/7/23 21:13
 * @Version 1.0
 */
public abstract class WorkingPanel extends JPanel {
    public abstract void updateData();
    public abstract void addListener();
}
