// Bar Wanunu 209422435

package CollidableObjects;

import Collision.CollisionInfo;
import Collision.GameEnvironment;
import Game.GameLevel;
import Geometry.Line;
import Geometry.Point;
import Geometry.Rectangle;
import Geometry.Velocity;
import Interfaces.Collidable;
import Interfaces.HitListener;
import Interfaces.HitNotifier;
import Interfaces.Sprite;
import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * Ball class - contains the Ball constructor and methods Implements
 * the methods of Sprite interface and hitNotifier.
 */
public class Ball
        implements Sprite, HitNotifier {

    // Members

    private Point center;
    private int r;
    private java.awt.Color color;
    private Velocity velocity;
    private int width;
    private int height;
    private GameEnvironment gameEnvironment;
    private List<HitListener> hitListeners;

    //Constructor

    /**
     * Making a new ball.
     *
     * @param center - contains the center point of the ball
     * @param r      - the radius of the ball
     * @param color  - the color of the ball
     * @param g      - the game environment of the ball
     */
    public Ball(Point center, int r, java.awt.Color color, GameEnvironment g) {
        this.center = center;
        this.r = r;
        this.color = color;
        // assigning zero velocity at first for the ball
        this.velocity = new Velocity(0, 0);
        this.width = 0;
        this.height = 0;
        this.gameEnvironment = g;
        this.hitListeners = new ArrayList<>();
    }

    // Methods

    /**
     * Getting the x value of the center of the ball.
     *
     * @return - the x value
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * Getting the y value of the center of the ball.
     *
     * @return - the y value
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * Getting the size of the ball.
     *
     * @return - the size (radius)
     */
    public int getSize() {
        return this.r;
    }

    /**
     * Getting the speed of the ball.
     *
     * @return - Geometry.Velocity
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * Getting the color of the ball.
     *
     * @return - the color of the ball
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * Getting the game environment.
     *
     * @return - the game environment of the ball
     */
    public GameEnvironment getGameEnvironment() {
        return this.gameEnvironment;
    }

    /**
     * Setting a new velocity to the ball.
     *
     * @param v - the velocity value we want to set
     */

    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * Setting the width field for the ball.
     *
     * @param width - the width of the surface
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Setting the height field for the ball.
     *
     * @param height - the height of the surface
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * The method draws the ball on a given DrawSurface.
     *
     * @param surface - a surface sent as an argument to the function
     */
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.getColor());
        // drawing the ball with it color
        surface.fillCircle(this.getX(), this.getY(), this.getSize());
    }

    /**
     * The method check an edge case where the ball hits exactly at the
     * corner of two of the surface boundaries.
     *
     * @param collisionPoint - collision point of the ball with a collidable
     * @param v              - the velocity of the ball before the changes
     */
    public void isInCornerOfSurface(Point collisionPoint, Velocity v) {
        // putting the boundaries in a rectangle array
        Rectangle[] r = getBoundaries();
        // creating the corner points of the boundaries
        Point topAndLeft = new Point(r[1].getUpperRight().getX(),
                r[1].getUpperRight().getY());
        Point topAndRight = new Point(r[2].getUpperLeft().getX(),
                r[2].getUpperLeft().getY());
        Point leftAndBottom = new Point(r[3].getUpperLeft().getX(),
                r[3].getUpperLeft().getY());
        Point rightAndBottom = new Point(r[3].getUpperRight().getX(),
                r[3].getUpperRight().getY());
        // checking if the change was only in the dx value
        if (v.getDx() == -this.velocity.getDx()) {
            // checking if the collision point equal to one of the corners
            if (collisionPoint.equals(topAndLeft)
                    || collisionPoint.equals(topAndRight)
                    || collisionPoint.equals(leftAndBottom)
                    || collisionPoint.equals(rightAndBottom)) {
                // changing the value of dy
                this.velocity = new Velocity(this.velocity.getDx(),
                        -this.velocity.getDy());
            }
            // change only in dy
        } else if (v.getDy() == -this.velocity.getDy()) {
            // checking if the collision point equal to one of the corners
            if (collisionPoint.equals(topAndLeft)
                    || collisionPoint.equals(topAndRight)
                    || collisionPoint.equals(leftAndBottom)
                    || collisionPoint.equals(rightAndBottom)) {
                // changing the value of dx
                this.velocity = new Velocity(-this.velocity.getDx(),
                        this.velocity.getDy());
            }
        }
    }

    /**
     * The method checks if the collision point is exactly in the corner of
     * two blocks and handle it if so.
     *
     * @param collision - the collision point of the ball with a collidable
     * @param v         - the velocity of the ball
     * @param c         - the collidable the collision occurred with
     */
    public void isInCornerOfBlocks(Point collision, Velocity v, Collidable c) {
        for (int i = 0; i < this.gameEnvironment.sizeOfGame(); i++) {
            Rectangle
                    r = this.gameEnvironment.getCollidable(i)
                    .getCollisionRectangle();
            // if the current rectangle is the one the collision occurred with
            if (r == c.getCollisionRectangle()) {
                continue;
            }
            // checks if the collision is equal to one of the rectangle corners
            if (collision.equals(r.getUpperLeft())
                    || collision.equals(r.getUpperRight())
                    || collision.equals(r.getLowerLeft())
                    || collision.equals(r.getLowerRight())) {
                // checking if the change was only in the dx value
                if (v.getDx() == -this.velocity.getDx() && v.getDx() != 0) {
                    // changing the value of dy
                    this.velocity = new Velocity(this.velocity.getDx(),
                            -this.velocity.getDy());
                    this.velocity.applyToPoint(collision);
                    return;
                } else if (v.getDy() == -this.velocity.getDy()
                        && v.getDy() != 0) { // change only in dy
                    // changing the value of dx
                    this.velocity = new Velocity(-this.velocity.getDx(),
                            this.velocity.getDy());
                    this.velocity.applyToPoint(collision);
                    return;
                }
            }
        }
    }

    /**
     * The method creates a line that resembles the movement of the ball and
     * checks if there's any collision for the line with a collidable object.
     * If so, we change the velocity of the ball and the center point
     * accordingly and if not the ball move as suppose to.
     */
    public void moveOneStep() {
        // creating the line
        Velocity v = this.getVelocity();
        Line trajectory = new Line(this.center,
                this.velocity.applyToPoint(this.center));
        CollisionInfo collisionInfo =
                this.gameEnvironment.getClosestCollision(trajectory);
        // there's no collision point for the line
        if (collisionInfo == null) {
            this.center = this.velocity.applyToPoint(this.center);
        } else {
            // calculating the new velocity after the hit
            this.velocity = collisionInfo.collisionObject()
                    .hit(this, collisionInfo.collisionPoint(), this.velocity);
            // checks if the collision point is in the corner of the surface
            isInCornerOfSurface(collisionInfo.collisionPoint(), v);
            // checks if the collision point is in the corner of the block
            isInCornerOfBlocks(collisionInfo.collisionPoint(), v,
                    collisionInfo.collisionObject());
            // applying the new point to the center of the ball
            this.center = this.getVelocity().applyToPoint(this.center);
            // checking the ball is inside the surface
            this.notInBoundaries(collisionInfo.collisionPoint());
            this.notifyHit(collisionInfo.collisionObject());
        }
    }

    /**
     * The method is called after the change of the center point in moveOneStep
     * and checks if the new center point is outside the boundaries of the
     * surface or if it's inside the blocks/paddles. If so, the method changes
     * the velocity of the ball according to the values and creates a new
     * center point using applyToPoint.
     *
     * @param collision - the collision point
     */
    public void notInBoundaries(Point collision) {
        Rectangle[] rectangles = getBoundaries();
        // the ball is in the top boundary
        if (rectangles[0].isInsideRectangle(this.center)) {
            // if the ball dy is negative after hitting the top we change it
            if (this.velocity.getDy() < 0) {
                this.velocity = new Velocity(this.velocity.getDx(),
                        -this.velocity.getDy());
                this.center = this.velocity.applyToPoint(collision);
            }
        }
        // the ball is in the left boundary
        if (rectangles[1].isInsideRectangle(this.center)) {
            // if the ball dx is negative after hitting the left we change it
            if (this.velocity.getDx() < 0) {
                this.velocity = new Velocity(-this.velocity.getDx(),
                        this.velocity.getDy());
                this.center = this.velocity.applyToPoint(collision);
            }
        }
        // the ball is in the right boundary
        if (rectangles[2].isInsideRectangle(this.center)) {
            // if the ball dx is positive after hitting the right we change it
            if (this.velocity.getDx() > 0) {
                this.velocity = new Velocity(-this.velocity.getDx(),
                        this.velocity.getDy());
                this.center = this.velocity.applyToPoint(collision);
            }
        }
        // the ball is in the bottom boundary
        if (rectangles[3].isInsideRectangle(this.center)) {
            // if the ball dy is positive after hitting the bottom we change it
            if (this.velocity.getDy() > 0) {
                this.velocity = new Velocity(this.velocity.getDx(),
                        -this.velocity.getDy());
                this.center = this.velocity.applyToPoint(collision);
            }
        }
        for (int i = 4; i < this.gameEnvironment.sizeOfGame(); i++) {
            /*
             * checks if the ball is inside one of the collidables except the
             * boundaries
             */
            if (this.gameEnvironment.getCollidable(i).getCollisionRectangle()
                    .isInsideRectangle(this.center)) {
                this.velocity = new Velocity(-this.velocity.getDx(),
                        -this.velocity.getDy());
                this.center = this.velocity.applyToPoint(this.center);
            }
        }
    }

    /**
     * The method creates an array of 4 rectangles that they're the boundaries
     * of the surface.
     *
     * @return - an array of rectangles
     */
    public Rectangle[] getBoundaries() {
        Rectangle[] r = new Rectangle[4];
        for (int i = 0; i < r.length; i++) {
            r[i] = this.gameEnvironment.getCollidable(i + 1)
                    .getCollisionRectangle();
        }
        return r;
    }

    @Override
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * The method get a game variable and adds the ball as a sprite.
     *
     * @param g - a GameLevel.GameLevel
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * The method removes the ball from the game.
     *
     * @param g - a game
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }

    @Override public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    private void notifyHit(Collidable collidable) {
        // checking if the collidable object is the death region
        if (collidable.equals(this.getGameEnvironment()
                .getCollidable(this.gameEnvironment.sizeOfGame() - 1))) {
            // Make a copy of the hitListeners before iterating over them.
            List<HitListener> listeners =
                    new ArrayList<>(this.hitListeners);
            // Notify all listeners about a hit event:
            for (HitListener hl : listeners) {
                hl.hitEvent((Block) collidable, this);
            }
        }
    }
}
