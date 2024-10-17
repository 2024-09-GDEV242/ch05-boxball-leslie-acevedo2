import java.awt.Color;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
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
        myCanvas.setVisible(true);
        myCanvas.setForegroundColor(Color.BLACK);
        
        //top line 
        myCanvas.drawLine(50, 50, 550, 50);
        
        //left line 
        myCanvas.drawLine(50, 50, 50, 450);
        
        //right line 
        myCanvas.drawLine(550, 50, 550, 450);
        
        //bottom line
        myCanvas.drawLine(50, 450, 550, 450);
        
        // width of box 
        int boxWidth = 500;
        
        //height of box 
        int boxHeight = 400;

        // array to hold the balls 
        BoxBall[] balls= new BoxBall[numBalls];
        
        //initialize balls with random positions and speeds 
        for (int i = 0; i < numBalls; i++) {
            balls[i] = new BoxBall(boxWidth, boxHeight, 20, myCanvas);
            
            //ball diameter
            balls[i].draw();
        }
        
        //make balls move 
        boolean finished = false;
        while (!finished) {
            myCanvas.wait(50);
        }
        
        //move all balls 
        for (BoxBall ball : balls) {
            ball.move();
        }
        }
    }