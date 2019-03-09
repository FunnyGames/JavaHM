package utilities;

/**
 * Point class
 * Contains 2 fields - x and y
 * x - the first coordinate
 * y - the second coordinate
 */
public class Point {
    /**
     * Maximum value for x.
     */
    private static double MAX_X = 1_000_000;

    /**
     * Minimum value for x.
     */
    private static double MIN_X = 0;

    /**
     * Maximum value for y.
     */
    private static double MAX_Y = 800;

    /**
     * Minimum value for y.
     */
    private static double MIN_Y  = 0;

    /**
     * First coordinate of the point.
     */
    private double x;

    /**
     * Second coordinate of the point.
     */
    private double y;

    /**
     * Initializes the point with x and y coordinates.
     * @param x first coordinate
     * @param y second coordinate
     */
    public Point(double x, double y) {
        if (x >= MIN_X && x <= MAX_X) {
            this.x = x;
        } else {
            this.x = 0;
        }
        if (y >= MIN_Y && y <= MAX_Y) {
            this.y = y;
        } else {
            this.y = 0;
        }
    }

    /**
     * Copies the coordinates from another point.
     * @param other the point to copy the coordinates from
     */
    public Point(Point other) {
        this(other.x, other.y);
    }

    /**
     * Returns the first coordinate of the point.
     * @return the first coordinate of the point
     */
    public double getX() {
        return x;
    }

    /**
     * Sets the first coordinate of the point.
     * The coordinate should be between 0 to 1,000,000.
     * @param x the value of the first coordinate
     * @return true if in range, false otherwise
     */
    public boolean setX(double x) {
        if (x >= MIN_X && x <= MAX_X) {
            this.x = x;
            return true;
        }
        return false;
    }

    /**
     * Returns the second coordinate of the point.
     * @return the second coordinate of the point
     */
    public double getY() {
        return y;
    }

    /**
     * Sets the second coordinate of the point.
     * The coordinate should be between 0 to 800.
     * @param y the value of the second coordinate
     * @return true if in range, false otherwise
     */
    public boolean setY(double y) {
        if (y >= MIN_Y && y <= MAX_Y) {
            this.y = y;
            return true;
        }
        return false;
    }

    /**
     * Returns the string in format as (x,y).
     * Where x is the first coordinate and y is the second.
     * @return string in format as (x,y)
     */
    @Override
    public String toString() {
        return "(" + getX() + "," +getY() + ")";
    }
}
