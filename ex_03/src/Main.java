public class Main {
    public static void main(String args[])
    {
        Window window = new Window();

        RandomFigures rCircle = new RandomFigures(window, "circle");
        RandomFigures rTriangle = new RandomFigures(window, "triangle");
        RandomFigures rRectangle = new RandomFigures(window, "rectangle");

        Thread windowThread = new Thread(window);
        Thread circlesThread = new Thread(rCircle);
        Thread triangleThread = new Thread(rTriangle);
        Thread rectangleThread = new Thread(rRectangle);

        windowThread.start();
        circlesThread.start();
        triangleThread.start();
        rectangleThread.start();

    }
}