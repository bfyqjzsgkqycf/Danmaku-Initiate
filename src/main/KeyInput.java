package main;
import java.awt.event.*;

/**
 * 键盘输入
 * 空格开始/射击
 * 光标控制方向
 */
public class KeyInput extends KeyAdapter {

    // 键盘输入状态指示
    boolean keyup;
    boolean keydown;
    boolean keyleft;
    boolean keyright;

    /**
     * 按键类型检测
     * 0:没被按
     * 1:被按了
     * 2:按了一下松开了
     */
    int keyshot;

    KeyInput() {
        keyup = false;
        keydown = false;
        keyleft = false;
        keyright = false;
        keyshot = 0;
    }

    public void keyPressed(KeyEvent e) {
        int keycode = e.getKeyCode();
        if (keycode == KeyEvent.VK_LEFT) {
            keyleft = true;
        }
        if (keycode == KeyEvent.VK_RIGHT) {
            keyright = true;
        }
        if (keycode == KeyEvent.VK_UP) {
            keyup = true;
        }
        if (keycode == KeyEvent.VK_DOWN) {
            keydown = true;
        }
        if (keycode == KeyEvent.VK_SPACE) {
            if (keyshot == 0) {
                keyshot = 2;
            } else {
                keyshot = 1;
            }
        }
        if (keycode == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }

    // 松开按键时处理
    public void keyReleased(KeyEvent e) {
        int keycode = e.getKeyCode();
        if (keycode == KeyEvent.VK_LEFT) {
            keyleft = false;
        }
        if (keycode == KeyEvent.VK_RIGHT) {
            keyright = false;
        }
        if (keycode == KeyEvent.VK_UP) {
            keyup = false;
        }
        if (keycode == KeyEvent.VK_DOWN) {
            keydown = false;
        }
        if (keycode == KeyEvent.VK_SPACE) {
            keyshot = 0;
        }
    }

    // 获取 x 轴输入, -1右, 0无, +1左
    public int getXDirection() {
        int ret = 0; // 静止状态
        if (keyright) {
            ret = 1;
        }
        if (keyleft) {
            ret = -1;
        }
        return ret;
    }

    // 获取 x 轴输入, -1上, 0无, +1上
    public int getYDirection() {
        int ret = 0; // 静止状态
        if (keydown) {
            ret = 1;
        }
        if (keyup) {
            ret = -1;
        }
        return ret;
    }

    // 获取空格键, 0没被按, 1:被按了, 2:按了一下松开了
    public int checkShotKey() {
        int ret = keyshot;
        if (keyshot == 2) {
            keyshot = 1;
        }
        return ret;
    }

}
