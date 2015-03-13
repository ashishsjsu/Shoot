import greenfoot.*;

/**
 * Enemy drones approaching towards our fighter
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyDrone extends Movement
{   
    static int lifevalue;
    
    public EnemyDrone()
    {
        this.velocity = 3;
        this.lifevalue = 3;
       //getWorld().addObject(new EnemyMissile(), getX(), getY());
    }
    
    /**
     * Act - do whatever the EnemyDrone wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        this.moveLeft();
        checkEnemyBoundary();
    }
    
    public void takeLife()
    {
        lifevalue--;
        if(lifevalue <= 0)
        {
            //Get hold of counter from world provided we have already saves a refrence of counter in world
            Galaxy world = (Galaxy)getWorld();
            Counter counter = world.getCounter();
            //Increment the score
            counter.bumpCount(5);
            Greenfoot.playSound("Explosion1.mp3");
            getWorld().removeObject(this);
            return;
        }
    }
    
    public void checkEnemyBoundary()
    {
        StarFighter collision = (StarFighter) getOneIntersectingObject(StarFighter.class);
        if(collision != null)
        {   
            Galaxy galaxy_world = (Galaxy)getWorld();
            Counter counter = galaxy_world.getCounter();
            counter.decrementScore(5);
            getWorld().addObject(new Explosion(), getX(), getY());
            Greenfoot.playSound("Explosion1.mp3");
            getWorld().removeObject(this);
            return;
        }
        else if(getX() < 0)
        {
            //System.out.println("drone removed");
            getWorld().removeObject(this);
        }
    }
}
