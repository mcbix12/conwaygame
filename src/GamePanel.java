import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    int cellSize = 20;
    int cols = 60;
    int rows = 35;
    boolean[][] gridCells = new boolean[rows][cols];
    public GamePanel() {
       // gridCells[2][10] = true;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (gridCells[row][col]) {
                    //g.setColor(Color.green);
                    //g.drawRect(col * cellSize, row * cellSize, cellSize, cellSize);
                   // g.fillRect(col * cellSize + 2, row * cellSize + 2, cellSize - 4, cellSize - 4);
                } else {
                    g.setColor(Color.gray);
                    g.drawRect(col * cellSize, row * cellSize, cellSize, cellSize);
                    g.fillRect(col * cellSize + 2, row * cellSize + 2, cellSize - 4, cellSize - 4);



                    }




                }
            }
        }
    }
