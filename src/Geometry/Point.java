// Bar Wanunu 209422435

package Geometry;

/**
 * Geometry.Point class - contains the Geometry.Point constructor and methods.
 */
public class Point {
    //defining magic numbers
    private static final int TWO = 2;
    private static final double THRESHOLD = 0.00000000000001;

    // Fields

    private double x;
    private double y;

    //Constructor

    /**
     * Making a new point.
     *
     * @param x - The x value of the point
     * @param y - The y value of the point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //Methods

    /**
     * A common way to compare doubles.
     *
     * @param x - first variable
     * @param y - second variable
     * @return - TRUE/FALSE
     */
    public static boolean isInRangeOfEpsilon(double x, double y) {
        return (x >= y - THRESHOLD) && (x <= y + THRESHOLD);
    }

    /**
     * Distance - calculating the distance between two points.
     *
     * @param other - the point we check the distance from
     * @return the distance between the points in double variable
     */
    public double distance(Point other) {
        // result = (x1-x2)^2 - (y1-y2)^2
        double result = (Math.pow(this.x - other.x, TWO)
                + Math.pow(this.y - other.y, TWO));
        return Math.sqrt(result);
    }

    /**
     * Return true is the points are equal, false otherwise.
     *
     * @param other - the point we check if it's equal
     * @return TRUE/FALSE
     */
    public boolean equals(Point other) {
        return (isInRangeOfEpsilon(this.getX(), other.getX()))
                && (isInRangeOfEpsilon(this.getY(), other.getY()));
    }

    /**
     * Getting the x value of the point.
     *
     * @return - the x value
     */
    public double getX() {
        return this.x;
    }

    /**
     * Getting the y value of the point.
     *
     * @return - the y value
     */
    public double getY() {
        return this.y;
    }
}