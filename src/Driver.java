
/*
Pong Clone
----------------
Howard Nock II
Created:
Last Modified:
Status:
 */


import javax.swing.*;

void main() {



    GameWindow window = new GameWindow();


    Paddle p1 = window.getP1();
    Paddle p2 = window.getP2();


    boolean inGame = true;




    FPS.calcBeginTime();
    while (inGame){


        if (p1.isMovingUp()){
            p1.setPosY((int)(p1.getPosY() * 10 * FPS.getDeltaTime()));
        }

        if (p1.isMovingDown()){
            p1.setPosY((int)(p1.getPosY() * -10 * FPS.getDeltaTime()));
        }


        window.getMainPanel().repaint();
        FPS.calcDeltaTime();
        System.out.println(FPS.getDeltaTime());
    }


}
