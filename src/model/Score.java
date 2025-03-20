package model;

import java.awt.*;

// 得分的控制和显示
public class Score {

    static int myscore;
    static int hiscore;
    Font scoreFont;

    public Score() {
        scoreFont = new Font("SimHei", Font.BOLD, 15);
        myscore = 0;
    }

    // 得分显示
    public void drawScore(Graphics g) {
        g.setColor(Color.white);
        g.setFont(scoreFont);
        g.drawString("得分:" + myscore, 10, 30);
    }

    // 最高分显示
    public void drawHiScore(Graphics g) {
        g.setColor(Color.white);
        g.setFont(scoreFont);
        g.drawString("最高分:" + hiscore, 350, 30);
    }

    // 计分添加
    public static void addScore(int gain) {
        myscore += gain;
    }

    // 最高分更新处理
    public static void compareScore() {
        if (myscore > hiscore) {
            hiscore = myscore;
            saveScore();
        }
    }

    static void saveScore() {
    }

    public static void loadScore() {
    }

    public static void initScore() {
        myscore = 0;
    }

}
