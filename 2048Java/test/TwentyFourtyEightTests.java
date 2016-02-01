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
 * @date 01.01.2016.
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
     * @date 01.01.2016.
     */
    @Test
    public void testEmptyBoardContainsTwoTwos()
    {
        assertEquals(this.count(this.game.getBoard(), 2), 2);
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
     * @date 01.01.2016.
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
     * @date 01.01.2016.
     */
    private int count(int[][] matrix, int number)
    {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) 
        {
            for (int j = 0; j < matrix[i].length; j++) 
            {
                if (matrix[i][j] == number)
                        return count++;
            }
        }
        
        return count;
    }
}