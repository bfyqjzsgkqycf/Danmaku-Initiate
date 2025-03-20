package model;
import java.awt.*;
import main.*;

// 玩家类, 移动和绘制的实现
public class Player extends GameObject {

    double speed;

    /**
     * 移动处理
     * 参数 ix(double)：生成处的 X 坐标
     * 参数 iy(double)：生成处的 Y 坐标
     * 参数 ispeed(double)：移动速度
     */
    public Player(double ix, double iy, double ispeed) {
        x = ix;
        y = iy;
        speed = ispeed;
        active = false;
    }

    public void move() {
    }

    /**
     * 移动处理
     * 参数 mx(double)：x方向的移动（-1...+1）
     * 参数 my(double)：y方向的移动（-1...+1）
     */
    public void move(int mx, int my) {
        // 避免移动到 Canvas 外面
        double postX = x + mx * speed;
        double postY = y + my * speed;

        if ((0 < postX) && (postX < 500)) {
            x = postX;
        }
        if ((0 < postY) && (postY < 480)) {
            y = postY;
        }
    }

    // 循环一次绘制一次
    public void draw(Graphics g) {
        if (active) {
            g.setColor(Color.green);
            // 绘制玩家三角形
            g.drawLine((int) (x), (int) (y - 14), (int) (x - 10), (int) (y + 7));
            g.drawLine((int) (x), (int) (y - 14), (int) (x + 10), (int) (y + 7));
            g.drawLine((int) (x - 10), (int) (y + 7), (int) (x + 10), (int) (y + 7));
        }
    }

}
