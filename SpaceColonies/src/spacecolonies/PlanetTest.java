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
public class PlanetTest extends TestCase {

    private Planet planet1;
    private Planet planet2;
    private Planet planet3;
    private Planet planet4;
    private Planet planet5;
    private Planet planet6;
    private Planet planet7;
    private Planet planet8;
    private Person person1;
    private Person person2;
    private Person person3;

    /**
     * 
     */
    public void setUp() {
        planet1 = new Planet("underground", 2, 2, 2, 3);
        planet2 = new Planet("Moon", 3, 3, 3, 30);
        planet3 = new Planet("Mercury", 2, 3, 3, 25);
        planet4 = new Planet("Venus", 3, 4, 5, 25);
        planet5 = new Planet("Mars", 4, 2, 4, 70);
        planet6 = new Planet("underground", 2, 2, 2, 3);
        planet7 = new Planet("underground1", 2, 2, 2, 4);
        planet8 = new Planet("underground", 2, 3, 3, 3);
        person1 = new Person("Jame", 2, 2, 2, "Mars");
        person2 = new Person("Tom", 1, 1, 1, "Mars");
        person3 = new Person("Jack", 4, 2, 4, "Mars");
    }


    /**
     * 
     */
    public void testSetter() {

        assertEquals(planet1.getName(), "underground");
        planet1.setName("sky");
        assertEquals(planet1.getName(), "sky");

    }


    /**
     * 
     */
    public void testGetters() {
        assertEquals(planet1.getName(), "underground");
        assertEquals(planet1.getCapacity(), 3);
        assertEquals(planet1.getPopulationSize(), 0);
        assertEquals(planet1.getSkills(), planet6.getSkills());
        assertEquals(planet3.getPopulation(), planet3.getPopulation());
        assertEquals(planet1.getAvailability(), 3);
    }


    /**
     * 
     */
    public void testIsFull() {
        assertEquals(planet1.isFull(), false);
        planet1.addPerson(person1);
        planet1.addPerson(person1);
        planet1.addPerson(person1);
        assertEquals(planet1.isFull(), true);
    }


    /**
     * 
     */
    public void testAddPerson() {
        assertEquals(planet1.addPerson(person1), true);
        planet1.addPerson(person1);
        planet1.addPerson(person1);
        assertEquals(planet1.addPerson(person1), false);
        assertEquals(planet5.addPerson(person3), true);

    }


    /**
     * 
     */
    public void testIsQualified() {
        assertEquals(planet1.isQualified(person1), true);
        assertEquals(planet2.isQualified(person2), false);

    }


    /**
     * 
     */
    public void testToString() {
        assertEquals(planet1.toString(), "underground, population 0 (cap: 3), "
            + "Requires: A >= 2, M >= 2, T >= 2");
    }


    /**
     * 
     */
    public void testEquals() {
        assertEquals(planet1.equals(planet2), false);
        assertEquals(planet1.equals(planet1), true);
        assertEquals(planet1.equals(planet3), false);
        assertEquals(planet1.equals(planet4), false);
        assertEquals(planet1.equals(planet5), false);
        assertEquals(planet1.equals(new Object()), false);
        assertEquals(planet1.equals(null), false);
        assertEquals(planet1.equals(planet6), true);
        assertEquals(planet1.equals(planet7), false);
        assertEquals(planet1.equals(planet8), false);
        planet1.addPerson(person1);
        assertEquals(planet1.equals(planet6), false);

    }


    /**
     * 
     */
    public void testCompareTo() {
        assertEquals(planet3.compareTo(planet1), 1);
        assertEquals(planet3.compareTo(planet2), -1);
        assertEquals(planet3.compareTo(planet3), 0);
    }

}
