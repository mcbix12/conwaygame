    import javax.swing.*;
    import java.awt.*;

    public class GamePanel extends JPanel {
        public static boolean running = true;
        int cellSize = 20;
        static int cols = 60;
        static int rows = 35;
        public static int cordsx;
        public static int cordsy;
        public static boolean[][] gridCells = new boolean[rows][cols];
        public static boolean drawable = true;

        public GamePanel() {

        }
        public void setCell(boolean[][] gridCells) {
            if (drawable == true) {
                if (gridCells[cordsy][cordsx] == false) {
                    gridCells[cordsy][cordsx] = true;
                    GamePanel.gridCells = gridCells;
                    repaint();
                } else {
                    gridCells[cordsy][cordsx] = false;
                    GamePanel.gridCells = gridCells;
                    repaint();
                }
            }
        }
        public void paintComponent(Graphics g) {

                super.paintComponent(g);

                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        if (gridCells[row][col]) {
                            g.setColor(Color.black);
                            g.drawRect(col * cellSize, row * cellSize, cellSize, cellSize);
                            g.fillRect(col * cellSize + 2, row * cellSize + 2, cellSize - 4, cellSize - 4);
                        } else {
                            g.setColor(Color.gray);
                            g.drawRect(col * cellSize, row * cellSize, cellSize, cellSize);
                            g.fillRect(col * cellSize + 2, row * cellSize + 2, cellSize - 4, cellSize - 4);


                        }

                    }
                }
            }

        }
