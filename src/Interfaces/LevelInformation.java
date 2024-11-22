// Bar Wanunu 209422435

package Interfaces;

import CollidableObjects.Block;
import Geometry.Velocity;

import java.util.List;


/**
 * LevelInformation interface.
 */
public interface LevelInformation {
    /**
     * The method returns the number of balls for the level.
     * @return - number of balls
     */
    int numberOfBalls();

    /**
     * The method returns a list for the velocity for each ball.
     * @return - list of velocities
     */
    List<Velocity> initialBallVelocities();

    /**
     * The method returns the velocity of the paddle.
     * @return - the velocity of the paddle
     */
    int paddleSpeed();

    /**
     * The method returns the width of the paddle.
     * @return - the width of the paddle
     */
    int paddleWidth();

    /**
     * The method returns the level name.
     * @return - the level name
     */
    String levelName();

    /**
     * The method returns a sprite with the background of the level.
     * @return - a sprite with the background of the level
     */
    Sprite getBackground();

    /**
     * The method returns a list of blocks for the level containing the size,
     * color and location for each block.
     * @return - list of blocks
     */
    List<Block> blocks();

    /**
     * The method returns the number of blocks that need to be removed from
     * the level.
     * @return - number of minimum blocks to finish the level
     */
    int numberOfBlocksToRemove();
}
