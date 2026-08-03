import javax.swing.Timer;
import javax.swing.*;


public class gameLogic {
    public static int speedms = 200;
    public static boolean gamerunning = false;
    private static Timer timer;

    public static void start(GamePanel panel) {
        if (timer != null) return;
        timer = new Timer(speedms, actionEvent -> {
            if (gamerunning) {
                step(panel);
            }
        });
        timer.start();
    }

    public static void  step(GamePanel panel) {
        boolean[][] grid = GamePanel.gridCells;
        int rows = GamePanel.rows;
        int cols = GamePanel.cols;
        boolean[][] next = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int neighbours = countcells(grid, row, col);
                if (grid[row][col]) {
                    next[row][col] = (neighbours == 2 || neighbours == 3);
                    } else {
                    next[row][col] = neighbours == 3;
                }


                }

            }
        GamePanel.gridCells = next;
        panel.repaint();

        }



    public static int countcells(boolean[][] grid, int row, int col) {
        int rows = GamePanel.rows;
        int cols = GamePanel.cols;
        int count = 0;
        System.out.println("You are counting");

        for (int dr = -1; dr <= 1; dr++) {
            for (int dc =  -1; dc <= 1; dc++ ) {
                if (dr == 0 && dc == 0) continue;
                int r = row + dr;
                int c = col + dc;
                if (r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c]) {
                    count++;
            }
        }
    }
        return count;

}
}