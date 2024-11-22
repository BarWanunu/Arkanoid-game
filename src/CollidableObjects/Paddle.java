// Bar Wanunu 209422435
package CollidableObjects;

import Game.GameLevel;
import Geometry.Line;
import Geometry.Point;
import Geometry.Rectangle;
import Geometry.Velocity;
import Interfaces.Collidable;
import Interfaces.Sprite;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * Paddle class - contains the Paddle constructor and methods. Implements the
 * Sprite and Collidable interfaces. The paddle is the player in the game and
 * moves right and left.
 */
public class Paddle
        implements Sprite, Collidable {

    // defining magic numbers
    private static final int LEFT_REGION = 1;
    private static final int MIDDLE_REGION = 3;
    private static final int RIGHT_REGION = 5;
    private static final int LEFT_BOUNDARY = 25;
    private static final int RIGHT_BOUNDARY = 775;


    // Fields

    private Rectangle rectangle;
    private biuoop.KeyboardSensor keyboardSensor;
    private Color color;
    private int speed;

    // Constructor

    /**
     * Creating a new CollidableObjects.Paddle.
     *
     * @param rectangle      - the rectangle of the paddle
     * @param keyboardSensor - a key board sensor
     * @param color          - the color of the paddle
     * @param speed - the speed of the paddle
     */
    public Paddle(Rectangle rectangle, KeyboardSensor keyboardSensor,
                  Color color, int speed) {
        this.rectangle = rectangle;
        this.keyboardSensor = keyboardSensor;
        this.color = color;
        this.speed = speed;
    }


    // Methods

    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * The method gets the collision point and check which region of the
     * block it belongs.
     *
     * @param collision - the collision point
     * @return - the region number of the collision point
     */
    public int getRegion(Point collision) {
        // getting the width of the paddle
        double regionWidth =
                this.getCollisionRectangle().getWidth() / 5.0;
        double leftEdge =
                this.getCollisionRectangle().getUpperLeft().getX();
        // getting the center x value of each region
        double regionCenter1 = leftEdge + regionWidth / 2.0;
        double regionCenter2 = regionCenter1 + regionWidth;
        double regionCenter3 = regionCenter2 + regionWidth;
        double regionCenter4 = regionCenter3 + regionWidth;
        // check for every region if the x value is in the region
        if (collision.getX() <= regionCenter1) {
            return LEFT_REGION;
        } else if (collision.getX() > regionCenter1
                && collision.getX() <= regionCenter2) {
            return LEFT_REGION + 1;
        } else if (collision.getX() > regionCenter2
                && collision.getX() <= regionCenter3) {
            return MIDDLE_REGION;
        } else if (collision.getX() > regionCenter3
                && collision.getX() <= regionCenter4) {
            return RIGHT_REGION - 1;
        } else {
            return RIGHT_REGION;
        }
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint,
                        Velocity currentVelocity) {
        // getting the region of the collision
        int region = getRegion(collisionPoint);
        // calculating the speed of the ball (square root of (dx^2 + dy^2))
        double speed =
                Math.sqrt((currentVelocity.getDx() * currentVelocity.getDx())
                        + (currentVelocity.getDy() * currentVelocity.getDy()));
        // creating a line that is the top line of the paddle
        Line top = new Line(this.rectangle.getUpperLeft(),
                this.rectangle.getUpperRight());
        // check if the line contains the collisionPoint
        if (top.containsPoint(collisionPoint)) {
            // assigning current velocity in match to each region
            if (region == LEFT_REGION) {
                currentVelocity = Velocity.fromAngleAndSpeed(300, speed);
            } else if (region == LEFT_REGION + 1) {
                currentVelocity = Velocity.fromAngleAndSpeed(330, speed);
            } else if (region == MIDDLE_REGION) {
                currentVelocity = new Velocity(currentVelocity.getDx(),
                        -currentVelocity.getDy());
            } else if (region == MIDDLE_REGION + 1) {
                currentVelocity = Velocity.fromAngleAndSpeed(30, speed);
            } else if (region == RIGHT_REGION) {
                currentVelocity = Velocity.fromAngleAndSpeed(60, speed);
            }
            // if somehow after the collision the dy is positive we change it
            if (currentVelocity.getDy() > 0) {
                currentVelocity = new Velocity(currentVelocity.getDx(),
                        -currentVelocity.getDy());
            }
        }
        // creating a left, right lines from the paddle rectangle
        Line left =
                new Line(this.getCollisionRectangle().getUpperLeft(),
                        this.getCollisionRectangle().getLowerLeft());
        Line right =
                new Line(this.getCollisionRectangle().getUpperRight(),
                        this.getCollisionRectangle().getLowerRight());
        // check if the ball hit the left or right edges of the paddle
        if (left.containsPoint(collisionPoint)
                || right.containsPoint(collisionPoint)) {
            // changing the dx value of the velocity
            currentVelocity = new Velocity(-currentVelocity.getDx(),
                    currentVelocity.getDy());
        }
        return currentVelocity;
    }

    @Override
    public void timePassed() {
        // checks which keyboard arrow was pressed
        if (keyboardSensor.isPressed(keyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        } else if (keyboardSensor.isPressed(keyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        // drawing the paddle with it color
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(),
                (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(),
                (int) this.rectangle.getHeight());
        d.setColor(Color.black);
        // drawing the lines of the paddle in black
        d.drawRectangle((int) this.rectangle.getUpperLeft().getX(),
                (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(),
                (int) this.rectangle.getHeight());
    }

    /**
     * The method get a game variable and adds the paddle as a sprite and
     * collidable.
     *
     * @param g - a game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * The method creates a new rectangle where is upper left point is as the
     * same the specific rectangle but const movement to the left.
     */
    public void moveLeft() {
        // checks the x of the upper left corner is not outside the boundaries
        double newX = this.getCollisionRectangle().getUpperLeft()
                .getX() - speed;
        if (newX < LEFT_BOUNDARY) {
            newX = LEFT_BOUNDARY;
        }
        // creates a new rectangle in the new point after the movement
        this.rectangle =
                new Rectangle(new Point(newX, this.getCollisionRectangle()
                        .getUpperLeft().getY()), this.getCollisionRectangle()
                        .getWidth(), this.getCollisionRectangle().getHeight());
    }

    /**
     * The method creates a new rectangle where is upper left point is as the
     * same the specific rectangle but const movement to the right.
     */
    public void moveRight() {
        // checks the x of the upper right corner is not outside the boundaries
        double newX =
                this.getCollisionRectangle().getUpperLeft().getX() + speed;
        if (newX + this.getCollisionRectangle().getWidth() > RIGHT_BOUNDARY) {
            newX = RIGHT_BOUNDARY - this.getCollisionRectangle().getWidth();
        }
        // creates a new rectangle in the new point after the movement
        this.rectangle =
                new Rectangle(new Point(newX, this.getCollisionRectangle()
                        .getUpperLeft().getY()), this.getCollisionRectangle()
                        .getWidth(), this.getCollisionRectangle().getHeight());
    }
}



