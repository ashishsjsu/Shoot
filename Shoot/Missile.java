import greenfoot.*;

/**
 * A missile to fire from our galaga
 * 
 * @author Ashish Narkhede
 * @version 1.0
 */
public class Missile extends Movement
{
    public Missile()
    {
        this.velocity = 6;
    }
    
    /**
     * Act - do whatever the Missile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        this.moveRight();
        checkMissileBoundaries();
    }    
    
    public void checkMissileBoundaries()
    {
        EnemyDrone collision = (EnemyDrone)getOneIntersectingObject(EnemyDrone.class);
        if(collision != null)
        {
            getWorld().addObject(new Explosion(), getX(), getY());
            collision.takeLife();
            getWorld().removeObject(this);
            return;
        }
        
        if(getX() >= getWorld().getWidth())
        {
           // System.out.println("removed");
            getWorld().removeObject(this);
        }
    }
}
