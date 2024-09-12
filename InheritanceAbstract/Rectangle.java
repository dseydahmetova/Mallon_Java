package InheritanceAbstract;

import java.text.DecimalFormat;
import java.awt.*;

public class Rectangle extends Shape {

    private double width;
    private double height;

    public Rectangle(double width, double height) {
        super();
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
   public double circumference() {
        return 2 * height + 2 * width;
    }

    @Override
    public double area() {
        return height * width;
    }

    // Override the toString() method
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");

        return "Rectangle, perimeter: " + df.format(circumference()) + ", area: " + df.format(area());
    }

    public void draw(Graphics g) {
        g.drawRect(300, 300, (int) width, (int) height); // Draw a rectangle
        g.setColor(Color.PINK);
        g.fillRect(300, 300, (int) width, (int) height );
    }
}
