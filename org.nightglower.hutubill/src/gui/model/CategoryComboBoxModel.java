package gui.model;

import entity.Category;
import service.CategoryService;

import javax.swing.*;
import javax.swing.event.ListDataListener;

import java.util.List;

/**
 * @ClassName CategoryComboBoxModel
 * @Description 消息记录面板的支持类，使用ComboBoxModel把数据分离开来
 * @Author NightGlower
 * @Date 2020/7/11 22:48
 * @Version 1.0
 */
public class CategoryComboBoxModel implements ComboBoxModel<Category>{

    public List<Category> cs = new CategoryService().list();

    public Category c;

    public CategoryComboBoxModel(){
        if(!cs.isEmpty())
            c=cs.get(0);
    }

    @Override
    public int getSize() {
        // TODO Auto-generated method stub

        return cs.size();
    }

    @Override
    public Category getElementAt(int index) {
        // TODO Auto-generated method stub
        return cs.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setSelectedItem(Object anItem) {
        c = (Category) anItem;
    }

    @Override
    public Object getSelectedItem() {
        if(!cs.isEmpty())
            return c;
        else
            return null;

    }

}
