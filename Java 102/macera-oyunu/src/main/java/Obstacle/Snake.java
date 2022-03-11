package Obstacle;

import java.util.Random;

public class Snake extends Obstacle {

    public Snake() {
        super(4, "Snake", new Random().nextInt(4)+ 3, 12, 0);
    }
}
