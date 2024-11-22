// Bar Wanunu 209422435

package GameAddsOn;

import CollidableObjects.Ball;
import CollidableObjects.Block;
import Geometry.Counter;
import Interfaces.HitListener;

/**
 * ScoreTrackingListener - contains the constructor and methods of
 * ScoreTrackingListener. keeps count of the score of the game.
 */
public class ScoreTrackingListener
        implements HitListener {

    private static final int BLOCK_POINTS = 5;

    // Fields
    private Counter currentScore;

    // Constructor

    /**
     * Making a new score tracking listener.
     *
     * @param scoreCounter - the game score counter
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    // Methods

    @Override public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(BLOCK_POINTS);
    }
}
