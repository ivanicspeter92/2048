/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Contains and implements test cases for the 2048 game.
 * 
 * @author Péter Ivanics
 * @date 01.02.2016.
 */
public class TwentyFourtyEightTests 
{
    /// The test 2048 object to be used in the test cases.
    private TwentyFourtyEight game;
    
    @Before
    public void setUp() 
    {
        this.game = new TwentyFourtyEight();
    }
    
    /**
     * Tests if a newly created board contains exactly two tiles of twos.
     * 
     * @author Péter Ivanics
     * @date 01.02.2016.
     */
    @Test
    public void testEmptyBoardContainsTwoTwos()
    {
        assertTrue(this.contains(this.game.getBoard(), 2));
        assertEquals(this.count(this.game.getBoard(), 2), 2);
    }
    
    /**
     * Tests if a newly initialized game is not over.
     * 
     * @author Péter Ivanics
     * @date 01.02.2016.
     */
    @Test
    public void testIfEmptyGameIsNotOver()
    {
        assertFalse(this.game.isOver());
    }
    
    /**
     * Tests that the game is over with a full list when there are no possible moves left.
     * 
     * @author Peter Ivanics
     * @date 02.02.2016.
     */
    @Test
    public void testIfFullBoardGameIsOver()
    {
        int[][] testBoard = {
            {2, 4, 8, 2},
            {8, 2, 4, 8},
            {2, 4, 16, 2},
            {4, 8, 2, 4}
        };
        
        this.game = new TwentyFourtyEight(testBoard);
        assertTrue(this.game.isOver());
    }
    
    /**
     * Tests that the game is not over with a full list when there is at least one possible move left.
     * 
     * @author Peter Ivanics
     * @date 02.02.2016.
     */
    @Test
    public void testIfFullBoardWithMovesGameIsNotOver()
    {
        int[][] testBoard = {
            {2, 8, 8, 2}, // the eights should be possible to combine in the first row
            {8, 2, 4, 8},
            {2, 4, 16, 2},
            {4, 8, 2, 4}
        };
        
        this.game = new TwentyFourtyEight(testBoard);
        assertFalse(this.game.isOver());
    }
    
    /**
     * Tests combining two neighboring values on a full board.
     * 
     * @author Peter Ivanics
     * @date 21.02.2016.
     */
    @Test
    public void testCombiningTwoValuesOnFullBoard()
    {
        int[][] testBoard = {
            {2, 8, 8, 2}, // the eights should be possible to combine in the first row
            {8, 2, 4, 8},
            {2, 4, 16, 2},
            {4, 8, 2, 4}
        };
        
        this.game = new TwentyFourtyEight(testBoard);
        this.game.swipeLeft();
        
        int[][] expectedBoard = {
            {2, 16, 2, 0},
            {8, 2, 4, 8},
            {2, 4, 16, 2},
            {4, 8, 2, 4}
        };
        
        System.out.println("Expected:");
        this.print(expectedBoard);
        
        System.out.println("Actual");
        this.print(this.game.getBoard());
        assertArrayEquals(expectedBoard, this.game.getBoard());
    }
    
     /************** Simple swipe without collision ***********/   
    /**
     * Tests swiping a simple board from top to bottom. The board contains two twos only and no collision is made with the swipe.
     */
    @Test
    public void testSimpleSwipeUpNoCollision()
    {
        int[][] originalBoard = {
            {0, 0, 0, 2},
            {0, 2, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };
//        System.out.println("Original:");
//        this.print(originalBoard);
        
        this.game = new TwentyFourtyEight(originalBoard);
        this.game.swipeUp();
        
        int[][] expectedBoard = {
            {0, 2, 0, 2},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };
//        System.out.println("Expected:");
//        this.print(expectedBoard);
        
//        System.out.println("Actual");
//        this.print(this.game.getBoard());
        assertArrayEquals(expectedBoard, this.game.getBoard());
        /*************************/
        originalBoard = new int[][] {
            {2, 0, 0, 0},
            {0, 2, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };
//        System.out.println("Original:");
//        this.print(originalBoard);
        
        this.game = new TwentyFourtyEight(originalBoard);
        this.game.swipeUp();
        
        expectedBoard = new int[][] {
            {2, 2, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };
//        System.out.println("Expected:");
//        this.print(expectedBoard);
        
//        System.out.println("Actual");
//        this.print(this.game.getBoard());
        assertArrayEquals(expectedBoard, this.game.getBoard());
    }
    
     /**
     * Tests swiping a simple board from bottom to top. The board contains two twos only and no collision is made with the swipe.
     */
    @Test
    public void testSimpleSwipeDownNoCollision()
    {
        int[][] originalBoard = {
            {0, 0, 0, 2},
            {0, 2, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };
        
        this.game = new TwentyFourtyEight(originalBoard);
        this.game.swipeDown();
        
        int[][] expectedBoard = {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 2, 0, 2}
        };
        
        assertArrayEquals(expectedBoard, this.game.getBoard());
    }
    
    /**
     * Tests swiping a simple board from left to right. The board contains two twos only and no collision is made with the swipe.
     */
    @Test
    public void testSimpleSwipeRightNoCollision()
    {
        int[][] originalBoard = {
            {0, 0, 0, 2},
            {0, 2, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };
        
        this.game = new TwentyFourtyEight(originalBoard);
        this.game.swipeRight();
        
        int[][] expectedBoard = {
            {0, 0, 0, 2},
            {0, 0, 0, 2},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };
        
        assertArrayEquals(expectedBoard, this.game.getBoard());
    }
    
    /**
     * Tests swiping a simple board from right to left. The board contains two twos only and no collision is made with the swipe.
     */
    @Test
    public void testSimpleSwipeLeftNoCollision()
    {
        int[][] originalBoard = {
            {0, 0, 0, 2},
            {0, 2, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };
        
        this.game = new TwentyFourtyEight(originalBoard);
        this.game.swipeLeft();
        
        int[][] expectedBoard = {
            {2, 0, 0, 0},
            {2, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };
        
        assertArrayEquals(expectedBoard, this.game.getBoard());
    }
    
    /************** Simple swipe with collision ***********/    
     /**
     * Tests swiping a simple board from bottom to top. The board contains two twos only which collide during the swipe.
     */
    @Test
    public void testSimpleSwipeUpWithCollision()
    {
        int[][] originalBoard = {
            {2, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {2, 0, 0, 0}
        };
        
        this.game = new TwentyFourtyEight(originalBoard);
        this.game.swipeUp();
        
        int[][] expectedBoard = {
            {4, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };
        
        assertArrayEquals(expectedBoard, this.game.getBoard());
    }
    
     /**
     * Tests swiping a simple board from top to bottom. The board contains two twos only which collide during the swipe.
     */
    @Test
    public void testSimpleSwipeDownWithCollision()
    {
        int[][] originalBoard = {
            {0, 0, 0, 2},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 2}
        };
        
        this.game = new TwentyFourtyEight(originalBoard);
        this.game.swipeDown();
        
        int[][] expectedBoard = {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 4}
        };
        
        assertArrayEquals(expectedBoard, this.game.getBoard());
    }
    
    /**
     * Tests swiping a simple board from right to left. The board contains two twos only which collide during the swipe.
     */
    @Test
    public void testSimpleSwipeLeftWithCollision()
    {
        int[][] originalBoard = {
            {0, 2, 0, 2},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };
        
        this.game = new TwentyFourtyEight(originalBoard);
        this.game.swipeLeft();
        
        int[][] expectedBoard = {
            {4, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };
        
        assertArrayEquals(expectedBoard, this.game.getBoard());
    }
    
        /**
     * Tests swiping a simple board from left to right. The board contains two twos only which collide during the swipe.
     */
    @Test
    public void testSimpleSwipeRightWithCollision()
    {
        int[][] originalBoard = {
            {0, 2, 0, 2},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };
        
        this.game = new TwentyFourtyEight(originalBoard);
        this.game.swipeRight();
        
        int[][] expectedBoard = {
            {0, 0, 0, 4},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };
        
        assertArrayEquals(expectedBoard, this.game.getBoard());
    }
    
    /******* Private functions *********/
    /**
     * Tells if the integer matrix contains the provided number in any of its fields. 
     * 
     * @param matrix The matrix to be checked. 
     * @param number The number to be looked for in the matrix.
     * 
     * @return True, if the matrix contains the number; false otherwise.
     * 
     * @author Péter Ivanics
     * @date 01.02.2016.
     */
    private boolean contains(int[][] matrix, int number)
    {
        for (int i = 0; i < matrix.length; i++) 
        {
            for (int j = 0; j < matrix[i].length; j++) 
            {
                if (matrix[i][j] == number)
                        return true;
            }
        }
        
        return false;
    }
    
    /**
     * Counts the number of occurences of a number in a matrix. 
     * 
     * @param matrix The matrix to be checked. 
     * @param number The number to be counted in the matrix.
     * 
     * @return The number of occurances of the number as an integer.
     * 
     * @author Péter Ivanics
     * @date 01.02.2016.
     */
    private int count(int[][] matrix, int number)
    {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) 
        {
            for (int j = 0; j < matrix[i].length; j++) 
            {
                if (matrix[i][j] == number)
                        count++;
            }
        }
        
        return count;
    }
    
    /**
     * Prints the matrix on the console in a readable format.
     * @param matrix The matrix to be printed.
     * 
     * @author Péter Ivanics
     * @date 02.02.2016.
     */
    private void print(int[][] matrix)
    {
        for (int i = 0; i < matrix.length; i++) 
        {
            for (int j = 0; j < matrix[i].length; j++) 
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
}