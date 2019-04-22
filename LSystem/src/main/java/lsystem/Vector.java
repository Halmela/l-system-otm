/*
 * Help helper class for tracking lines in image
 */

package lsystem;

public class Vector {
    private double startX;
    private double startY;
    private double angle;
    private double length;
    private double width;

    public Vector(double startX, double startY, double angle, double length, double width) {
        this.startX = startX;
        this.startY = startY;
        this.angle = angle;
        this.length = length;
        this.width = width;
    }

    public double getStartX() {
        return startX;
    }

    public double getStartY() {
        return startY;
    }

    public double getAngle() {
        return angle;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }


    public double getEndX() {
        return startX + Math.cos(angle) * length;
    }

    public double getEndY() {
        return startY + Math.sin(angle) * length;
    }


    public void addLength(double length) {
        this.length += length;
    }

    public void addWidth(double width) {
        this.width += width;
    }

    public String toString() {
        return "(" + startX + "," + startY + ") -> (" + getEndX() + ", " + getEndY() + "), " + angle;
    }
}
