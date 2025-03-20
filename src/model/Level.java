package model;

// 关卡管理, 每 500帧 提高一关
public class Level {

    static int level;

    public static int getLevel() {
        return level;
    }

    // 关卡增加方法, 最高 10关
    public static void addLevel() {
        if (level < 8) {
            level++;
        }
    }

    // 初始化恢复等级
    public static void initLevel()
    {
        level = 0;
    }

}
