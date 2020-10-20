package cn.sxt.game;


import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

/**
 * @ClassName MyGameFrame
 * @Description 飞机大战主窗口
 * @Author NightGlower
 * @Date 2020/5/19 20:31
 * @Version 1.0
 */
public class MyGameFrame extends Frame {
    boolean flag = true;
    static int time = 0;
    static int hp = 50;


    //载入图片
    Image bg = GameUtil.getImage("images/bg.jpg");
    Image plane = GameUtil.getImage("images/plane.png");


    //创建对象
    Bg b = new Bg(bg, 0, 0);//背景对象
    Plane p = new Plane(plane, 300, 600, 10, hp);//飞机对象
    Shell[] shells = new Shell[5];//子弹对象，数组
    //    Boon boon ;  爆炸对象，但是实现有问题，Bug未解决
    Date startTime = new Date();  //开始计时对象
    Date overTime;     //结束计时对象


    public int getTime() {
        return time;
    }


    //画出图像
    public void paint(Graphics g) {
        Color color = g.getColor();
        b.drawSelf(g);
        p.drawSelf(g);
        //画出数组内的小球对象
        for (int i = 0; i < shells.length; i++) {
            shells[i].draw(g);
            //碰撞检测
            if (shells[i].getRect().intersects(p.getRect())) {
//                FIXME 创建爆炸对象，但是实现有问题，Bug未解决 , 怀疑是单例模式和IO流有冲突
//                if (boon == null){
//                    boon = new Boon(p.x,p.y);
//                }
//                boon.draw(g);

                //伤害随机计算，并调用死亡方法
                p.hp -= 1;
                if (p.hp <= 0) {
                    p.die();
                }
            }
            //计时,算出持续时间
            overTime = new Date();
            time = (int) ((overTime.getTime() - startTime.getTime()) / 1000);
            //游戏结束显示时间
            g.setColor(Color.orange);
            Font font = new Font("宋体", Font.BOLD, 25);

            g.setFont(font);
            g.drawString("已经坚持了" + time + "秒", 100, 100);
            g.setColor(Color.blue);
            g.drawString("HP:" + p.hp, 100, 140);


        }
        g.setColor(color);
    }

    //内部类，重写键盘的监听，获取键盘具体编码
    class KeyMonitor extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
//            System.out.println(e.getKeyCode());
            p.addDirection(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
//            System.out.println(e.getKeyCode());
            p.minusDirection(e);
        }
    }

    //内部类，多线程实现多个单位的移动效果
    class PalneThread extends Thread {
        @Override
        public void run() {
            super.run();
            while (true) {
                repaint(); //不断的重画
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("睡眠异常");
                }
            }
        }
    }


    //初始化窗口
    public void launchFarme() {
        this.setTitle("模拟飞行V1.0");//初始化窗口名称
        this.setVisible(true);//使窗口可见
        this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);//初始化窗口大小
        this.setLocation(600, 100);//初始化窗口坐标
        //匿名内部类，窗口关闭就停止运行代码
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        new PalneThread().start();  //启动重画!
        addKeyListener(new KeyMonitor());  //启动键盘监听！

        //创建50个小球对象
        for (int i = 0; i < shells.length; i++) {
            shells[i] = new Shell();
        }
    }

    public static void main(String[] args) {
        MyGameFrame f = new MyGameFrame();
        f.launchFarme();
    }

    //双缓冲技术
    private Image offScreenImage = null;

    public void update(Graphics g) {
        if (offScreenImage == null)
            offScreenImage = this.createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);//这是游戏窗口的宽度和高度

        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);
    }

}
