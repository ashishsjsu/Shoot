import greenfoot.*;

/**
 * Our fighter in Galaxy
 * 
 * @author Ashish Narkhede
 * @version 1.0
 */
public class StarFighter extends Movement
{
    
    private int firedelay;
    
    /**  the StarFighter constructor     */
    public StarFighter()
    {
        this.velocity = 2;
    }
  
    /**
     * Act - do whatever the StarFighter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        actOnKeys();
        checkBoundaries();
        firedelay ++;
    } 
    
    public void checkBoundaries()
    {
       if(getX() <= 58)
       { 
           setLocation(58, getY()); 
       }
       if(getX() >= 426)
       {
           setLocation(426, getY());
       }
       if(getY() <= 46)
       {
           setLocation(getX(), 46);
       }       
       if(getY() >= 348)
       {
           setLocation(getX(),348);
       }
       
    }
    
    /**
     * Check if control key on keyboard is pressed and act accordingly
     */
    public void actOnKeys()
    {         
        if(Greenfoot.isKeyDown("right"))
        {  
          moveRight();                  
        }
        
        if(Greenfoot.isKeyDown("left"))
        {
            moveLeft();
        }
        
        if(Greenfoot.isKeyDown("down"))
        {
           moveDown();
        }
        
        if(Greenfoot.isKeyDown("up"))
        {
           moveUp();
        }
        
        if(Greenfoot.mouseClicked(null) || Greenfoot.isKeyDown("space"))
        {
          if(firedelay > 10)
          {
              firedelay = 0;
              getWorld().addObject(new Missile(), getX(), getY());
              getWorld().addObject(new Missile(), getX(), getY() + 25);
              getWorld().addObject(new Missile(), getX(), getY() - 25);

          }
        }
    }
}
