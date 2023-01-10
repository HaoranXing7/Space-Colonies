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
 * /**
 * /**
 * 
 * @author HaoranXing
 * @version 2022/11/2
 *
 */
public class ColonyCalculatorTest extends TestCase {

    private ColonyCalculator cc;
    private ColonyCalculator cc2;
    private ArrayQueue<Person> person;

    private Planet[] planet;
    private Planet[] planetSet;
    private Planet planet1;
    private Planet planet2;
    private Planet planet3;

    private Person person1;
    private Person person2;
    private Person person3;

    private Person person6;

    /**
     * 
     */
    public void setUp() {
        person = new ArrayQueue<Person>(50);

        planet1 = new Planet("Planet1", 4, 3, 3, 2);
        planet2 = new Planet("Planet2", 2, 3, 3, 2);
        planet3 = new Planet("Planet3", 2, 2, 4, 3);

        person1 = new Person("James", 2, 2, 2, "Planet1");
        person2 = new Person("Jack", 3, 3, 3, "Planet3");
        person3 = new Person("Mat", 3, 3, 3, "Planet2");

        person6 = new Person("Jesse", 3, 3, 3, "");
        planetSet = new Planet[] { planet1, planet2, planet3 };

        cc = new ColonyCalculator(person, planetSet);

    }


    /**
     * 
     */
    public void testConstructor() {
        @SuppressWarnings("unused")
        ColonyCalculator cc3;

        Exception thrown = null;
        try {

            cc3 = new ColonyCalculator(null, planet);
        }

        catch (Exception e) {

            thrown = e;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
    }


    /**
     * 
     */
    public void testGetters() {
        assertEquals(cc.getQueue(), person);
        assertNotSame(cc.getPlanets(), planet);
    }


    /**
     * 
     */
    public void testGetPlanetForPeson() {
        Person person4 = null;
        assertEquals(cc.getPlanetForPerson(person1), null);
        person.enqueue(person1);
        person.enqueue(person2);
        assertEquals(cc.getPlanetForPerson(person1), null);
        assertEquals(cc.getPlanetForPerson(person4), null);
        cc.getPlanetForPerson(person3);
        cc.getPlanetForPerson(person3);
        assertEquals(cc.getPlanetForPerson(person2), planet2);
        assertEquals(cc.getPlanetForPerson(person3), planet2);
        assertEquals(cc.getPlanetForPerson(person6), planet2);
        Planet[] planetSet1 = new Planet[3];
        Planet planet6 = null;
        planetSet[0] = planet1;
        planetSet[1] = planet2;
        planetSet[2] = planet6;
        cc2 = new ColonyCalculator(person, planetSet1);

    }


    /**
     * 
     */
    public void testAccept() {
        assertEquals(cc.accept(), false);
        person.enqueue(person2);
        assertEquals(cc.accept(), true);
        person.enqueue(person3);
        Person person4 = null;
        ArrayQueue<Person> person11 = new ArrayQueue<Person>(50);
        cc2 = new ColonyCalculator(person11, planetSet);
        assertEquals(cc2.accept(), false);
        person.clear();
        person.enqueue(person4);
        assertEquals(cc.accept(), false);
        person.clear();
        person.enqueue(person3);
        assertEquals(cc.accept(), true);
    }


    /**
     * 
     */
    public void testReject() {
        ArrayQueue<Person> personset2 = new ArrayQueue<Person>(50);
        personset2.enqueue(person1);
        cc2 = new ColonyCalculator(personset2, planetSet);
        cc2.reject();
        assertEquals(planet1.getAvailability(), 2);
        person.enqueue(person1);
        person.enqueue(person2);
        planet2.addPerson(person2);
        assertEquals(planet2.getAvailability(), 1);
        assertEquals(planet3.getAvailability(), 3);
        person.clear();
        person.enqueue(person1);
        ColonyCalculator cc7 = new ColonyCalculator(person, planetSet);
        cc7.reject();
        assertEquals(person.getSize(), 0);
        cc.reject();
        assertEquals(person.getSize(), 0);
    }

//
// /**
// *
// */
// public void testPlanetByNumber() {
// assertEquals(cc.planetByNumber(2), planet2);
// assertEquals(cc.planetByNumber(3), planet3);
// assertEquals(cc.planetByNumber(1), planet1);
// assertEquals(cc.planetByNumber(6), null);
// assertEquals(cc.planetByNumber(-1), null);
// }


    /**
     * 
     */
    public void testGetPlanetIndex() {
        assertEquals(cc.getPlanetIndex("Cars"), -1);
        assertEquals(cc.getPlanetIndex("Mars"), -1);
        assertEquals(cc.getPlanetIndex("Planet1"), 0);
        assertEquals(cc.getPlanetIndex("Planet2"), 1);
        assertEquals(cc.getPlanetIndex("Planet7"), -1);
        Planet[] planetSet1 = new Planet[3];
        Planet planet6 = null;
        planetSet1[0] = planet6;
        planet6 = new Planet("Planet6", 2, 3, 3, 2);
        cc2 = new ColonyCalculator(person, planetSet1);
        assertEquals(cc2.getPlanetIndex("Planet6"), -1);
    }
}
