package util;

import gui.panel.SpendPanel;
import gui.panel.WorkingPanel;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @ClassName CenterPanel
 * @Description 工具类：这个类 new 出来可以实现两种居中效果。
 * 一个是拉伸居中，另一个是默认大小居中。
 * 拉伸居中还可以自定义界面间距。
 *
 * " 卧槽这个功能挺不错，让我研究一下。"
 * " 算了，又不是不能用。"
 *
 * @Author NightGlower
 * @Date 2020/6/26 11:35
 * @Version 1.0
 */
public class CenterPanel extends JPanel {

    private double rate;    // 拉伸的比例，比如1是填满，0.5是填一半。
    private JComponent c;    // 显示的组件。
    private boolean strech; // 决定使用哪一种拉伸效果。

    public CenterPanel(double rate, boolean strech) {
        this.setLayout(null);
        this.rate = rate;
        this.strech = strech;
    }

    public CenterPanel(double rate) {
        this(rate, true);
    }

    public void repaint() {
        if (c != null) {
            Dimension containerSize = this.getSize();
            Dimension componentSize = c.getPreferredSize();
            //
            if (strech)
                c.setSize((int) (containerSize.width * rate), (int) (containerSize.height * rate));
            else
                c.setSize(componentSize);
            //
            c.setLocation(containerSize.width / 2 - c.getSize().width / 2, containerSize.height / 2 - c.getSize().height / 2);
            //
            super.repaint();
        }

    }

    public void show(JComponent p) {
        this.c = p;
        Component[] cs = getComponents();
        for (Component c : cs) {
            remove(c);
        }
        add(p);

        //判断，只要一个面板同属 WorkingPanel ,就实时更新该面板上的数据。
        if(p instanceof WorkingPanel){
            ((WorkingPanel) p).updateData();
        }

        this.updateUI();
    }

    public void show(SpendPanel instance) {
    }
}
