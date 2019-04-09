/*
 * Help helper class for tracking lines in image
 */

package lsystem;

public class Vector {
    private int startX;
    private int startY;
    private double angle;
    private int length;

    public Vector(int startX, int startY, double angle, int length) {
        this.startX = startX;
        this.startY = startY;
        this.angle = angle;
        this.length = length;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public double getAngle() {
        return angle;
    }

    public int getLength() {
        return length;
    }
}
