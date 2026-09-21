import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameWindow implements KeyListener {
    private CardLayout cardLayout;
    private JPanel container;
    private JFrame frame;
    private JPanel startScreen;
    private Panel mainPanel;
    private Paddle p1;
    private Paddle p2;
    private Ball ball;
    private String currentScreen;
    JButton button = new JButton("Start");

    JLabel label = new JLabel("Pong");




    public GameWindow(){
        this.frame = new JFrame();
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(800, 720);
        this.frame.addKeyListener(this);
        this.frame.setVisible(true);

        this.p1 = new Player(100, 100, 10, 144);
        this.p2 = new Player(690,300,10,144);
        this.ball = new Ball();


        //Panel Management

        this.mainPanel = new Panel(p1,p2, ball);
        mainPanel.setBackground(Color.BLACK);

        this.startScreen = new JPanel();
        startScreen.setBackground(Color.BLACK);
        label.setFont(new Font("Arial", Font.BOLD, 80));
        label.setForeground(Color.WHITE);
        startScreen.add(label);

        button.addActionListener(e -> {
            System.out.println("Button clicked!");
            switchFrame("game");
            setCurrentScreen("game");
        });
        startScreen.add(button);




        this.cardLayout = new CardLayout();
        this.container = new JPanel(cardLayout);
        this.container.add(startScreen, "title");
        this.container.add(mainPanel, "game");

        this.cardLayout = (CardLayout) container.getLayout();
        this.cardLayout.show(container, "title");
        this.currentScreen = "title";

        this.frame.setContentPane(container);



        // ensures Frame will always be displayed
        this.frame.revalidate();
        this.frame.setResizable(false);

    }



    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public Panel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(Panel mainPanel) {
        this.mainPanel = mainPanel;
    }



    @Override
    public void keyTyped(KeyEvent e) {
        logKeys(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }


    @Override
    public void keyReleased(KeyEvent e) {

    }


    public void switchFrame(String frame){
        this.cardLayout.show(container, frame);
        this.currentScreen = frame;

        if(frame.equals("game")){
            this.mainPanel.setFocusable(true);
            this.mainPanel.requestFocusInWindow();

        } else {
            this.startScreen.setFocusable(true);
            this.startScreen.requestFocusInWindow();
        }
    }





    private void logKeys(KeyEvent e) {
        if(e.getKeyChar() == 'w'){
            p1.setMovingUp(true);
            p1.setMovingDown(false);
        }

        if(e.getKeyChar() == 's'){
            p1.setMovingUp(false);
            p1.setMovingDown(true);
        }
    }



    public Paddle getP1() {
        return p1;
    }

    public void setP1(Paddle p1) {
        this.p1 = p1;
    }

    public Paddle getP2() {
        return p2;
    }

    public void setP2(Paddle p2) {
        this.p2 = p2;
    }


    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public void setCardLayout(CardLayout cardLayout) {
        this.cardLayout = cardLayout;
    }

    public JPanel getContainer() {
        return container;
    }

    public void setContainer(JPanel container) {
        this.container = container;
    }

    public JPanel getStartScreen() {
        return startScreen;
    }

    public void setStartScreen(JPanel startScreen) {
        this.startScreen = startScreen;
    }

    public String getCurrentScreen() {
        return currentScreen;
    }

    public void setCurrentScreen(String currentScreen) {
        this.currentScreen = currentScreen;
    }
}
