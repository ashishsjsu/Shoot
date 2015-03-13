import greenfoot.*;

/**
 * Generic movement class for controlling object movements in the game
 * 
 * @author Ashish Narkhede
 * @version 1.0
 */
public class Movement extends Actor
{
    protected int velocity = 0;
    
    protected void moveRight()
    {
        setLocation(getX()+ velocity, getY());
    }
    
    protected void moveLeft()
    {
        setLocation(getX() - velocity, getY());
    }
    
    protected void moveDown()
    {
         setLocation(getX(), getY() + velocity);
    }
    
    protected void moveUp()
    {
         setLocation(getX(), getY() - velocity);
    }
    
}
