    import javax.swing.*;
    import java.awt.*;

    public class GamePanel extends JPanel {
       //the pixel size of cells
        int cellSize = 20;
        //how many colls and rows
        static int cols = 60;
        static int rows = 35;
        //cords of the mouse clicks
        public static int cordsx;
        public static int cordsy;
        //the 2d array of the gridcells each cell is either true or false
        public static boolean[][] gridCells = new boolean[rows][cols];
        //drawable state depending on wether game is on or off
        public static boolean drawable = true;

        public GamePanel() {

        }
        //when click on cell checks if drawable variable true or false if so it will change cell to live
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
        //handles the repaint methods
        public void paintComponent(Graphics g) {

                super.paintComponent(g);
                //handles building the grid + changing the colour
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
