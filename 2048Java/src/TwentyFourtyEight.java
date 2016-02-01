/**
 *
 * @author PéterIvanics
 */
public class TwentyFourtyEight implements ITwentyFourtyEight
{
    /// The board containing the current state of the game.
    private int[][] board;
    
    /**
     * Swipes the board from bottom to top.
     * 
     * @author Péter Ivanics
     * @date 01.01.2016.
     */
    public void swipeUp()
    {
    }  
    
   /**
     * Swipes the board from top to bottom.
     * 
     * @author Péter Ivanics
     * @date 01.01.2016.
     */
    public void swipeDown()
    {
    }  
    
    /**
     * Swipes the board from right to left.
     * 
     * @author Péter Ivanics
     * @date 01.01.2016.
     */
    public void swipeLeft()
    {
    }  
    
    /**
     * Swipes the board from left to right.
     * 
     * @author Péter Ivanics
     * @date 01.01.2016.
     */
    public void swipeRight()
    {
    }            
    
    /**
     * Tells if the game is over. 
     * 
     * @return True, if there are no possible moves left to be performed on the board; false otherwise.
     * 
     * @author Péter Ivanics
     * @date 01.01.2016.
     */
    public boolean isOver()
    {
        return false;
    }
    
    /**
     * Restarts the game, resets the board to its original state.
     * 
     * @author Péter Ivanics
     * @date 01.01.2016.
     */
    public void restart()
    {
    
    }
    
    /**
     * Gets the current state of the board.
     * 
     * @return The matrix of the board in its current state.
     * 
     * @author Péter Ivanics
     * @date 01.01.2016.
     */
    public int[][] getBoard()
    {
        return this.board;
    }
}
