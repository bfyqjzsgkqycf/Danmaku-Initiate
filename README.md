## 1. Overview
Danmaku-Initiate is a danmaku-style shooting game where players control a character to shoot down enemies and avoid enemy bullets. The game includes elements such as character control, bullet shooting, enemy generation, collision detection, and score calculation.

## 2. Project Structure
### 2.1 Main Classes
- **MyCanvas.java**: Responsible for game initialization, including initializing game variables, levels, and scores, and setting the initial game scene to the title screen.
- **ObjectPool.java**: Manages the states of game objects such as players, bullets, and enemies, and performs collision detection. It also provides methods for creating and initializing various game objects.
- **Title.java**: Handles the drawing of the title screen and game over screen.
- **Score.java**: Manages the game score, including loading and initializing the score.

### 2.2 Model Classes
- **Particle.java**: Represents particle effects, such as explosion effects, with movement and drawing methods.
- **EnemyBullet.java**: Represents enemy bullets, with constructors and activation methods.
- **Enemy.java**: Represents enemies, with different movement patterns, shooting behaviors, and collision handling.
- **Player.java**: Represents the player, although the code snippet does not show the full implementation of this class.

## 3. Key Features

### 3.1 Game Initialization
The `init` method in `MyCanvas.java` is called at the start and restart of the game to initialize game variables, levels, and scores, and set the initial scene to the title screen.

```java
public void init() {
    objectpool = new ObjectPool();
    Score.loadScore();
    scene = SCENE_TITLE; // Initialize to the title screen
    gameover = false; // Reset the game state
    Level.initLevel(); // Initialize levels
    Score.initScore(); // Initialize scores
}
```

### 3.2 Object Management
The `ObjectPool` class manages the states of game objects, including creating, initializing, and drawing objects. It also provides methods for collision detection.

```java
public class ObjectPool {
    // ...
    // Collision detection
    public void getColision() {
        // Enemy bullet and player collision
        // Player bullet and enemy collision
        // Enemy and player collision
    }
    // ...
}
```

### 3.3 Collision Detection
The `getColision` method in `ObjectPool.java` performs collision detection between different game objects, such as enemy bullets and players, player bullets and enemies, and enemies and players. When a collision occurs, corresponding actions are taken, such as making the object inactive and creating explosion effects.

```java
public void getColision() {
    // Enemy bullet and player collision
    for (int i = 0; i < EnemyBullet.length && GodMode == false; i++) {
        if ((EnemyBullet[i].active) && (player.active)) {
            if (getDistance(player, EnemyBullet[i]) < DIST_PLAYER_TO_EnemyBullet) {
                player.active = false;
                for (int j = 0; j < 360; j += 20) {
                    newParticle(player.x, player.y, j, 2);
                }
                EnemyBullet[i].active = false;
            }
        }
    }
    // ...
}
```

### 3.4 Score Calculation
The `Enemy` class includes a `hit` method that reduces the enemy's health when it is hit by a player's bullet. When the enemy's health drops to zero, the corresponding score is added to the player's score.

```java
public void hit() {
    life--;
    able = true;
    if (life < 0) {
        switch (type) {
            case 0:
                Score.addScore(10);
                break;
            case 1:
                Score.addScore(20);
                break;
            default:
        }
        // Enemy explosion effect
        ObjectPool.newParticle(x, y, 45, 2);
        // ...
        active = false;
    }
}
```

## 4. How to Run
1. Compile all Java source files in the `Danmaku-Initiate/src` directory.
2. Run the main class (usually the class containing the `main` method) to start the game.

## 5. Future Improvements
- Add more enemy types and movement patterns to increase game difficulty and variety.
- Implement a more complex scoring system, such as rewarding based on the player's performance and the number of consecutive hits.
- Add sound effects and background music to enhance the gaming experience.
