import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    int cellSize = 20;
    int cols = 60;
    int rows = 35;
    boolean[][] gridCells = new boolean[rows][cols];
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (gridCells[row][col]) {
                    g.setColor(Color.black);
                } else {
                    g.fillRect(col * cellSize, row * cellSize, cellSize, cellSize);
                    g.setColor(Color.gray);
                    g.drawRect(col * cellSize, row * cellSize, cellSize, cellSize);


                }
            }
        }
    }
}