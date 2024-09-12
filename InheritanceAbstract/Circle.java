package InheritanceAbstract;

import java.text.DecimalFormat;
import java.awt.*;


public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        super();
        this.radius = radius;
    }

     public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double circumference() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    // Override the toString() method
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return "Circle, circumference: " + df.format(circumference()) + ", area: " + df.format(area());
    }
    public void draw(Graphics g) {
        g.drawOval(50, 50, (int) (radius * 2), (int) (radius * 2));
        g.setColor(Color.MAGENTA);
        g.fillOval(50, 50, (int) (radius * 2), (int) (radius * 2));
    }

}

