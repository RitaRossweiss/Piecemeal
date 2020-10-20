package util;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * @ClassName GUIUtil
 * @Description 这是一个工具类，封装了一些全局代码的常用方法。
 * @Author NightGlower
 * @Date 2020/6/26 17:09
 * @Version 1.0
 */
public class GUIUtil {

    /**
     * 快速使用水晶皮肤。
     * （如果你不想调用的话也无伤大雅，无非界面丑了一点）
     * 注意！这个方法如果要被调用，那么该方法的调用级别应该是最优先的。
     * 也就是说，无论是测试类还是实体类，都应该在 main 方法的开头优先调用。
     * 不要写到一半去调用，否则会出现渲染失败的问题。
     */
    public static void useLNF(){
        try {
            UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        } catch (Exception e) {
            System.out.println("皮肤问题");
            e.printStackTrace();
        }
    }

    /***
     * 给按钮设置图标和文本以及提示文字。
     * TODO:鼠标提留的提示信息 setToolTipText() 有待改进。
     */
    private static String imageFolder = "D:/org.nightglower.hutubill/img/acg" ;
    public static void setImageIcon(JButton b , String fileName , String tip){
        ImageIcon i = new ImageIcon( new File(imageFolder,fileName).getAbsolutePath() );
        b.setIcon(i);   //设置图片。
        b.setPreferredSize(new Dimension(61,81));   //布局器微调。
        b.setToolTipText(tip);  //鼠标停留，显示提示信息。
        b.setVerticalTextPosition(JButton.BOTTOM);  //设置标签的文本相对其图像的水平位置。
        b.setHorizontalTextPosition(JButton.CENTER);    //设置标签的文本相对其图像的垂直位置。
        b.setText(tip); //设置文本。
    }

    /**
     * 一次性给多个组件设置前景色。
     */
    public static void setColor(Color color , JComponent... jComponents ){
        for (JComponent j:jComponents) {
            j.setForeground(color);
        }
    }

    /**
     * 快速显示一个面板的内容。
     * 显示的时候也用到了 CenterPanel 居中类
     */
    public static void showPanel(JPanel p , double strechRate){
        GUIUtil.useLNF();
        JFrame jFrame = new JFrame();
        jFrame.setSize(560,500);
        jFrame.setLocationRelativeTo(null); // 设置窗口相对于指定组件的位置。如果组件当前未显示或者 c 为 null , 则此窗口将置于屏幕的中央。
        CenterPanel cp = new CenterPanel(strechRate);   // CenterPanel 居中类。
        jFrame.setContentPane(cp);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        cp.show(p);
    }
    public static void showPanel(JPanel p){
        showPanel(p,0.85);
    }

    /**
     * 检查一个输入框是否为空。
     * @return
     *      false 判断为空并弹出消息框进行提示。
     *      true 判断不为空，通过检查。
     */
    public static boolean checkEmpty(JTextField jTextField , String input){
        String text = jTextField.getText().trim();  // trim()方法的作用就是去掉字符串前面和后面的空格。
        if (0 == text.length()){
            JOptionPane.showMessageDialog(null,input+"不能为空！");
            jTextField.grabFocus(); //获取鼠标焦点
            return false;
        }
        return true;
    }

    /**
     * 检查一个组件内容是否为整数。
     * 建立在 checkEmpty() 输入框内容不为空的基础上。
     * @return
     *      false 判断不是整数并弹出消息框进行提示。
     *      true 通过检查，是一个整数。
     */
    public static boolean checkNumber(JTextField jTextField , String input){
        //先判断是否为空
        if (!checkEmpty(jTextField,input))
            return false;

        String text = jTextField.getText().trim();  // trim()方法的作用就是去掉字符串前面和后面的空格。
        try{
            Integer.parseInt(text);
            return true;
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null,input+"应该是一个整数！");
            jTextField.grabFocus(); //获取鼠标焦点。
            return false;
        }
    }

    /**
     * 检查组件内容是否为零。
     * 建立在 checkNumber() 整数判断的基础上。
     * @return
     *      false 判断是零并弹出消息框进行提示。
     *      true 通过检查，不为零。
     */
    public static boolean checkZero(JTextField jTextField , String input){
        //先判断输入内容是不是整数。
        if (!checkNumber(jTextField,input))
            return false;

        String text = jTextField.getText().trim();  // trim()方法的作用就是去掉字符串前面和后面的空格。
        // TODO 输入判断有待改进，比如判断负数。
        if (0 == Integer.parseInt(text) ){
            JOptionPane.showMessageDialog(null,input+"不能为零");
            jTextField.grabFocus(); //获取鼠标焦点。
            return false;
        }
        return true;
    }

    /**
     * 将文本数据转换成一个整数
     * @return
     *      返回一个 int 类型的值。
     */
    public static int getInt(JTextField jTextField){
        return Integer.parseInt(jTextField.getText());
    }

}
