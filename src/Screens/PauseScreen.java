// Bar Wanunu 209422435

package Screens;

import Interfaces.Animation;
import biuoop.DrawSurface;

/**
 * PauseScreen class - has the constructor and methods for pause screen and
 * implements the Animation interface.
 */
public class PauseScreen
        implements Animation {
    @Override public void doOneFrame(DrawSurface d) {
        // displaying the pause screen
        d.drawText(150, d.getHeight() / 2,
                "paused -- press space to continue", 32);
    }

    @Override public boolean shouldStop() {
        return false;
    }
}
