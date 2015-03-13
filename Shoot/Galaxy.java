import greenfoot.*;
import java.util.*;

/**
 * The galaxy where fighting takes place
 * 
 * @author Ashish Narkhede 
 * @version 1.0
 */
public class Galaxy extends World
{
    Random rand =  new Random();
    private static int dronecount;
    private Counter counter;
    /**
     * Constructor for objects of class Galaxy.
     * 
     */

    public Galaxy()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        //set world boundry to false to allow background to scroll out of the world
        super(600, 400, 1, false);
        populateGalaxy();

        prepare();
    }

    public void act()
    {
        dronecount++;

        if(dronecount > 130)
        {
            addDrone();
            dronecount = 0;
        }
    }
    
    public Counter getCounter()
    {
        return counter;
    }

    public void addDrone()
    {
        int y = rand.nextInt(getHeight() - 30) + 30;
        addObject(new EnemyDrone(), getWidth()+100, y);
        addObject(new EnemyMissile(), getWidth()+100, y);
    }

    /**
     ** Galaxy to be populated for eachgame start
     */
    public void populateGalaxy()
    {
        addObject(new Playback(), 1600, 255);
        addObject(new Playback(), 3500, 255);
        addObject(new StarFighter(), 99, 205);
        counter = new Counter("Score: ");
        addObject(counter, 532, 32);
        
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
    }
}
