import greenfoot.*;
import java.awt.*;

/**
 * Class to keep score of current game session
 * 
 * @author Ashish Narkhede
 * @version 1.0
 */
public class Counter extends Actor
{
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    protected int displayedScore;    //value to display as current score
    protected int currentScore;   //actual score of game
    private String boardprefix;

    public Counter()
    {
        this(new String());
    }

    /**
     * Create a new counter, initialised to 0.
     */
    public Counter(String boardprefix)
    {
        background = getImage();  // get image from class
        displayedScore = 0;
        currentScore = 0;
        this.boardprefix = boardprefix;
        updateScoreBoard();
    }
    
       /**
     * Add a new score to the current counter value.  This will animate
     * the counter over consecutive frames until it reaches the new value.
     */
    public void bumpCount(int score)
    {
        currentScore += score;
    }
    
    public void decrementScore(int score)
    {
        currentScore -= score;
    }

    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (displayedScore < currentScore) 
        {
            displayedScore++;
            updateScoreBoard();
        }
        else if (displayedScore > currentScore)
        {
              displayedScore--;
            updateScoreBoard();
        }
    }
    
    public void updateScoreBoard()
    {
        GreenfootImage boardImage = new GreenfootImage(background);
        GreenfootImage textImage = new GreenfootImage(boardprefix + displayedScore, 15, Color.BLACK, transparent);
        
        if (textImage.getWidth() > boardImage.getWidth() - 20)
        {
            boardImage.scale(textImage.getWidth() + 20, boardImage.getHeight());
        }
        
        boardImage.drawImage(textImage, (boardImage.getWidth()-textImage.getWidth())/2, 
                        (boardImage.getHeight()-textImage.getHeight())/2);
        setImage(boardImage);
    }
    
}
