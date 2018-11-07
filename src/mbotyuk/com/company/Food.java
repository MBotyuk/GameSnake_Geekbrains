package mbotyuk.com.company;

import java.util.Random;

/**
 * Java. Classic Game Snake
 * Class Food: snake food
 *
 * @author Sergey Iryupin
 * @version dated Sep 21, 2018
 */

public class Food extends Cell {
    private GameSnake gameSnake;
    private Random random;

    public Food(GameSnake gameSnake) {      // constructor
        super(-1, -1, gameSnake.CELL_SIZE, gameSnake.FOOD_COLOR);
        this.gameSnake = gameSnake;
        random = new Random();
    }

    public boolean isFood(int x, int y) {
        return (this.x == x) && (this.y == y);
    }

    public boolean isEaten() {
        return getX() == -1;
    }

    public void eat() {
        set(-1, -1);
    }

    public void appear() {
        int x, y;
        do {
            x = random.nextInt(gameSnake.CANVAS_WIDTH);
            y = random.nextInt(gameSnake.CANVAS_HEIGHT);
        } while (gameSnake.snake.isInSnake(x, y)); // ||
        set(x, y);
    }
}