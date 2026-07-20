import javax.management.remote.JMXConnectionNotification;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Gui extends JFrame implements ActionListener, MouseListener {
    public void mouseClicked(MouseEvent e) {
        if (GamePanel.drawable == true) {
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
        } else if(GamePanel.drawable == false) {
            System.out.println("Draw false");

        }
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
    JPanel buttonpanel;
    JMenuItem menuItemStart;
    JMenuItem menuItemStop;
    JButton drawbutton;

    public Gui() {
        setTitle("Conways Game Of Life");
        this.gamePanel = new GamePanel();
        this.add(gamePanel);
        this.getContentPane().setPreferredSize(new Dimension(1200, 800));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);



        menu = new JMenu("Game");
        menuBar.add(menu);

        menuItemStart = new JMenuItem("Start");
        menu.add(menuItemStart);
        menuItemStart.addActionListener(this);
        menuItemStop = new JMenuItem("Stop");
        menu.add(menuItemStop);
        menuItemStop.addActionListener(this);
        menuItemNew = new JMenuItem("New Game");
        menu.add(menuItemNew);
        menuItemNew.addActionListener(this);

        gamePanel.addMouseListener(this);

        buttonpanel = new JPanel();
        buttonpanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 37));


        buttonpanel.setBackground(Color.gray);

        drawbutton = new JButton("Draw");
        drawbutton.addActionListener(this);
        buttonpanel.add(drawbutton);

        this.add(buttonpanel, BorderLayout.SOUTH);
        this.pack();
        this.toFront();
        this.pack();
        gameLogic.start(gamePanel);
        this.setVisible(true);
        System.out.println("Gui booted");
    }

    public static void main(String[] args) {
        Gui gui = new Gui();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String cmd = actionEvent.getActionCommand();
        switch (cmd) {
            case "Draw":
                if (GamePanel.drawable == true) {
                    GamePanel.drawable = false;
                    System.out.println("Draw false");
                } else if (GamePanel.drawable == false) {
                    GamePanel.drawable = true;
                    System.out.println("Draw true");
                }
                break;
            case "Start":
                gameLogic.gamerunning = true;
                GamePanel.drawable = false;
                System.out.println("True running");
                break;
            case "Stop":
                gameLogic.gamerunning = false;
                GamePanel.drawable = true;
                System.out.println("False running");
                break;
            case "New Game":
                System.out.println("test");
            break;
        }
    }

}