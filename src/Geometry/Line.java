// Bar Wanunu 209422435

package Geometry;

import java.util.List;

/**
 * Line class - contains the Geometry.Line constructor and methods.
 */
public class Line {
    //defining magic numbers
    private static final int ZERO_SLOPE = 0;
    private static final int TWO = 2;

    // Fields

    private Point start;
    private Point end;

    //Constructors

    /**
     * Making a Geometry.Line when the user gives us two points.
     *
     * @param start - the starting points of the line
     * @param end   - the ending point of the line
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Making a line with indexes of the points.
     *
     * @param x1 - the x value of the first point
     * @param y1 - the y value of the first point
     * @param x2 - the x value of the second point
     * @param y2 - the y value of the second point
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    //Methods

    /**
     * Calculating the length of the line using Geometry.Point methods.
     *
     * @return - the distance between the end and start points
     */
    public double length() {
        return this.end.distance(this.start);
    }

    /**
     * Making a point which is the middle of the line.
     *
     * @return - the middle point of the line
     */
    public Point middle() {
        double midX = ((this.start.getX() + this.end.getX()) / TWO);
        double midY = ((this.start.getY() + this.end.getY()) / TWO);
        return new Point(midX, midY);
    }

    /**
     * Getting the starting point of the line.
     *
     * @return - starting point of the line
     */
    public Point start() {
        return this.start;
    }

    /**
     * Getting the ending point of the line.
     *
     * @return - ending point if the line
     */
    public Point end() {
        return this.end;
    }

    /**
     * Checking if both of the lines are equal.
     *
     * @param other - the line we check if it's equal
     * @return - TRUE/FALSE
     */
    public boolean equals(Line other) {
        boolean check1 = (this.start.equals(other.start))
                && (this.end.equals(other.end));
        boolean check2 = (this.start.equals(other.end))
                && (this.end.equals(other.start));
        return check1 || check2;
    }

    /**
     * Calculating the slope of the line.
     *
     * @return - the slope. the m in y=mx+b
     */
    public double getSlope() {
        // the slope = 0. if two points have the same x/y values
        if (this.start.getX() == this.end.getX()
                || this.start.getY() == this.end.getY()) {
            return ZERO_SLOPE;
        } else {
            // y2-y1 / x2-x1
            return (this.end.getY() - this.start.getY())
                    / (this.end.getX() - this.start.getX());
        }
    }

    /**
     * Checking if the x,y points of the intersection are within the limits
     * of the lines.
     *
     * @param other - the line we check the intersection
     * @param x     - the x value of the intersection
     * @param y     - the y value of the intersection
     * @return - TRUE/FALSE
     */
    public boolean isInLimits(Line other, double x, double y) {
        // checks if x and y are all within the limits of the lines
        return x >= Math.min(this.start.getX(), this.end.getX())
                && x <= Math.max(this.start.getX(), this.end.getX())
                && x >= Math.min(other.start.getX(), other.end.getX())
                && x <= Math.max(other.start.getX(), other.end.getX())
                && y >= Math.min(this.start.getY(), this.end.getY())
                && y <= Math.max(this.start.getY(), this.end.getY())
                && y >= Math.min(other.start.getY(), other.end.getY())
                && y <= Math.max(other.start.getY(), other.end.getY())
                || y >= Math.min(this.start.getX(), this.end.getX())
                && y <= Math.max(this.start.getX(), this.end.getX())
                && y >= Math.min(other.start.getX(), other.end.getX())
                && y <= Math.max(other.start.getX(), other.end.getX())
                && x >= Math.min(this.start.getY(), this.end.getY())
                && x <= Math.max(this.start.getY(), this.end.getY())
                && x >= Math.min(other.start.getY(), other.end.getY())
                && x <= Math.max(other.start.getY(), other.end.getY());
    }

    /**
     * The method checks if a point is within the bounds of the line.
     *
     * @param point - the point we want to check if it's within the bounds of
     *              the other line
     * @return - TRUE/FALSE
     */
    public boolean containsPoint(Point point) {
        double maxX = Math.max(this.start.getX(), this.end.getX());
        double minX = Math.min(this.start.getX(), this.end.getX());
        double maxY = Math.max(this.start.getY(), this.end.getY());
        double minY = Math.min(this.start.getY(), this.end.getY());

        return (point.getX() >= minX && point.getX() <= maxX
                && point.getY() >= minY && point.getY() <= maxY);
    }

    /**
     * The method returns the length of the furthest points between the lines.
     *
     * @param other - the line we measure with
     * @return - the biggest distance
     */
    public double biggestLength(Line other) {
        double length1 = this.start.distance(other.end);
        double length2 = this.start.distance(other.start);
        double length3 = this.end.distance(other.start);
        double length4 = this.end.distance(other.end);
        return Math.max(Math.max(length1, length2),
                Math.max(length3, length4));
    }

    /**
     * The method helps to indicate if a line is partially contained within
     * another by checking if the distance  from the furthest points is
     * smaller than the sum of the lines lengths.
     *
     * @param other - the line we measure with
     * @return - TRUE/FALSE
     */
    public boolean isLengthShorter(Line other) {
        double length = this.length() + other.length();
        double lengthCheck = this.biggestLength(other);
        return lengthCheck < length;
    }

    /**
     * Checking if one line is contained within the other.
     *
     * @param other - the line we check the intersection
     * @return - TRUE/FALSE
     */
    public boolean isContainedWithin(Line other) {
        // check if the slopes of the two lines are the same
        if (this.getSlope() == other.getSlope()
                || this.getSlope() == -other.getSlope()) {
            /*
             * check if the endpoints of this line are within the bounds of
             * the other line - the line is fully contained inside the other
             * line
             */
            if ((other.containsPoint(this.start)
                    && other.containsPoint(this.end))
                    || (this.containsPoint(other.start)
                    && this.containsPoint(other.end))) {
                return true;
            }
            // checking the case where the line is half contained
            if ((other.containsPoint(this.start)
                    || other.containsPoint(this.end))
                    || (this.containsPoint(other.start)
                    || this.containsPoint(other.end))) {
                if (this.start.getX() == this.end.getX()
                        && other.start.getY() == other.end.getY()
                        || this.start.getY() == this.end().getY()
                        && other.start.getX() == other.end.getX()) {
                    return false;
                }
                if (!other.start.equals(this.start)
                        && !other.start.equals(this.end)
                        && !other.end.equals(this.start)
                        && !other.end.equals(this.end)
                        && this.isLengthShorter(other)) {
                    return true;
                }
            }
        } else {
            /*
             * the lines have different slopes, so they cannot be fully
             * contained within each other
             */
            return false;
        }
        return false;
    }

    /**
     * Checking if the lines are intersecting.
     *
     * @param other - the line we check the intersection
     * @return - TRUE/FALSE
     */
    public boolean isIntersecting(Line other) {
        // checking if the start or end point are equal
        if (this.equals(other)) {
            return true;
        }
        // if the line is contained within the other
        if (this.isContainedWithin(other)) {
            return true;
        }
        double slope1 = this.getSlope();
        double slope2 = other.getSlope();
        // if one of the lines is horizontal or vertical
        if (slope1 == ZERO_SLOPE || slope2 == ZERO_SLOPE) {
            double b1, b2;
            // both of the lines are horizontal or vertical
            if (slope1 == ZERO_SLOPE && slope2 == ZERO_SLOPE) {
                // the line from the shape of x = ...
                if (this.start.getX() == this.end.getX()) {
                    b1 = this.start.getX();
                    // checking about the other line
                    if (other.start.getX() == other.end.getX()) {
                        b2 = other.start.getX();
                    } else {
                        b2 = other.start.getY();
                    }
                } else {
                    // the line from the shape of y = ...
                    b1 = this.start.getY();
                    // checking about the other line
                    if (other.start.getX() == other.end.getX()) {
                        b2 = other.start.getX();
                    } else {
                        b2 = other.start.getY();
                    }
                }
                // both of the lines have the same x/y values
                if (b1 == b2) {
                    return isInLimits(other, b1, other.start.getY())
                            || isInLimits(other, b1, other.end.getY())
                            || isInLimits(other, b1, other.start.getX())
                            || isInLimits(other, b1, other.end.getX())
                            || this.end.equals(other.start)
                            || other.end.equals(this.start);
                } else {
                    // the lines are different
                    return isInLimits(other, b1, b2);
                }
            }
            // line one has zero slope
            if (slope1 == ZERO_SLOPE) {
                // the line from the shape of x = ...
                if (this.start.getX() == this.end.getX()) {
                    b1 = this.start.getX();
                    // b2 = y - mx
                    b2 = other.start.getY() - slope2 * other.start.getX();
                    double intersectionX = b1;
                    // the y intersection value = mx + b
                    double intersectionY = slope2 * intersectionX + b2;
                    // returning the boolean value from isInLimits function
                    return isInLimits(other, intersectionX, intersectionY);
                } else {
                    // the line from the shape of y = ...
                    b1 = this.start.getY();
                    b2 = other.start.getY() - slope2 * other.start.getX();
                    // the x intersection value is (b2-b1) / (m1-m2)
                    double intersectionX = (b2 - b1) / (slope1 - slope2);
                    double intersectionY = b1;
                    // returning the boolean value from isInLimits function
                    return isInLimits(other, intersectionX, intersectionY);
                }
            } else {
                // line two has zero slope
                if (other.start.getX() == other.end.getX()) {
                    // b1 = y - mx
                    b1 = this.start.getY() - slope1 * this.start.getX();
                    b2 = other.start.getX();
                    double intersectionX = b2;
                    // the y intersection value = mx + b
                    double intersectionY = slope1 * intersectionX + b1;
                    // returning the boolean value from isInLimits function
                    return isInLimits(other, intersectionX, intersectionY);
                } else {
                    b1 = this.start.getY() - slope1 * this.start.getX();
                    b2 = other.start.getY();
                    // the x intersection value is (b2-b1) / (m1-m2)
                    double intersectionX = (b2 - b1) / (slope1 - slope2);
                    double intersectionY = b2;
                    // returning the boolean value from isInLimits function
                    return isInLimits(other, intersectionX, intersectionY);
                }
            }
        } else {
            // both of the lines don't have zero slope
            double b1, b2;
            // b = y-mx for each of the lines
            b1 = this.start.getY() - slope1 * this.start.getX();
            b2 = other.start.getY() - slope2 * other.start.getX();
            // a case where the lines have the same formula of y = mx + b
            if (slope1 == slope2 && b1 == b2) {
                /* checks if one line is not fully contained within the other
                 so, it means they've infinite intersection points */
                if (this.containsPoint(other.start)
                        || this.containsPoint(other.end)) {
                    return true;
                }
            }
            // checks if one's ending point is the other starting point
            if (this.end.equals(other.start)
                    || other.end.equals(this.start)) {
                return true;
            }
            // the x intersection value if (b2-b1) / (m1-m2)
            double intersectionX = (b2 - b1) / (slope1 - slope2);
            // the y intersection value = mx + b
            double intersectionY = slope1 * intersectionX + b1;
            // returning the boolean value from isInLimits function
            return isInLimits(other, intersectionX, intersectionY);
        }
    }

    /**
     * Checking if the lines are intersecting and retuning the intersection
     * point if it happens.
     *
     * @param other - the line we check the intersection
     * @return - the point of the intersection between the line or NULL
     */
    public Point intersectionWith(Line other) {
        boolean flag = this.isIntersecting(other);
        // if (flag == false) then the lines aren't intersecting
        if (!flag) {
            return null;
        } else {
            /*
             * if the lines are equal they've infinite intersection points,
             * therefore it'll return NULL as requested in the assignment
             */
            if (this.equals(other)) {
                return null;
            }
            // calculating the slopes of the lines
            double slope1, slope2;
            slope1 = this.getSlope();
            slope2 = other.getSlope();
            // if one of the lines is horizontal or vertical
            if (slope1 == ZERO_SLOPE || slope2 == ZERO_SLOPE) {
                double b1, b2;
                if (slope1 == ZERO_SLOPE && slope2 == ZERO_SLOPE) {
                    // checking if one line is contained in the other
                    if (this.isContainedWithin(other)) {
                        return null;
                    } else {
                        if (this.start.getX() == this.end.getX()) {
                            // returning the intersection point
                            return new Point(this.start.getX(),
                                    other.start.getY());
                        } else {
                            // returning the intersection point
                            return new Point(other.start.getX(),
                                    this.start.getY());
                        }
                    }
                }
                // line one has zero slope
                if (slope1 == ZERO_SLOPE) {
                    // the line from the shape of x = ...
                    if (this.start.getX() == this.end.getX()) {
                        b1 = this.start.getX();
                        // b = y - mx
                        b2 = other.start.getY() - slope2 * other.start.getX();
                        double intersectionX = b1;
                        // the y intersection value = mx + b
                        double intersectionY = slope2 * intersectionX + b2;
                        // returning the intersection point
                        return new Point(intersectionX, intersectionY);
                    } else {
                        // the line from the shape of y = ...
                        b1 = this.start.getY();
                        b2 = other.start.getY() - slope2 * other.start.getX();
                        // the x intersection value if (b2-b1) / (m1-m2)
                        double
                                intersectionX =
                                (b2 - b1) / (slope1 - slope2);
                        double intersectionY = b1;
                        // returning the intersection point
                        return new Point(intersectionX, intersectionY);
                    }
                } else {
                    if (other.start.getX() == other.end.getX()) {
                        b1 = this.start.getY() - slope1 * this.start.getX();
                        b2 = other.start.getX();
                        double intersectionX = b2;
                        // the y intersection value = mx + b
                        double intersectionY = slope1 * intersectionX + b1;
                        // returning the intersection point
                        return new Point(intersectionX, intersectionY);
                    } else {
                        b1 = this.start.getY() - slope1 * this.start.getX();
                        b2 = other.start.getY();
                        // the x intersection value if (b2-b1) / (m1-m2)
                        double
                                intersectionX =
                                (b2 - b1) / (slope1 - slope2);
                        double intersectionY = b2;
                        // returning the intersection point
                        return new Point(intersectionX, intersectionY);
                    }
                }
            } else {
                // calculating the b in the y=mx+b
                double b1, b2;
                b1 = this.start.getY() - slope1 * this.start.getX();
                b2 = other.start.getY() - slope2 * other.start.getX();
                // a case where the lines have the same formula of y = mx + b
                if (slope1 == slope2 && b1 == b2) {
                    // checks if one's ending point is the other starting point
                    if (this.end.equals(other.start)) {
                        return this.end;
                    }
                    if (other.end.equals(this.start)) {
                        return this.start;
                    }
                    /*
                     * checks if one line is not fully contained within the
                     * other so, it means they've infinite intersection
                     * points
                     */
                    if (this.containsPoint(other.start)
                            || this.containsPoint(other.end)) {
                        return null;
                    }
                }
                // checks if one's ending point is the other starting point
                if (this.end.equals(other.start)) {
                    return this.end;
                }
                if (other.end.equals(this.start)) {
                    return this.start;
                }
                // calculating the x,y values of the intersection.
                double intersectionX = (b2 - b1) / (slope1 - slope2);
                double intersectionY = slope1 * intersectionX + b1;
                // returning the intersection point
                return new Point(intersectionX, intersectionY);
            }
        }
    }

    /**
     * The method checks if the line is intersecting with the rectangle and
     * returns the closest point to the start of the line and null if there's
     * no intersection points.
     *
     * @param rect - the rectangle we check with
     * @return - the closest point to the start of the line/null
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        // making a list of points getting back from intersectionPoint method
        List<Point> points = rect.intersectionPoints(this);
        int minIndex = 0;
        // if the list is empty it means there aren't any intersection points
        if (points.isEmpty()) {
            return null;
        } else {
            for (int i = 0; i < points.size(); i++) {
                // checking which distance to the start of line is smaller
                if (points.get(i).distance(this.start)
                        < points.get(minIndex).distance(this.start)) {
                    minIndex = i;
                }
            }
        }
        // returning the closest intersection point
        return points.get(minIndex);
    }
}
