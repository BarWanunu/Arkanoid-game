// Bar Wanunu 209422435

package Collision;

import Geometry.Line;
import Geometry.Point;
import Geometry.Rectangle;
import Interfaces.Collidable;

import java.util.ArrayList;
import java.util.List;

/**
 * GameEnvironment class - contains the constructor and methods of
 * GameEnvironment.
 */
public class GameEnvironment {

    // Fields

    private List<Collidable> collidables;

    // Constructor

    /**
     * Making a new list of collidables of Collision.GameEnvironment.
     *
     * @param collidables - the list of collidables
     */
    public GameEnvironment(List<Collidable> collidables) {
        this.collidables = collidables;
    }

    /**
     * Creating an empty list.
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<>();
    }

    // Methods

    /**
     * The method returns the list of collidables collection.
     * @return - List of collidables collection
     */
    public List<Collidable> getCollidables() {
        return this.collidables;
    }

    /**
     * The method returns the size of the GameLevel.GameLevel Environment.
     * @return - the number of collidables
     */
    public int sizeOfGame() {
        return this.collidables.size();
    }

    /**
     * Getting a collidable object and adding to the list.
     *
     * @param c - a collidable we add to the list
     */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }

    /**
     * The method returns the collidable in the i place of the list.
     *
     * @param i - the index
     * @return - a collidable object
     */
    public Collidable getCollidable(int i) {
        return this.collidables.get(i);
    }

    /**
     * The method checks if there's any collision point for the game
     * environment collidables with the line.
     *
     * @param line - the line we check collision with
     * @return - TRUE/FALSE
     */
    public boolean isColliding(Line line) {
        for (int i = 0; i < this.collidables.size(); i++) {
            Rectangle r = this.collidables.get(i).getCollisionRectangle();
            // making a list of all the collision points of the line
            List<Point> intersectionPoints = r.intersectionPoints(line);
            if (!intersectionPoints.isEmpty()) {
                // returning true if there's a collision point
                return true;
            }
        }
        // false means there weren't any collision point
        return false;
    }

    /**
     * The method checks with all the collidables object that have a
     * collision point with the line who is the closest to the start of the
     * line.
     *
     * @param collision - a list with all the collidable object the line
     *                  collides with
     * @param line      - the line we check
     * @return - the collidable with the nearest collision point
     */
    public Collidable minPoint(List<Collidable> collision, Line line) {
        int minIndex = 0;
        for (int i = 0; i < collision.size(); i++) {
            Rectangle r = collision.get(i).getCollisionRectangle();
            /*
             * checking if the intersection point of the current rectangle is
             * closer than the min index
             */
            if (line.closestIntersectionToStartOfLine(r).distance(line.start())
                    < line.closestIntersectionToStartOfLine(
                    collision.get(minIndex)
                            .getCollisionRectangle()).distance(line.start())) {
                // giving minIndex the value of i
                minIndex = i;
            }
        }
        // returning the collidable with the nearest collision point
        return collision.get(minIndex);
    }

    /**
     * The method gets a line and checks which collision point is the nearest
     * to the start of the line.
     *
     * @param trajectory - the line we check the collisions
     * @return - a Collision.CollisionInfo object with the collision point and the
     * collidable
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        // if there isn't any collision with the line
        if (!isColliding(trajectory)) {
            return null;
        }
        List<Collidable> collision = new ArrayList<>();
        for (int i = 0; i < this.collidables.size(); i++) {
            Rectangle r = this.collidables.get(i).getCollisionRectangle();
            // checking if the line collides with the specific rectangle
            if (trajectory.closestIntersectionToStartOfLine(r) != null) {
                // adding the collidable to the list
                collision.add(this.collidables.get(i));
            }
        }
        // getting the collidable with the nearest point to the line start
        Collidable c = minPoint(collision, trajectory);
        // returning the new Collision.CollisionInfo
        return new CollisionInfo(trajectory.closestIntersectionToStartOfLine(
                c.getCollisionRectangle()), c);
    }
}
