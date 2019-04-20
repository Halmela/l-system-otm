/*
 * Help helper class for tracking lines in image
 */

package lsystem;

public class Vector {
    private double startX;
    private double startY;
    private double angle;
    private int length;
    private int width;

    public Vector(double startX, double startY, double angle, int length, int width) {
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

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }


    public double getEndX() {
        return startX + Math.cos(angle) * length;
    }

    public double getEndY() {
        return startY + Math.sin(angle) * length;
    }


    public void addLength(int length) {
        this.length += length;
    }

    public void addWidth(int width) {
        this.width += width;
    }

    public String toString() {
        return "(" + startX +","+ startY +") -> ("+ getEndX() +", "+ getEndY()+"), "+ angle;
    }
}
