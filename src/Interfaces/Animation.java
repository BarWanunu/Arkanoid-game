// Bar Wanunu 209422435

package Interfaces;

import biuoop.DrawSurface;

/**
 * Animation interface.
 */
public interface Animation {

    /**
     * The method is in charge of the logic of the drawsurface.
     * @param d - a drawsurface
     */
    void doOneFrame(DrawSurface d);

    /**
     * The method is in charge of stopping condition. returns true if we need
     * to stop and false otherwise.
     * @return TRUE/FALSE
     */
    boolean shouldStop();
}
