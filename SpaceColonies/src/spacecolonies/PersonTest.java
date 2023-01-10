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
 *
 */
public class PersonTest extends TestCase {

    private Person person1;
    private Person person2;
    private Person person3;
    private Person person4;
    private Person person5;
    private Person person6;

    /**
     * 
     */
    public void setUp() {

        person1 = new Person("Jane Doe", 3, 2, 1, "Nars");
        person2 = new Person("James", 3, 2, 1, "Earth");
        person3 = new Person("James", 3, 3, 5, "Earth");
        person4 = new Person("James", 3, 3, 5, "Mars");
        person5 = new Person("James", 3, 3, 5, "Mars");
        person6 = new Person("James", 3, 3, 5, "");
    }


    /**
     * 
     */
    public void testGetters() {

        assertEquals(person1.getName(), "Jane Doe");
        assertEquals(person1.getPlanetPreference(), "Nars");
        assertEquals(person1.getSkills(), person2.getSkills());

    }


    /**
     * 
     */
    public void testToString() {
        assertEquals(person1.toString(), "Jane Doe A:3 M:2 T:1 Wants: Nars");
        assertEquals(person6.toString(), "No-Planet James A:3 M:3 T:5");
    }


    /**
     * 
     */
    public void testEquals() {
        assertEquals(person1.equals(person1), true);
        assertEquals(person1.equals(person2), false);
        assertEquals(person1.equals(person3), false);
        assertEquals(person1.equals(null), false);
        assertEquals(person1.equals(new Object()), false);
        assertEquals(person2.equals(person3), false);
        assertEquals(person2.equals(person4), false);
        assertEquals(person3.equals(person4), false);
        assertEquals(person4.equals(person5), true);
    }

}
