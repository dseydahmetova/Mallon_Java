package InheritanceAbstract;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Dimension;
import java.util.ArrayList;

public class Display {
    private static JPanel canvas;
    private static ArrayList <Drawable> displayItems = new ArrayList<>();


    public static void main(String[] a) {
        initGUI();

        Circle circle1 = new Circle (50);
        Rectangle rectangle1 = new Rectangle (120, 90);
        BankAccount bankAccount = new BankAccount (15627.99, 124578524);


        displayItems.add(bankAccount);
        displayItems.add(circle1);
        displayItems.add(rectangle1);
    }

    private static void drawAllShapes(Graphics g) {
        //TODO: Implement me
        for (Drawable item : displayItems) {
            item.draw(g);
        }
    }

    private static void initGUI() {
        JFrame frame = new JFrame("Shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas = new JPanel() {
            public void paintComponent(Graphics g) {
                drawAllShapes(g);
            }
        };
        canvas.setPreferredSize(new Dimension(500,500));
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }
}
