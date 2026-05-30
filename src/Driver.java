
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

Paddle p1;
Paddle p2;
Ball ball;

void main() {



    GameWindow window = new GameWindow();


    p1 = window.getP1();
    p2 = window.getP2();
    ball = window.getBall();


    boolean inGame = true;



    lastTime = System.nanoTime();
    while (inGame){

        calculateDeltaTime();
        movePlayer();

        moveBall();



        window.getMainPanel().repaint();
        System.out.println(p1.getPosY());
    }


}

private void moveBall() {
    if(!isColliding()){
        ball.setPosX(ball.getPosX() + (-vel * deltaTime));
    }
}

private boolean isColliding() {
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
