import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Panel extends JPanel {

    private Paddle p1;
    private Paddle p2;

    public Panel(Paddle p1, Paddle p2){
        super();
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        g.fillRect(p1.getPosX(), p1.getPosY(), p1.getWidth(),p1.getHeight());
        g.fillRect(p2.getPosX(), p2.getPosY(), p2.getWidth(),p2.getHeight());
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
