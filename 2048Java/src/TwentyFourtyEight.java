
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author PéterIvanics
 */
public final class TwentyFourtyEight implements ITwentyFourtyEight
{
    private int boardWidth = 4;
    private int boardHeight = 4;
    /// The 4*4 board containing the current state of the game.
    private int[][] board = new int[boardWidth][boardHeight];
   
    /**
     * Initializes the game with specified board width and height. Both values must be higher than 1.
     * 
     * @param width The width of the board.
     * @param height The height of the board.
     * 
     * @author Péter Ivanics
     * @date 01.02.2016.
     */
    public TwentyFourtyEight(int width, int height)
    {
        if (width > 1 && height > 1)
        {
            this.boardWidth = width;
            this.boardHeight = height;
        }
        
        this.restart();
    }
    
    /**
     * Initializes the game with an existing board. Does not restart the game, loads the present values in the matrix to the game's state.
     * 
     * @param board The board to be loaded to the 2048 game.
     * 
     * @author Péter Ivanics
     * @date 01.02.2016.
     */
    public TwentyFourtyEight(int[][] board)
    {
        this.board = this.deepCopy(board);
        this.boardWidth = board.length;
        this.boardHeight = board[0].length;
    }
    
    /**
     * Initializes a 4*4 board.
     * 
     * @author Péter Ivanics
     * @date 01.02.2016.
     */
    public TwentyFourtyEight()
    {
        this.restart();
    }
    
    /**
     * Swipes the board from bottom to top.
     * 
     * @author Péter Ivanics
     * @date 01.02.2016.
     */
    public void swipeUp()
    {
        for (int i = this.boardHeight - 1; i > 0; i--) 
        {
            for (int j = this.boardWidth - 1; j > -1; j--) 
            {
                if (this.isEmpty(i - 1, j))
                {
                    this.board[i - 1][j] = this.board[i][j];
                    this.board[i][j] = 0;
                }
                else if (this.board[i - 1][j] == this.board[i][j])
                {
                    this.board[i - 1][j] = this.board[i - 1][j] + this.board[i][j];
                    this.board[i][j] = 0;
                }
            }
        }
    }  
    
   /**
     * Swipes the board from top to bottom.
     * 
     * @author Péter Ivanics
     * @date 01.02.2016.
     */
    public void swipeDown()
    {
        for (int i = 0; i < this.boardHeight - 1; i++) 
        {
            for (int j = 0; j < this.boardWidth; j++) 
            {
                if (this.isEmpty(i + 1, j))
                {
                    this.board[i + 1][j] = this.board[i][j];
                    this.board[i][j] = 0;
                }
                else if (this.board[i + 1][j] == this.board[i][j])
                {
                    this.board[i + 1][j] = this.board[i + 1][j] + this.board[i][j];
                    this.board[i][j] = 0;
                }
            }
        }
    }  
    
    /**
     * Swipes the board from right to left.
     * 
     * @author Péter Ivanics
     * @date 02.01.2016.
     */
    public void swipeLeft()
    {
        for (int i = this.boardHeight - 1; i > -1; i--) 
        {
            for (int j = this.boardWidth - 1; j > 0; j--) 
            {
                if (this.isEmpty(i, j - 1))
                {
                    this.board[i][j - 1] = this.board[i][j];
                    this.board[i][j] = 0;
                }
                else if (this.board[i][j - 1] == this.board[i][j])
                {
                    this.board[i][j - 1] = this.board[i][j - 1] + this.board[i][j];
                    this.board[i][j] = 0;
                    j += 2;
                }
            }
        }
    }  
    
    /**
     * Swipes the board from left to right.
     * 
     * @author Péter Ivanics
     * @date 01.02.2016.
     */
    public void swipeRight()
    {
        for (int i = 0; i < this.boardHeight; i++) 
        {
            for (int j = 0; j < this.boardWidth - 1; j++) 
            {
                if (this.isEmpty(i, j + 1))
                {
                    this.board[i][j + 1] = this.board[i][j];
                    this.board[i][j] = 0;
                }
                else if (this.board[i][j + 1] == this.board[i][j])
                {
                    this.board[i][j + 1] = this.board[i][j + 1] + this.board[i][j];
                    this.board[i][j] = 0;
                }
            }
        }
    }            
    
    /**
     * Tells if the game is over. 
     * 
     * @return True, if there are no possible moves left to be performed on the board; false otherwise.
     * 
     * @author Péter Ivanics
     * @date 01.02.2016.
     */
    public boolean isOver()
    {
        if (this.countEmptyCells() == 0)
        {            
            TwentyFourtyEight nextStepUp = new TwentyFourtyEight(board);
            nextStepUp.swipeUp();
            TwentyFourtyEight nextStepDown = new TwentyFourtyEight(board);
            nextStepDown.swipeDown();
            TwentyFourtyEight nextStepLeft = new TwentyFourtyEight(board);
            nextStepLeft.swipeLeft();
            TwentyFourtyEight nextStepRight = new TwentyFourtyEight(board);
            nextStepRight.swipeRight();
            
            int[][] upBoard = nextStepUp.getBoard(), downBoard = nextStepDown.getBoard(), leftBoard = nextStepLeft.getBoard(), rightBoard = nextStepRight.getBoard();
            
            boolean result = true;
            
            result = result && Arrays.deepEquals(upBoard, this.board);
            result = result && Arrays.deepEquals(downBoard, this.board);
            result = result && Arrays.deepEquals(leftBoard, this.board);
            result = result && Arrays.deepEquals(rightBoard, this.board);
            
            return result;
        }
        
        return false;
    }
    
    /**
     * Restarts the game, resets the board to its original state.
     * 
     * @author Péter Ivanics
     * @date 01.02.2016.
     */
    public void restart()
    {
        this.board = new int[this.boardWidth][this.boardHeight];
        
        int x = 0, y = 0, count = 0;
        while (count < 2)
        {
            x = this.getRandomX(); 
            y = this.getRandomY();
            
            if (this.isEmpty(x, y))
            {
                this.board[x][y] = 2;
                count++;
            }
        }
    }
    
    /**
     * Gets the current state of the board.
     * 
     * @return The matrix of the board in its current state.
     * 
     * @author Péter Ivanics
     * @date 01.02.2016.
     */
    @Override
    public int[][] getBoard()
    {
        return this.board;
    }
    
    /******* Private methods *******/    
    /**
     * Gets a random coordinate in the horizontal axis of the board.
     * @return A random number between zero and the board's width. 
     * 
     * @author Péter Ivanics
     * @date 01.02.2016.
     */
    private int getRandomX()
    {
        Random rnd = new Random();
        
        return rnd.nextInt(this.boardWidth);
    }
    
   /**
     * Gets a random coordinate in the vertical axis of the board.
     * @return A random coordinate between zero and the board's height. 
     * 
     * @author Péter Ivanics
     * @date 01.02.2016.
     */
    private int getRandomY()
    {
        Random rnd = new Random();
        
        return rnd.nextInt(this.boardHeight);
    }
    
    /**
     * Tells if the tile on the board at the specified coordinates is empty or not.
     * @param x The x coordinate of the tile.
     * @param y The y coordinate of the tile.
     * @return True if the tile on coordinates (x,y) on the board is empty; false otherwise.
     * 
     * @author Péter Ivanics
     * @date 01.02.2016.
     */
    private boolean isEmpty(int x, int y)
    {
        if (this.board[x][y] == 0)
            return true;
        
        return false;
    }
    
    /**
     * Counts the empty cells on the board.
     * 
     * @return The number of empty cells on the board.
     * 
     * @author Péter Ivanics
     * @date 02.01.2016.
     */
    private int countEmptyCells()
    {
        int count = 0;
        
        for (int i = 0; i < this.boardHeight; i++) 
        {
            for (int j = 0; j < this.boardWidth - 1; j++) 
            {
                if (this.isEmpty(i, j))
                    count++;
            }
        }
         return count;
    }
    
    /**
     * Creates a deep copy of the given array and returns it to the caller.
     * @param input The two dimensional array of integers to be copied. 
     * @return A deep copy of the given array.
     * 
     * @author Peter Ivanics
     * @date 21.02.2016.
     */
    private int[][] deepCopy(int[][] input) {
      int[][] target = new int[input.length][];
      for (int i=0; i <input.length; i++) {
        target[i] = Arrays.copyOf(input[i], input[i].length);
      }
      return target;
}
}
