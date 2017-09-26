import java.util.Random;

public class RandomFigures implements Runnable {
    private String mType;
    private int timeToNext;
    private Random mRnd;
    private Window mWindow;

    RandomFigures(Window mWindow, String type) {
        mType = type;
        mRnd = new Random();
        this.mWindow = mWindow;
    }

    private void randCircle() {
        int circleX = mRnd.nextInt(500);
        int circleY = mRnd.nextInt(500);
        int circleRadius = mRnd.nextInt(500);
        timeToNext = mRnd.nextInt(5000);

        mWindow.addCircle(circleX, circleY, circleRadius);

        try {
            Thread.sleep(timeToNext);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void randTriangle() {
        int[] triangleX = new int[3];
        int[] triangleY = new int[3];

        triangleX[0] = mRnd.nextInt(500);
        triangleX[1] = mRnd.nextInt(500);
        triangleX[2] = mRnd.nextInt(500);
        triangleY[0] = mRnd.nextInt(500);
        triangleY[1] = mRnd.nextInt(500);
        triangleY[2] = mRnd.nextInt(500);
        timeToNext = mRnd.nextInt(5000);

        mWindow.addTriangle(triangleX, triangleY);

        try {
            Thread.sleep(timeToNext);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void randRectangle() {
        int rectangleX = mRnd.nextInt(500);
        int rectangleY = mRnd.nextInt(500);
        int rectangleWidth = mRnd.nextInt(500);
        int rectangleHeight = mRnd.nextInt(500);
        timeToNext = mRnd.nextInt(5000);

        mWindow.addRectangle(rectangleX, rectangleY, rectangleWidth, rectangleHeight);

        try {
            Thread.sleep(timeToNext);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        for (int i=0; i<10; i++) {
            switch (mType) {
                case "circle":
                    randCircle();
                    break;
                case "rectangle":
                    randRectangle();
                    break;
                case "triangle":
                    randTriangle();
                    break;
            }
        }
    }
}
