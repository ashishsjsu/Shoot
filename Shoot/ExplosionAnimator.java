import greenfoot.*;

/**
 * This class is used to create exlosion animation
 * 
 * @author Ashish Narkhede
 * @version 1.0
 */
public class ExplosionAnimator extends Movement
{
   private GreenfootImage[] images;
    protected int currentImage = 0;
    
    /** 
     * @param basename  The base name of the image files.
     * @param suffix  The suffix of the image files (must include the ".").
     * @param noOfImages  The number of images to be use din the animation.
     */
    public ExplosionAnimator(String basename, String suffix, int noOfImages)
    {
        images = new GreenfootImage[noOfImages];
        for(int i=0; i < noOfImages; i++) {
            images[i] = new GreenfootImage(basename + i + suffix + "gif");
        }
        setImage(images[currentImage]);
    }
    
    /**
     * Act - do whatever this wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        currentImage = (currentImage + 1) % images.length;
        setImage(images[currentImage]);
       
         if(currentImage == 13)
        {
           getWorld().removeObject(this);
        }  
    }   
}
