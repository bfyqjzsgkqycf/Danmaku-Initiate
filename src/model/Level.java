package model;

public class Level { // 关卡管理, 每 500帧 提高一关
    static int level;

    public static int getLevel() {
        return level;
    }

    public static void addLevel() { // 关卡增加方法, 最高 10关
        if (level < 8) {
            level++;
        }
    }

    public static void initLevel() // 初始化恢复等级
    {
        level = 0;
    }
}
