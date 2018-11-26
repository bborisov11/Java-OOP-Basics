package classBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setHeight(height);
        this.setWidth(width);
    }

    public double getSurfaceArea() {
        return 2 * this.length * this.width
                + 2 * this.length * this.height
                + 2 * this.width * this.height;
    }

    public double getLateralSurfaceArea() {
        return 2 * this.length * this.height
                + 2 * this.height * this.width;
    }
    public double getVolume() {
        return this.height * this.width * this.length;
    }


    private void setLength(double length) {
        if(length <= 0) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        else {
            this.length = length;
        }
    }

    private void setWidth(double width) {
        if(width <= 0) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        else {
            this.width = width;
        }
    }

    private void setHeight(double height) {
        if(height <= 0) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        else {
            this.height = height;
        }
    }
}
