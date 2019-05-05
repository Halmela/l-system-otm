/**
 * Help helper class for tracking lines in image
 */

package lsystem.domain;

import java.util.Objects;

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

    public Vector(double startX, double startY, double angle) {
        this.startX = startX;
        this.startY = startY;
        this.angle = angle;
        this.length = 0;
        this.width = 0;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return Double.compare(vector.startX, startX) == 0 &&
                Double.compare(vector.startY, startY) == 0 &&
                Double.compare(vector.angle, angle) == 0 &&
                Double.compare(vector.length, length) == 0 &&
                Double.compare(vector.width, width) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startX, startY, angle, length, width);
    }

    public void setStartX(double startX) {
        this.startX = startX;
    }

    public void setStartY(double startY) {
        this.startY = startY;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
