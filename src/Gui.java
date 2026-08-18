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

    //initializing all the different gui buttons/panels/menus
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItemNew;
    JPanel buttonpanel;
    JMenuItem menuItemStart;
    JMenuItem menuItemStop;
    JLabel tick;
    JSlider speedSlider;
    JLabel speedLabel;
    JButton startbutton;
    JButton stopbutton;

    public Gui() {
        //confiures window
        setTitle("Conways Game Of Life");
        this.gamePanel = new GamePanel();
        this.add(gamePanel);
        this.getContentPane().setPreferredSize(new Dimension(1200, 800));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // ints the menu bar
        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);


        //adds the menu bar
        menu = new JMenu("Game");
        menuBar.add(menu);
        //adds each part of the menu such as the START and the STOP and the new game and the action listners
        menuItemStart = new JMenuItem("Start");
        menu.add(menuItemStart);
        menuItemStart.addActionListener(this);
        menuItemStop = new JMenuItem("Stop");
        menu.add(menuItemStop);
        menuItemStop.addActionListener(this);
        menuItemNew = new JMenuItem("New Game");
        menu.add(menuItemNew);
        menuItemNew.addActionListener(this);

        //listens for inputs for the gamepanel grid
        gamePanel.addMouseListener(this);

        //builds the start button stop button housing plus slider and tick
        buttonpanel = new JPanel();
        buttonpanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 37));

        //sets background color to gray
        buttonpanel.setBackground(Color.gray);

        //adds start button to the buttonpanel
        startbutton = new JButton("Start");
        startbutton.addActionListener(this);
        buttonpanel.add(startbutton);
        // adds stop button to the buttonpanel in the same way above ^
        stopbutton = new JButton("Stop");
        stopbutton.addActionListener(this);
        buttonpanel.add(stopbutton);





        //adds the tick counter
        tick = new JLabel("Tick;" + gameLogic.tick);
        buttonpanel.add(tick);

        //shows how often it updates each time
        speedLabel = new JLabel(gameLogic.speedms + "ms");


        //speedslider to adjust the speed of the updates
        speedSlider = new JSlider(50, 1000, gameLogic.speedms);
        buttonpanel.add(speedSlider);
            speedSlider.addChangeListener(e -> {
                if (!gameLogic.gamerunning) {
                    gameLogic.speedms = speedSlider.getValue();
                    speedLabel.setText(gameLogic.speedms + "ms");
                }
            });
        buttonpanel.add(speedLabel);

        //creates timer
        Timer uiRefresh = new Timer(gameLogic.speedms, e -> tick.setText("Tick: " + gameLogic.tick));
        uiRefresh.start();
        //adds buttonpanel to the south
        this.add(buttonpanel, BorderLayout.SOUTH);
        this.pack();

        //opens gui to front
        this.toFront();
        this.pack();
        //starts GAMELOGIC
        gameLogic.start(gamePanel);
        this.setVisible(true);
        System.out.println("Gui booted");
    }

    public static void main(String[] args) {
        Gui gui = new Gui();
    }

    @Override
    //actions performed when clicked on certain things i.e start button sends a broadcast out saying Hey START this picks it up and checks the switch case statement
    public void actionPerformed(ActionEvent actionEvent) {
        String cmd = actionEvent.getActionCommand();
        switch (cmd) {
            // start starts the sim
            case "Start":
                gameLogic.start(gamePanel);
                gameLogic.gamerunning = true;
                GamePanel.drawable = false;
                System.out.println("True running");


                break;
                //stop stops the sim
            case "Stop":
                gameLogic.stop();
                gameLogic.gamerunning = false;
                GamePanel.drawable = true;
                System.out.println("False running");


                break;
                // new game clears board and tick
            case "New Game":
                System.out.println("test");
                for(int row = 0; row < GamePanel.rows; row++) {
                    for (int col = 0; col < GamePanel.cols; col++) {
                        GamePanel.gridCells[row][col] = false;
                    }
                }
                // resets tick and clears board
                gameLogic.tick = 0;
                gamePanel.repaint();
            break;
        }
    }

}