
/*
Pong Clone
----------------
Howard Nock II
Created:
Last Modified:
Status:
 */


double lastTime;
double deltaTime;
double currentTime;
double vel = 50;
double ballVel = 50;

Paddle p1;
Paddle p2;
Ball ball;

void main() {



    GameWindow window = new GameWindow();


    p1 = window.getP1();
    p2 = window.getP2();
    ball = window.getBall();

    System.out.println("Initial: " + p1.getHeight());

    boolean inGame = true;



    lastTime = System.nanoTime();
    while (inGame){

        calculateDeltaTime();
        movePlayer();

        moveBall();



        window.getMainPanel().repaint();


    }


}

private void moveBall() {
    if(isColliding()){
        ballVel *= -1;
    }

    ball.setPosX(ball.getPosX() + (-ballVel * deltaTime));

}

private boolean isColliding() {

    if(ball.getPosX() <= p1.getPosX() + p1.getWidth()){
        if(ball.getPosY() >= p1.getPosY() && ball.getPosY() <= (p1.getPosY() + (float)p1.getHeight())){
            return true;
        }
    }
    return false;


}

private void movePlayer() {
    if (p1.isMovingUp() && p1.getPosY() >= 20){
        p1.setPosY(p1.getPosY() + (-vel * deltaTime));
    }

    if (p1.isMovingDown() && p1.getPosY() <= (530)){
        p1.setPosY(p1.getPosY() + (vel * deltaTime));
    }
}

private void calculateDeltaTime() {
    currentTime = System.nanoTime();
    deltaTime = (currentTime - lastTime) / 1_000_000_000.0;
    lastTime = currentTime;
}
