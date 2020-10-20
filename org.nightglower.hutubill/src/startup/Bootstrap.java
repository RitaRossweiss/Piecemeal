package startup;


import gui.frame.MainFrame;
import gui.panel.MainPanel;
import util.GUIUtil;
import util.SpendPanel;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName Bootstrap
 * @Description 引导启动
 * @Author NightGlower
 * @Date 2020/7/23 16:18
 * @Version 1.0
 */
public class Bootstrap {
    public static void main(String[] args) throws Exception {
        GUIUtil.useLNF();

        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                MainFrame.instance.setVisible(true);
                MainPanel.instance.workingPanel.show(SpendPanel.instance);
            }
        });

    }

}
