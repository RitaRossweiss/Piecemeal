package gui.panel;

import gui.listener.BackupListener;
import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;

/**
 * @ClassName BackupPanel
 * @Description 原型设计，备份面板。
 * @Author NightGlower
 * @Date 2020/7/12 22:18
 * @Version 1.0
 */
public class BackupPanel extends WorkingPanel {
    static {
        GUIUtil.useLNF();
    }

    public static BackupPanel instance = new BackupPanel();
    JButton bBackup = new JButton("备份");

    public BackupPanel(){
        GUIUtil.setColor(ColorUtil.blueColor,bBackup);
        this.add(bBackup);
        addListener();
    }


    @Override
    public void updateData() {

    }

    @Override
    public void addListener() {
        BackupListener listener = new BackupListener();
        bBackup.addActionListener(listener);
    }
}
