package model;
import java.awt.*;

// 标题和游戏结束画面绘制
public class Title {

    int count; // 动画计数器
    Font titleFont;
    Font infoFont;

    // 为标题实例化字体类
    public Title() {
        count = 0;
        titleFont = new Font("SimHei", Font.BOLD, 20);
        infoFont = new Font("SimHei", Font.BOLD, 10);
    }

    // 游戏开始界面
    public void drawTitle(Graphics g) {
        g.setColor(Color.white);
        count++;
        g.setFont(titleFont);
        g.drawString("Danmaku-Initiate", 170, 150);
        g.drawString("Press SPACE", 180, 350);
    }

    // 游戏结束界面
    public void drawGameover(Graphics g) {
        g.setColor(Color.white);
        count++;
        g.setFont(titleFont);
        g.drawString("GAMEOVER", 200, 150);
    }

}

