// Bar Wanunu 209422435

package GameAddsOn;

import Collision.SpriteCollection;
import Interfaces.Animation;
import biuoop.DrawSurface;

import java.awt.Color;


/**
 * CountDownAnimation class - has the constructor and methods for count down
 * animation and implements the Animation interface.
 */
public class CountDownAnimation
        implements Animation {

    // Fields

    private double numOfSeconds;
    private int countFrom;
    private int time;
    private SpriteCollection gameScreen;
    private boolean stop;
    private Color color;

    // Constructor

    /**
     * Making a new CountDownAnimation.
     *
     * @param numOfSeconds - the number of seconds we want to count
     * @param countFrom - the number we start counting from
     * @param gameScreen - the game screen
     * @param color - the color we display the count-down
     */
    public CountDownAnimation(double numOfSeconds, int countFrom,
                              SpriteCollection gameScreen, Color color) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.stop = false;
        this.time = countFrom;
        this.color = color;
    }

    // Methods

    @Override public void doOneFrame(DrawSurface d) {
        if (countFrom == -1) {
            // stopping the countdown when countFrom is -1
            this.stop = true;
            return;
        }
        biuoop.Sleeper sleeper = new biuoop.Sleeper();
        this.gameScreen.drawAllOn(d);
        d.setColor(this.color);
        // displaying the countdown on the screen
        d.drawText(375, d.getHeight() / 2, "" + this.countFrom, 100);
        float wait = (float) this.numOfSeconds / this.time;
        sleeper.sleepFor((long) (1000 * wait));
        // reducing 1 from countdown
        this.countFrom--;
    }

    @Override public boolean shouldStop() {
        return this.stop;
    }
}
