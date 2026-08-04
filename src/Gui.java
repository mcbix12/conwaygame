import javax.management.remote.JMXConnectionNotification;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// main GUI setup
public class Gui extends JFrame implements ActionListener, MouseListener {
    //handles input so if mouse clicked it takes the cords and divdes it by 20 and gets the location
    public void mouseClicked(MouseEvent e) {
        //checks if drawable state is true before drawing
        if (GamePanel.drawable == true) {

            //debug message
            System.out.println("click!");
            //grabs x and y values
            System.out.println(e.getX());
            System.out.println(e.getY());
            //divides x and y valaues by 20 which s the size of the sqaures
            int mousecordsy = e.getY() / 20;
            int mousecordsx = e.getX() / 20;
            //debug messages
            System.out.println("math done");
            System.out.println(mousecordsy);
            System.out.println(mousecordsx);

            //sets mousecord to the new celll from the math in the lines above
            GamePanel.cordsx = mousecordsx;
            GamePanel.cordsy = mousecordsy;
            gamePanel.setCell(gamePanel.gridCells);
            //stops people from drawing when draw = false
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
    JLabel drawstatus;
    JLabel tick;
    JSlider speedSlider;
    JLabel speedLabel;


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

        drawstatus = new JLabel(GamePanel.drawable ? "On" : "off");
        buttonpanel.add(drawstatus);

        tick = new JLabel("Tick;" + gameLogic.tick);
        buttonpanel.add(tick);

        speedLabel = new JLabel(gameLogic.speedms + "ms");

        speedSlider = new JSlider(50, 1000, gameLogic.speedms);
        buttonpanel.add(speedSlider);
            speedSlider.addChangeListener(e -> {
                if (!gameLogic.gamerunning) {
                    gameLogic.speedms = speedSlider.getValue();
                    speedLabel.setText(gameLogic.speedms + "ms");
                }
            });
        buttonpanel.add(speedLabel);

        Timer uiRefresh = new Timer(100, e -> tick.setText("Tick: " + gameLogic.tick));
        uiRefresh.start();

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
                drawstatus.setText(GamePanel.drawable ? "On" : "Off");
                break;
            case "Start":
                gameLogic.start(gamePanel);
                gameLogic.gamerunning = true;
                GamePanel.drawable = false;
                System.out.println("True running");
                drawstatus.setText(GamePanel.drawable ? "On" : "Off");

                break;
            case "Stop":
                gameLogic.stop();
                gameLogic.gamerunning = false;
                GamePanel.drawable = true;
                System.out.println("False running");
                drawstatus.setText(GamePanel.drawable ? "On" : "Off");

                break;
            case "New Game":
                System.out.println("test");
                for(int row = 0; row < GamePanel.rows; row++) {
                    for (int col = 0; col < GamePanel.cols; col++) {
                        GamePanel.gridCells[row][col] = false;
                    }
                }
                gameLogic.tick = 0;
                gamePanel.repaint();
            break;
        }
    }

}