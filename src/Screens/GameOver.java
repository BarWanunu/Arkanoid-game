// Bar Wanunu 209422435

package Screens;

import Geometry.Counter;
import Interfaces.Animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * GameOver class - has the constructor and methods for Game Over screen and
 * implements the Animation interface.
 */
public class GameOver
        implements Animation {

    // Fields

    private Counter score;

    // Constructor

    /**
     * Making a new Game Over Screen.
     *
     * @param score    - the score
     */
    public GameOver(Counter score) {
        this.score = score;
    }

    // Methods

    @Override public void doOneFrame(DrawSurface d) {
        // displaying the game over screen
        d.drawText(60, d.getHeight() / 2,
                "Game Over. Your score is: " + this.score.getValue(), 50);
    }

    @Override public boolean shouldStop() {
        return false;
    }
}
