// Bar Wanunu 209422435
package CollidableObjects;

import Geometry.Line;
import Geometry.Point;
import Geometry.Rectangle;
import Geometry.Velocity;
import Interfaces.Collidable;
import Interfaces.HitListener;
import Interfaces.HitNotifier;
import Interfaces.Sprite;
import Game.GameLevel;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Block class - contains the constructor and methods of Block. Implements
 * the functions of Interfaces.Collidable and Interfaces.Sprite interfaces.
 */
public class Block
        implements Collidable, Sprite, HitNotifier {

    // Members

    private Rectangle rectangle;
    private java.awt.Color color;

    private List<HitListener> hitListeners;


    // Constructor

    /**
     * Making a new block.
     *
     * @param rectangle - the size of the block
     * @param color     - the color of the block
     */
    public Block(Rectangle rectangle, java.awt.Color color) {
        this.rectangle = rectangle;
        this.color = color;
        this.hitListeners = new ArrayList<>();
    }

    //Methods

    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * The method returns the color of the block.
     *
     * @return - color of the block
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint,
                        Velocity currentVelocity) {
        // making lines from all the vertical of the rectangle
        Line top = new Line(this.rectangle.getUpperLeft(),
                this.rectangle.getUpperRight());
        Line bottom = new Line(this.rectangle.getLowerLeft(),
                this.rectangle.getLowerRight());
        Line left = new Line(this.rectangle.getUpperLeft(),
                this.rectangle.getLowerLeft());
        Line right = new Line(this.rectangle.getUpperRight(),
                this.rectangle.getLowerRight());
        // checking if it hit the top or bottom of the block to change the dy
        if (top.containsPoint(collisionPoint)
                || bottom.containsPoint(collisionPoint)) {
            currentVelocity = new Velocity(currentVelocity.getDx(),
                    -currentVelocity.getDy());
        }
        // checking if it hit the left or right of the block to change the dx
        if (left.containsPoint(collisionPoint)
                || right.containsPoint(collisionPoint)) {
            currentVelocity = new Velocity(-currentVelocity.getDx(),
                    currentVelocity.getDy());
        }
        this.notifyHit(hitter);
        return currentVelocity;
    }

    /**
     * The method draws the block on a given DrawSurface.
     *
     * @param surface - a surface sent as an argument to the function
     */
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        // drawing the block with it color
        surface.fillRectangle((int) this.rectangle.getUpperLeft().getX(),
                (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(),
                (int) this.rectangle.getHeight());
        surface.setColor(Color.black);
        // drawing the lines of the block in black
        surface.drawRectangle((int) this.rectangle.getUpperLeft().getX(),
                (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(),
                (int) this.rectangle.getHeight());
    }

    @Override
    public void timePassed() {
    }

    /**
     * The method get a game variable and adds the block as a sprite and
     * collidable.
     *
     * @param g - a game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * The method removes the block from the sprite and collidable
     * collections of the game.
     *
     * @param g - a game
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
        g.removeCollidable(this);
    }

    @Override public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * The method is being called whenever there's a hit. The method creates a
     * new list of HitListeners and notify all the listeners about the hit
     * event.
     *
     * @param hitter - the ball that made the hit
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners =
                new ArrayList<>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}

