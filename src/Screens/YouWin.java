// Bar Wanunu 209422435

package Screens;

import Geometry.Counter;
import Interfaces.Animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * YouWin class - has the constructor and methods for You Win screen and
 * implements the Animation interface.
 */
public class YouWin
        implements Animation {

    // Fields

    private Counter score;

    // Constructor

    /**
     * Making a new You Win Screen.
     *
     * @param score - the score
     */
    public YouWin(Counter score) {
        this.score = score;
    }

    // Methods

    @Override public void doOneFrame(DrawSurface d) {
        // in case of winning
        d.drawText(90, d.getHeight() / 2,
                "You Win! Your score is: " + this.score.getValue(), 50);
    }

    @Override public boolean shouldStop() {
        return false;
    }
}
