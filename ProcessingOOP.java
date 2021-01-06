import processing.core.PApplet;
import java.util.ArrayList;

public class ProcessingOOPRef extends PApplet {

    public static void main(String args[]){
        PApplet.main("ProcessingOOPRef",args);
    }
    int WIDTH = 840;
    int HEIGHT = 752;
    int radius=10;
    int textPosX = 590;
    int textPosY = 590;
    int numberOfBalls=4;
    int ballHeight[]=new int[]{HEIGHT*1/5,HEIGHT*2/5,HEIGHT*3/5,HEIGHT*4/5};
    int speedOfBall[]=new int[]{1,2,3,4};
    int currentPositionOfBall=0;
    boolean isMessageDisplayed=false;
    int red = 255;
    int green = 204;
    int blue = 0;
    int framePosToBeReduced=160;
    ArrayList<Balls> balls=new ArrayList<Balls>();


    @Override
    public void settings() {
        size(WIDTH, HEIGHT);
    }

    @Override
    public void setup() {
        int black = 53;
        background(black);
        for(int i=0;i<numberOfBalls;i++) {
            balls.add(new Balls(currentPositionOfBall, isMessageDisplayed));
        }
    }

    @Override
    public void draw() {
        makeEachBallMove();
    }

    private void makeEachBallMove() {
        for (int i = 0; i < balls.size(); i++) {
            Balls ball=balls.get(i);
            ellipse(ball.currentPositionOfBall,ballHeight[i], radius, radius);
            ball.currentPositionOfBall += speedOfBall[i];
            checkIfBoundaryIsHit(ball);
        }
    }

    private void checkIfBoundaryIsHit(Balls ball) {
        if (ball.currentPositionOfBall + radius > WIDTH) {
            if(ball.IsMessageDisplayed == false) {
                text("I hit a boundary..Redirecting", textPosX, textPosY);
                fill(red,green,blue);
                textSize(20);
                textPosY -= framePosToBeReduced;
                textPosX -= framePosToBeReduced
                ball.IsMessageDisplayed = true;
            }
            ball.currentPositionOfBall *= -1;
        }
    }

    class Balls{
        int currentPositionOfBall;
        boolean IsMessageDisplayed;
        public Balls(int currentPositionOfBall,boolean printedMessage) {
            this.currentPositionOfBall=currentPositionOfBall;
            this.IsMessageDisplayed=printedMessage;
        }

    }
}



