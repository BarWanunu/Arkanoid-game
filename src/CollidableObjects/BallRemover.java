// Bar Wanunu 209422435

package CollidableObjects;

import Game.GameLevel;
import Geometry.Counter;
import Interfaces.HitListener;

/**
 * Ball remover class - has the constructor and methods for ball remover and
 * implements the HitListener interface.
 */
public class BallRemover
        implements HitListener {

    // Fields

    private GameLevel gameLevel;
    private Geometry.Counter remainingBalls;

    // Constructor

    /**
     * Making a new ball remover.
     *
     * @param gameLevel           - a gameLevel
     * @param remainingBalls - counter of remaining balls
     */
    public BallRemover(GameLevel gameLevel, Counter remainingBalls) {
        this.gameLevel = gameLevel;
        this.remainingBalls = remainingBalls;
    }

    // Methods

    @Override public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.gameLevel);
        this.remainingBalls.decrease(1);
    }
}
