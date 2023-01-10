/**
 * 
 */
package spacecolonies;

import student.TestCase;

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
/**
 * @author HaoranXing
 * @version 2022/11/1
 */
public class SkillsetTest extends TestCase {

    private Skillset planet;
    private Skillset person1;
    private Skillset person2;
    private Skillset person3;
    private Skillset person4;
    private Skillset person5;

    /**
     * 
     */
    public void setUp() {

        planet = new Skillset(3, 3, 3);
        person1 = new Skillset(2, 3, 3);
        person2 = new Skillset(5, 4, 4);
        person3 = new Skillset(3, 3, 3);
        person4 = new Skillset(3, 4, 3);
        person5 = new Skillset(3, 3, 4);
    }


    /**
     * 
     */
    public void testGetters() {
        assertEquals(3, planet.getAgriculture());
        assertEquals(3, planet.getMedicine());
        assertEquals(3, planet.getTechnology());
    }


    /**
     * 
     */
    public void testIsLessThanOrEqualTo() {
        assertEquals(true, planet.isLessThanOrEqualTo(person2));
        assertEquals(true, planet.isLessThanOrEqualTo(person3));
        assertEquals(false, planet.isLessThanOrEqualTo(person1));

    }


    /**
     * 
     */
    public void testToString() {
        assertEquals(planet.toString(), "A:3 M:3 T:3");

    }


    /**
     * 
     */
    public void testEquals() {

        assertEquals(planet.equals(planet), true);
        assertEquals(planet.equals(null), false);
        assertEquals(planet.equals(new Object()), false);
        assertEquals(planet.equals(person1), false);
        assertEquals(planet.equals(person2), false);
        assertEquals(planet.equals(person3), true);
        assertEquals(planet.equals(person4), false);
        assertEquals(planet.equals(person5), false);
    }


    /**
     * 
     */
    public void testCompareTo() {
        assertEquals(planet.compareTo(person1), 1);
        assertEquals(planet.compareTo(person2), -1);
        assertEquals(planet.compareTo(person3), 0);

    }
}
