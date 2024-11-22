// Bar Wanunu 209422435

package Geometry;

import java.util.ArrayList;
import java.util.List;

/**
 * Rectangle class - contains the constructor and methods of Geometry.Rectangle.
 */
public class Rectangle {

    // Fields

    private Point upperLeft;
    private double width;
    private double height;

    // Constructor

    /**
     * Making a new rectangle.
     *
     * @param upperLeft - the upper left point of the rectangle
     * @param width     - the width point of the rectangle
     * @param height    - the height point of the rectangle
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    // Methods

    /**
     * Getting the width of the rectangle.
     *
     * @return - the width of the rectangle
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Getting the height of the rectangle.
     *
     * @return - the height of the rectangle
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Getting the upper left point of the rectangle.
     *
     * @return - the upper left point of the rectangle
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * Getting the upper right point of the rectangle.
     *
     * @return - the upper right point of the rectangle
     */
    public Point getUpperRight() {
        return new Point(this.upperLeft.getX() + this.width,
                this.upperLeft.getY());
    }

    /**
     * Getting the lower left point of the rectangle.
     *
     * @return - the lower left point of the rectangle
     */
    public Point getLowerLeft() {
        return new Point(this.upperLeft.getX(),
                this.upperLeft.getY() + this.height);
    }

    /**
     * Getting the lower right point of the rectangle.
     *
     * @return - the lower right point of the rectangle
     */
    public Point getLowerRight() {
        return new Point(this.upperLeft.getX() + width,
                this.upperLeft.getY() + height);
    }

    /**
     * The method checks if the point is inside the rectangle.
     *
     * @param point - the point we want to check
     * @return - TRUE/FALSE
     */
    public boolean isInsideRectangle(Point point) {
        double x = point.getX();
        double y = point.getY();
        double rectX = this.getUpperLeft().getX();
        double rectY = this.getUpperLeft().getY();
        double rectWidth = this.getWidth();
        double rectHeight = this.getHeight();
        // returning true/false depends on if the point is in the rectangle
        return (x >= rectX && x <= rectX + rectWidth)
                && (y >= rectY && y <= rectY + rectHeight);
    }

    /**
     * The method creats four lines based on the rectangle verticals and
     * checks each one of them with the input line to see if there are any
     * intersection points.
     *
     * @param line - the line we check the intersection points with
     * @return - a list contains all the intersection points between the
     * rectangle and the line
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        // making lines object from the rectangle verticals
        Line left = new Line(this.getUpperLeft(), this.getLowerLeft());
        Line right = new Line(this.getUpperRight(), this.getLowerRight());
        Line top = new Line(this.getUpperLeft(), this.getUpperRight());
        Line bottom = new Line(this.getLowerLeft(), this.getLowerRight());
        List<Point> intersectionPoints = new ArrayList<>();
        // checks intersection with the left vertical
        if (left.isIntersecting(line)) {
            if (left.intersectionWith(line) != null) {
                intersectionPoints.add(left.intersectionWith(line));
            }
        }
        // checks intersection with the right vertical
        if (right.isIntersecting(line)) {
            if (right.intersectionWith(line) != null) {
                intersectionPoints.add(right.intersectionWith(line));
            }
        }
        // checks intersection with the top vertical
        if (top.isIntersecting(line)) {
            if (top.intersectionWith(line) != null) {
                intersectionPoints.add(top.intersectionWith(line));
            }
        }
        // checks intersection with the bottom vertical
        if (bottom.isIntersecting(line)) {
            if (bottom.intersectionWith(line) != null) {
                intersectionPoints.add(bottom.intersectionWith(line));
            }
        }
        return intersectionPoints;
    }
}