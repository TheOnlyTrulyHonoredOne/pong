
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

void main() {



    GameWindow window = new GameWindow();


    Paddle p1 = window.getP1();
    Paddle p2 = window.getP2();


    boolean inGame = true;



    lastTime = System.nanoTime();
    while (inGame){

        calculateDeltaTime();
        movePlayer(p1);



        window.getMainPanel().repaint();
        System.out.println(p1.getPosY());
    }


}

private void movePlayer(Paddle p1) {
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
