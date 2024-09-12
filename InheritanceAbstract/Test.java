package InheritanceAbstract;

import java.awt.*;
import java.text.DecimalFormat;

public class Test {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.00");

        Circle circle1 = new Circle (5);
        System.out.println(circle1.toString());


        Rectangle rectangle1 = new Rectangle (11.2, 3.7);
        System.out.println(rectangle1.toString());


    }
}
