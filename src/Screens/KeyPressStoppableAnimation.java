// Bar Wanunu 209422435

package Screens;

import Interfaces.Animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * KeyPressStoppableAnimation class - has the constructor and methods for Key
 * Press Stoppable Animation and implements the Animation interface.
 */
public class KeyPressStoppableAnimation
        implements Animation {

    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed;

    // Constructor

    /**
     * Making a new Key Press Stoppable Animation object.
     *
     * @param sensor    - a key board sensor
     * @param key       - a string
     * @param animation - an animation implementation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key,
                                      Animation animation) {
        this.sensor = sensor;
        this.key = key;
        this.animation = animation;
        this.isAlreadyPressed = true;
        this.stop = false;
    }

    @Override public void doOneFrame(DrawSurface d) {
        // calling do one frame for animation
        animation.doOneFrame(d);
        if (this.sensor.isPressed(this.key)) {
            if (!this.isAlreadyPressed) {
                // if the key was pressed change it to true
                this.stop = true;
            }
        } else {
            this.isAlreadyPressed = false;
        }
    }

    @Override public boolean shouldStop() {
        return this.stop;
    }
}
