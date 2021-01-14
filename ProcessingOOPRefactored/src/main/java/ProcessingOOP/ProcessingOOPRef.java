package ProcessingOOP;

import processing.core.PApplet;
import java.util.ArrayList;

public class ProcessingOOPRef extends PApplet {

    public static void main(String args[]) {
        PApplet.main("ProcessingOOP.ProcessingOOPRef", args);
    }

    int WIDTH = 840;
    int HEIGHT = 752;
    int radius = 10;
    int textPosX = 590;
    int textPosY = 590;
    int numberOfBalls = 4;
    int currentPositionOfBall = 0;
    int red = 255;
    int green = 204;
    int blue = 0;
    Ball ball = new Ball(0);
    ArrayList<Ball> balls = new ArrayList<>();


    @Override
    public void settings() {
        size(WIDTH, HEIGHT);
    }

    @Override
    public void setup() {
        int black = 53;
        background(black);
        for (int i = 0; i < numberOfBalls; i++) {
            balls.add(new Ball(currentPositionOfBall));//, isMessageDisplayed));
        }
    }

    @Override
    public void draw() {

        ball.move();
    }

    class Ball{
        private int currentPosition;
        private  final int height[]=new int[]{HEIGHT*1/5,HEIGHT*2/5,HEIGHT*3/5,HEIGHT*4/5};
        private  final int speed[]=new int[]{1,2,3,4};

        public Ball(int currentPosition) {
            this.currentPosition = currentPosition;
        }
        public void move() {
            for (int i = 0; i < balls.size(); i++) {
                Ball ball=balls.get(i);
                ellipse(ball.currentPosition, height[i], radius, radius);
                ball.currentPosition += speed[i];
                checkIfBoundaryIsHit(ball);
            }
        }
        public void checkIfBoundaryIsHit(Ball ball) {
            if (ball.currentPosition + radius > WIDTH) {
                text("I hit a boundary..Redirecting", textPosX, textPosY);
                fill(red,green,blue);
                textSize(20);
                textPosY -= 160;
                textPosX -= 160;
                ball.currentPosition *= -1;
            }
        }

    }
}




