import greenfoot.*;

/**
 * Game background
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Playback extends Movement
{
    /**
     * Playback constructor to intialize variables
    */
    
    public Playback()
    {
        this.velocity = 1;
    }
    
    /**
     * Act - do whatever the Playback wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveLeft();
        repeater();
    }    
 
   public void repeater()
   { 
      if(getX() == -3000)
      {
          setLocation(1600, getY());
      }   
   }
    
}





