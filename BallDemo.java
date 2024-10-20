
/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
import java.awt.Color;

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        myCanvas.setVisible(true);
    }

    /**
     * Method to Simulate multiple bouncing balls
     */
    public void boxBounce(int numBalls)
    {
        if (numBalls <5 || numBalls > 30) {
            System.out.println("Number of balls must be between 5 and 30.");
            return;
        }
        
        // drawing of box 
        myCanvas.setForegroundColor(Color.BLACK);
        int boxWidth = 400;
        int boxHeight = 400; 
        int boxX = 50;
        int boxY = 50;
        
        //top line 
        myCanvas.drawLine(boxX, boxY, boxX + boxWidth, boxY);
        
        //left line 
        myCanvas.drawLine(boxX, boxY, boxX, boxY + boxHeight);
        
        //right line 
        myCanvas.drawLine(boxX + boxWidth, boxY, boxX + boxWidth, boxY + boxHeight);
        
        //bottom line
        myCanvas.drawLine(boxX, boxY + boxHeight, boxX + boxWidth, boxY + boxHeight);
    
        // array to hold the balls 
        BoxBall[] balls= new BoxBall[numBalls];
        
        //initialize balls with random positions and speeds 
        for (int i = 0; i < numBalls; i++) {
            balls[i] = new BoxBall(boxWidth, boxHeight,boxX, boxY,20, myCanvas);

            //ball diameter
            balls[i].draw();
        }
        
        //make balls move 
        
        while(1 == 1){
        myCanvas.wait(50);
           for (BoxBall ball : balls) {
            ball.move();
        } 
        }
        //move all balls 
        
        }
    }