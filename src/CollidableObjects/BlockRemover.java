// Bar Wanunu 209422435

package CollidableObjects;

import Game.GameLevel;
import Interfaces.HitListener;

/**
 * Block Remover class - contains the constructor and methods of BlockRemover,
 * and implements the HitListener interface.
 */
public class BlockRemover
        implements HitListener {

    // Fields

    private GameLevel gameLevel;
    private Geometry.Counter remainingBlocks;

    // Constructor

    /**
     * Making a new BlockRemover.
     * @param gameLevel - a gameLevel
     * @param remainingBlocks - counter of remaining blocks
     */
    public BlockRemover(GameLevel gameLevel, Geometry.Counter remainingBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = remainingBlocks;
    }

    // Methods

    @Override public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(this.gameLevel);
        this.remainingBlocks.decrease(1);
    }
}
