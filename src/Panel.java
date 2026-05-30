import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    private Paddle p1;
    private Paddle p2;
    private Ball ball;

    public Panel(Paddle p1, Paddle p2, Ball ball){
        super();
        this.p1 = p1;
        this.p2 = p2;
        this.ball = ball;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        g.fillRect((int)p1.getPosX(), (int)p1.getPosY(), p1.getWidth(),p1.getHeight());
        g.fillRect((int)p2.getPosX(), (int)p2.getPosY(), p2.getWidth(),p2.getHeight());
        g.fillRect((int)ball.getPosX(), (int)ball.getPosY(), ball.getWidth(),ball.getHeight());
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
}
