// Bar Wanunu 209422435

package Interfaces;

import CollidableObjects.Ball;
import Geometry.Point;
import Geometry.Rectangle;
import Geometry.Velocity;

/**
 * Interfaces.Collidable - methods for objects there's collision with them.
 */
public interface Collidable {

    /**
     * Getting the rectangle object.
     * @return - a rectangle
     */
    Rectangle getCollisionRectangle();

    /**
     * The method changes the object velocity according to the collision
     * point with the rectangle.
     * @param collisionPoint - the collision point with the rectangle
     * @param currentVelocity - the current velocity of the object
     * @param hitter - the ball that hit
     * @return - the updated velocity after the collision
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
