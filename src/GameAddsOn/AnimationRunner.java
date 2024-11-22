// Bar Wanunu 209422435

package GameAddsOn;

import Interfaces.Animation;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;

/**
 * AnimationRunner class - has the constructor and methods for animation runner
 * and implements the Animation interface.
 */
public class AnimationRunner {

    // Fields

    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;
    private KeyboardSensor keyboardSensor;

    // Constructor

    /**
     * Making a new AnimationRunner.
     *
     * @param gui - the gui
     */
    public AnimationRunner(GUI gui) {
        this.gui = gui;
        this.framesPerSecond = 60;
        this.sleeper = new biuoop.Sleeper();
        this.keyboardSensor = this.gui.getKeyboardSensor();
    }

    // Methods

    /**
     * The run method runs the game.
     *
     * @param animation - an animation object
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / this.framesPerSecond;
        // running till needed to stop the animation
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = this.gui.getDrawSurface();

            // calling doOneFrame for the current animation runner
            animation.doOneFrame(d);
            if (!animation.shouldStop()) {
                this.gui.show(d);
            }

            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}
