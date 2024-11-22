// Bar Wanunu 209422435

package Geometry;

/**
 * Velocity class - contains the Velocity constructor and methods.
 */
public class Velocity {

    // Members

    private double dx;
    private double dy;

    // Constructor

    /**
     * Geometry.Velocity constructor.
     *
     * @param dx - the 'x' change in position
     * @param dy - the 'y' change in position
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    // Methods

    /**
     * The method takes a certain point and adds x, y changes to the point.
     *
     * @param p - the point we want to change it location
     * @return - the p point with the added values of dx and dy
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
    }

    /**
     * Getting the dx value form the velocity.
     *
     * @return - the dx value
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * Getting the dy value form the velocity.
     *
     * @return - the dy value
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * The method gets the angle and speed we want the ball to move and
     * using trigonometry calculates the dx, dy values and returns them as
     * new velocity object.
     *
     * @param angle - the angle we want the ball to move on
     * @param speed - the speed of the ball
     * @return - velocity object
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        // convert angle to radians
        double radians = Math.toRadians(angle);
        // calculate dx and dy
        double dx = speed * Math.sin(radians);
        double dy = speed * Math.cos(radians);
        return new Velocity(dx, dy);
    }
}
