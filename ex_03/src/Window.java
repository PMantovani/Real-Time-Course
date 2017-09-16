import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class Window extends JFrame implements Runnable {

    public class ComponentsPanel extends JPanel {
        // Circles
        ArrayList<Integer> circleX = new ArrayList<>();
        ArrayList<Integer> circleY = new ArrayList<>();
        ArrayList<Integer> circleRadius = new ArrayList<>();
        // Triangles
        ArrayList<int[]> triangleX = new ArrayList<>();
        ArrayList<int[]> triangleY = new ArrayList<>();
        // Rectangles
        ArrayList<Integer> rectX = new ArrayList<>();
        ArrayList<Integer> rectY = new ArrayList<>();
        ArrayList<Integer> rectWidth = new ArrayList<>();
        ArrayList<Integer> rectHeight = new ArrayList<>();

        public void addCircle(int x, int y, int radius) {
            circleX.add(x);
            circleY.add(y);
            circleRadius.add(radius);
            repaint();
        }

        public void addTriangle(int[] x, int[] y) {
            triangleX.add(x);
            triangleY.add(y);
            repaint();
        }

        public void addRectangle(int x, int y, int width, int height) {
            rectX.add(x);
            rectY.add(y);
            rectWidth.add(width);
            rectHeight.add(height);
            repaint();
        }


        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;

            // Draw circles
            for (int i=0; i<circleX.size(); i++) {
                int radius = circleRadius.get(i);
                g2.drawOval(circleX.get(i), circleY.get(i), radius, radius);
            }

            // Draw triangles
            for (int i=0; i<triangleX.size(); i++) {
                g2.drawPolygon(triangleX.get(i), triangleY.get(i), 3);
            }

            // Draw rectangles
            for (int i=0; i<rectX.size(); i++) {
                g2.drawRect(rectX.get(i), rectY.get(i), rectWidth.get(i), rectHeight.get(i));
            }

        }
    }

    private ComponentsPanel mPanel;

    Window() {
        setSize(new Dimension(1000,1000));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        mPanel = new ComponentsPanel();
        add(mPanel);
    }

    public void addCircle(int x, int y, int radius) {
        mPanel.addCircle(x, y, radius);
    }

    public void addTriangle(int[] x, int[] y) {
        mPanel.addTriangle(x, y);
    }

    public void addRectangle(int x, int y, int width, int height) {
        mPanel.addRectangle(x, y, width, height);
    }

    @Override
    public void run() {
        setVisible(true);
    }
}