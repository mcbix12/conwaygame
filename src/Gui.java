import javax.management.remote.JMXConnectionNotification;
import javax.swing.*;
import java.awt.*;
public class Gui extends JFrame {
JMenuBar menuBar;
JMenu menu;
JMenuItem menuItemNew;
    public Gui() {
    setTitle("Conways Game Of Life");

    this.getContentPane().setPreferredSize(new Dimension(1200,700));
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);


    menuBar = new JMenuBar();
    this.setJMenuBar(menuBar);

    GamePanel gamePanel = new GamePanel();
    this.add(gamePanel);

    menu = new JMenu("Game");
    menuBar.add(menu);

    menuItemNew = new JMenuItem("new game");
    menu.add(menuItemNew);

    this.pack();
    this.toFront();
    this.pack();
    this.setVisible(true);
    System.out.println("Gui booted");
}
public static void main(String[] args) {
        new Gui();
}
}