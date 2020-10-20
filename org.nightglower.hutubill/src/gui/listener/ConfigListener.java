package gui.listener;

import entity.Config;
import gui.panel.ConfigPanel;
import service.ConfigService;
import util.GUIUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * @ClassName ConfigListener
 * @Description 用在更新按钮上的监听器
 * @Author NightGlower
 * @Date 2020/7/23 17:48
 * @Version 1.0
 */
public class ConfigListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        ConfigPanel p = ConfigPanel.instance;
        //先判断输入的数值是否为整数，是否为空
        if(!GUIUtil.checkNumber(p.tfBudget, "本月预算"))
            return;

        String mysqlPath =p.tfMysqlPath.getText();

        //判断 mysql 的路径，判断办法是看路径对应的bin子目录下是否有mysql.exe文件存在。
        if(0!=mysqlPath.length()){
            File commandFile = new File(mysqlPath,"bin/mysql.exe");
            if(!commandFile.exists()){
                JOptionPane.showMessageDialog(p, "Mysql路径不正确");
                p.tfMysqlPath.grabFocus();
                return;
            }
        }

        //如果上述两个判断都通过了，那么就调用业务类ConfigService进行数据更新。
        ConfigService cs= new ConfigService();
        cs.update(ConfigService.budget,p.tfBudget.getText());
        cs.update(ConfigService.mysqlPath,mysqlPath);

        JOptionPane.showMessageDialog(p, "设置修改成功");

    }

}
