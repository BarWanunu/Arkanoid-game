// Bar Wanunu 209422435

package Collision;

import Geometry.Point;
import Interfaces.Collidable;

/**
 * CollisionInfo class-contains the constructor and methods for Collision.
 */
public class CollisionInfo {

    // Fields

    private Point collisionPoint;
    private Collidable collidable;

    // Constructor

    /**
     * Making a Collision.CollisionInfo object.
     *
     * @param collisionPoint - the point of the collision
     * @param collidable     - the collidable object
     */
    public CollisionInfo(Point collisionPoint, Collidable collidable) {
        this.collisionPoint = collisionPoint;
        this.collidable = collidable;
    }

    // Methods

    /**
     * Returning the collision point of the object.
     *
     * @return - the collision point
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * Returning the collidable object in the collision.
     *
     * @return - the collidable object
     */
    public Collidable collisionObject() {
        return this.collidable;
    }
}
