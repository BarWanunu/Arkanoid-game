// Bar Wanunu 209422435

package Interfaces;

import CollidableObjects.Ball;
import CollidableObjects.Block;

/**
 * Methods for objects that gets notified for hit events.
 */
public interface HitListener {

    /**
     * The method is called whenever the beingHit object is hit.
     * @param beingHit - the block that has been hit
     * @param hitter - the ball made the hit
     */
    void hitEvent(Block beingHit, Ball hitter);
}
