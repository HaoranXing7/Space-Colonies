package spacecolonies;

import student.TestCase;

/**
 * //Virginia Tech Honor Code Pledge:
 * //
 * //As a Hokie, I will conduct myself with honor and integrity at all times.
 * //I will not lie, cheat, or steal, nor will I accept the actions of those who
 * do.
 * //-- Nick York (nickyork) && HaoranXing (HaoranXing)
 * /**
 * Class description
 * 
 * @author nickyork
 * @author HaoranXing
 * @version 11.18.2022
 */

public class SpaceColonyDataExceptionTest extends TestCase {
    /**
     * 
     */
    public void test() {
        @SuppressWarnings("unused")
        SpaceColonyDataException ex = new SpaceColonyDataException(null);
        assertEquals(ex.equals(ex), true);
    }

}
