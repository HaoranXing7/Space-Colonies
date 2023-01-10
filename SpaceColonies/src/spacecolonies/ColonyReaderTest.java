/**
 * 
 */
package spacecolonies;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * //Virginia Tech Honor Code Pledge:
 * //
 * //As a Hokie, I will conduct myself with honor and integrity at all times.
 * //I will not lie, cheat, or steal, nor will I accept the actions of those who
 * do.
 * //-- HaoranXing (HaoranXing)
 * /**
 * Class description
 * 
 **/
public class ColonyReaderTest extends student.TestCase {
    @SuppressWarnings("unused")
    private String fileName;
    @SuppressWarnings("unused")
    private Scanner fileData;

    /**
     * sets up any needed variables for test methods
     */
    public void setUp() {
        fileData = null;
    }


    /**
     * Test the program with input.txt and planetsHighSkill
     * 
     * @throws SpaceColonyDataException
     * @throws ParseException
     * 
     */
    public void testMain()
        throws java.io.IOException,
        ParseException,
        SpaceColonyDataException {
        Exception e = null;
        try {
            ProjectRunner.main(new String[] { "input.txt",
                "planetsHighSkill.txt" });
        }
        catch (Exception exception) {
            e = exception;
        }
        assertNotNull(e);
    }


    /**
     * 
     */
    public void testReadQueueFile()
        throws SpaceColonyDataException,
        FileNotFoundException,
        ParseException {

    }


    /**
     * 
     */
    public void testIsInSkillRange() {

    }


    /**
     * 
     */
    public void testReadPlanetFile()
        throws SpaceColonyDataException,
        FileNotFoundException,
        ParseException {

    }
}
