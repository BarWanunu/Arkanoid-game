// Bar Wanunu 209422435
package Interfaces;

import biuoop.DrawSurface;

/**
 * Interfaces.Sprite interface.
 */
public interface Sprite {
    /**
     * The method draws the specific sprite on the surface.
     * @param d - the DrawSurface
     */
    void drawOn(DrawSurface d);

    /**
     * The method notifies the sprite that the time has passed.
     */
    void timePassed();
}
