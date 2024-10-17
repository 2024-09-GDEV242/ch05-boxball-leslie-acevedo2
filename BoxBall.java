
/**
 * Write a description of class BoxBall here.
 *
 * @author (Leslie Acevedo)
 * @version (10.16.2024)
 */
import java.awt.Color;
import java.util.Random;

public class BoxBall
{
    // instance variables - replaced with my own 
    private int xPosition;
    private int yPosition;
    private int diameter;
    private Color color;
    private int xSpeed;
    private int ySpeed;
    private Canvas canvas;
    private int boxWidth;
    private int boxHeight;

    /**
     * Constructor for objects of class BoxBall
     */
    public BoxBall(int boxWidth, int boxHeight, int diameter, Canvas canvas)
    {
    // initialise instance variables
    Random rand = new Random();
    this.boxWidth = boxWidth;
    this.boxHeight = boxHeight;
    this.diameter = diameter;
    this.canvas = canvas;
        
    // random position within box 
    this.xPosition = rand.nextInt(boxWidth - diameter);
    this.yPosition = rand.nextInt(boxHeight - diameter);
    
    // random speed between -7 and +7
    this.xSpeed = getRandomSpeed(rand);
    this.ySpeed = getRandomSpeed(rand);
    
    // assign a random color
    this.color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    
    }
    
    //helper method 
    private int getRandomSpeed(Random rand) {
        int speed = rand.nextInt(14) - 7;
        while (speed ==0) {
            speed = rand.nextInt(14) - 7;
        }
        return speed;
    }
    
    //method to move the ball 
    public void move() {
        //erase ball at current position 
        erase();
        
        // update position
        xPosition += xSpeed;
        yPosition += ySpeed;
        
        // bounce off the left and right walls 
        if (xPosition <= 0 || xPosition >= (boxWidth - diameter)) {
            xSpeed = -xSpeed;
        }
        
        if(xPosition >= (boxWidth - diameter)) {
            xPosition = boxWidth - diameter;
            xSpeed = -xSpeed;
        }
        
        // bounce off the top and bottom walls 
        if (yPosition <= 0 || yPosition >= (boxHeight - diameter)) {
            ySpeed = -ySpeed;
        }
        
        if (yPosition >= (boxHeight - diameter)) {
            yPosition = boxHeight - diameter;
            ySpeed = -ySpeed;
        }
        
        // draw the ball at its new position 
        draw();
    }
    
    // draw ball on canvas 
    public void draw() {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }
    
     // method to erase the ball 
    public void erase() {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }
}
