import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

import java.util.ArrayList;

public class ProcessingOOP extends PApplet{
    public static final int WIDTH = 840;
    public static final int HEIGHT = 752;
    public static final int radius=10;
    public static int textPosX = 590;
    public static int textPosY = 590;
    PFont myFont;
    public static final int Ball1Height=HEIGHT*1/5;
    public static final int Ball2Height=HEIGHT*2/5;
    public static final int Ball3Height=HEIGHT*3/5;
    public static final int Ball4Height=HEIGHT*4/5;
    public static final int speedOfBall1=1;
    public static final int speedOfBall2=2;
    public static final int speedOfBall3=3;
    public static final int speedOfBall4=4;
    int w,x,y,z=0;
    boolean printedMessage=false;


    public static void main(String args[]) {
        PApplet.main("ProcessingOOP", args);
    }
    ArrayList<Balls> balls=new ArrayList<Balls>();
    //String message="Happy New Year 2021";

    @Override
    public void settings() {
        size(WIDTH,HEIGHT);

    }

    @Override
    public void setup() {
        background(255,204,0);
        //myFont=createFont("FFScala",24);
        //textFont(myFont);
        //PImage crackers=loadImage("/Users/anushag/Downloads/crackers.jpeg");
        background(53);
        balls.add(new Balls(HEIGHT*1/5,speedOfBall1,w,printedMessage));
        balls.add(new Balls(HEIGHT*2/5,speedOfBall2,x,printedMessage));
        balls.add(new Balls(HEIGHT*3/5,speedOfBall3,y,printedMessage));
        balls.add(new Balls(HEIGHT*4/5,speedOfBall4,z,printedMessage));


    }

    @Override
    public void draw() {
        makeEachBallMove();
    }

    private void makeEachBallMove() {
        for (int i = 0; i < balls.size(); i++) {
            Balls ball=balls.get(i);
            ellipse(ball.w,ball.HEIGHT,radius,radius);
            ball.w += ball.speedOfBall;
            checkIfBoundaryIsHit(ball);

        }
    }

    private void checkIfBoundaryIsHit(Balls ball) {
        if (ball.w > WIDTH || ball.w + radius > WIDTH) {
            if(ball.printedMessage==false) {
                text("I hit a boundary..Redirecting", textPosX, textPosY);
                fill(255,204,0);
                textSize(20);
                textPosY -= 160;
                textPosX -= 160;
                ball.printedMessage=true;
            }
            ball.w *= -1;
        }
    }

    class Balls{
        int HEIGHT;
        int speedOfBall;
        int w;
        boolean printedMessage;
        //String message;
        public Balls(int HEIGHT,int speedOfBall,int w,boolean printedMessage) {
            this.HEIGHT=HEIGHT;
            this.speedOfBall=speedOfBall;
            this.w=w;
            this.printedMessage=printedMessage;
        }
    }
}
