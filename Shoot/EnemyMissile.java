import greenfoot.*;

/**
 * This is Enemy fire weapon
 * 
 * @author Ashish Narkhede 
 * @version 1.0
 */
public class EnemyMissile extends Movement
{
    public EnemyMissile()
    {
        this.velocity = 5;
    }
    
    /**
     * Act - do whatever the EnemyMissile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       this.moveLeft();
       checkEnemyMissileBoundaries();
    }    
    
    public void checkEnemyMissileBoundaries()
    {
        StarFighter collision = (StarFighter)getOneIntersectingObject(StarFighter.class);
        if(collision != null)
        {
            getWorld().addObject(new Explosion(), getX(), getY());
            Galaxy galWorld = (Galaxy)getWorld();
            Counter counter = galWorld.getCounter();
            counter.decrementScore(2);
            getWorld().removeObject(this);
            return;
        }
        
        else if(getX() <= 0)
        {
           // System.out.println("removed");
            getWorld().removeObject(this);
        }
    }
}
