import javax.swing.Timer;
import javax.swing.*;


public class gameLogic {
    public static int speedms = 200;
    public static boolean gamerunning = false;
    private static Timer timer;

    public static int countcells(boolean[][] grid, int row, int col) {
        int rows = GamePanel.rows;
        int cols = GamePanel.cols;
        int count = 0;
        System.out.println("You are counting");

        return rows;
    }

    public static void start(GamePanel panel) {
        timer = new Timer(speedms,
                actionEvent -> {
                    for (int row = 0; row < GamePanel.rows; row++) {
                        for (int col = 0; col < GamePanel.cols; col++) {


                        }
                    }
                });
    }
}
