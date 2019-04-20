/*
 * Help helper class for tracking lines in image
 */

package lsystem;

public class Vector {
    private double startX;
    private double startY;
    private double angle;
    private int length;

    public Vector(double startX, double startY, double angle, int length) {
        this.startX = startX;
        this.startY = startY;
        this.angle = angle;
        this.length = length;
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

    public int getLength() {
        return length;
    }

    public double getEndX() {
        return startX + Math.cos(angle) * length;
    }

    public double getEndY() {
        return startY + Math.sin(angle) * length;
    }

    public String toString() {
        return "(" + startX +","+ startY +") -> ("+ getEndX() +", "+ getEndY()+"), "+ angle;
    }
}
