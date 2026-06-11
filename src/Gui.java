import javax.management.remote.JMXConnectionNotification;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;
import java.awt.event.*;
public class Gui extends JFrame implements ActionListener, MouseListener {
public void mouseClicked(MouseEvent e) {
    System.out.println("click!");
    System.out.println(e.getX());
    System.out.println(e.getY());
    int mousecordsy = e.getY() / 20;
    int mousecordsx = e.getX() / 20;
    System.out.println("math done");
    System.out.println(mousecordsy);
    System.out.println(mousecordsx);
    GamePanel.cordsx = mousecordsx;
    GamePanel.cordsy = mousecordsy;
    gamePanel.setCell(gamePanel.gridCells);

}

    @Override
    public void mousePressed(MouseEvent e) {



    }
    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }
    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
    }
    @Override
    public void mouseExited(MouseEvent mouseEvent) {
    }

    public GamePanel gamePanel;


JMenuBar menuBar;
JMenu menu;
JMenuItem menuItemNew;
    public Gui() {
    setTitle("Conways Game Of Life");
    this.gamePanel = new GamePanel();
    this.add(gamePanel);
    this.getContentPane().setPreferredSize(new Dimension(1200,700));
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);


    menuBar = new JMenuBar();
    this.setJMenuBar(menuBar);

    this.add(gamePanel);

    menu = new JMenu("Game");
    menuBar.add(menu);

    menuItemNew = new JMenuItem("New Game");
    menu.add(menuItemNew);
    menuItemNew.addActionListener(this);

    gamePanel.addMouseListener(this);

    this.pack();
    this.toFront();
    this.pack();
    this.setVisible(true);
    System.out.println("Gui booted");
}
    public static void main(String[] args) {
        Gui gui = new Gui();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("newgame");

    }
}