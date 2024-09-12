package InheritanceAbstract;

public abstract class Shape implements Drawable{
    double x;
    double y;
    String color;

    public Shape() {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Shape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public abstract double circumference();

    public abstract double area();

    // Override the toString() method
    @Override
    public String toString() {
        return "Shape type " + ", circumference: " + circumference() + ", area: " + area();
    }

}
