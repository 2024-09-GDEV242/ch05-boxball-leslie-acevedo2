
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
    // instance variables
    private int xPosition;
    private int yPosition;
    private int diameter;
    private int xSpeed;
    private int ySpeed;
    private Color color;
    private Canvas canvas;
    private int boxWidth;
    private int boxHeight;
    private int boxXmin;
    private int boxYmin;

    /**
     * Constructor for objects of class BoxBall
     */
    public BoxBall(int boxWidth, int boxHeight, int boxXmin, int boxYmin, int diameter, Canvas canvas)
    {
    // initialise instance variables
    this.boxWidth = boxWidth;
    this.boxHeight = boxHeight;
    this.diameter = diameter;
    this.canvas = canvas;
    this.boxYmin = boxYmin;
    this.boxXmin = boxXmin;
        
    // random position within box 
    Random rand = new Random();
    this.xPosition = (int)(Math.random() * ((boxWidth + boxXmin -diameter ) - (boxXmin + diameter) + 1)) + boxXmin + diameter;
    this.yPosition = (int)(Math.random() * ((boxHeight +boxYmin -diameter) - (boxYmin + diameter) + 1)) + boxYmin + diameter;

    // random speed between -7 and +7
    this.xSpeed = getRandomSpeed(rand);
    this.ySpeed = getRandomSpeed(rand);
    
    // assign a random color
    this.color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    
    
    }
    
    //helper method 
    private int getRandomSpeed(Random rand) {
        int speed = rand.nextInt(14) - 7;
        if(speed <= 0){
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
        if(xPosition <= boxXmin + (diameter)|| xPosition >= (boxWidth) + (diameter) ){
            xSpeed = -xSpeed;
        }
        if(yPosition <= boxYmin + (diameter) || yPosition >= (boxHeight) + (diameter)){
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
