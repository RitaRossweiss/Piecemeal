package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import entity.Category;
import gui.panel.CategoryPanel;
import service.CategoryService;

/**
 * @ClassName CategoryListener
 * @Description CategoryListener监听器，增加，编辑和删除按钮都使用这个监听器。
 * @Author NightGlower
 * @Date 2020/7/23 19:03
 * @Version 1.0
 */
public class CategoryListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        CategoryPanel p = CategoryPanel.instance;
        JButton b = (JButton) e.getSource();


        if (b == p.bAdd) {
            String name = JOptionPane.showInputDialog(null);
            if(null == name) {
                return;
            }
            if (0 == name.length()) {
                JOptionPane.showMessageDialog(p, "分类名称不能为空");
                return;
            }

            new CategoryService().add(name);
        }


        //TODO: 这里有一个空指针异常的问题，需要判断是否为空。
        if (b == p.bEdit) {
            Category c = p.getSelectedCategory();
            int id = c.id;
            String name = JOptionPane.showInputDialog("修改分类名称", c.name);
            if(null == name) {
                return;
            }
            if (0 == name.length()) {
                JOptionPane.showMessageDialog(p, "分类名称不能为空");
                return;
            }

            new CategoryService().update(id, name);
        }


        if (b == p.bDelete) {
            Category c = p.getSelectedCategory();
            if (0 != c.recordNumber) {
                JOptionPane.showMessageDialog(p, "本分类下有消费记录存在，不能删除");
                return;
            }
            if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(p, "确认要删除？"))
                return;

            int id = c.id;
            new CategoryService().delete(id);
        }


        p.updateData();
    }


}