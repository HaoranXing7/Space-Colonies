
package spacecolonies;

import java.util.Arrays;
import list.AList;

/**
 *
 * @author HaoranXing
 * @version 2022/11/2
 */
public class ColonyCalculator {

    /**
     * This field represents the number of planets in every
     * scenario (three)
     */
    public static final int NUM_PLANETS = 3;
    /**
     * This field represents the minimum value for a skill
     */
    public static final int MIN_SKILL_LEVEL = 1;
    /**
     * This field represents the maximum value for a skill
     */
    public static final int MAX_SKILL_LEVEL = 5;
    private ArrayQueue<Person> applicantQueue;
    private AList<Person> rejectBus;
    private Planet[] planets;

    /**
     * The constructor for the class
     * Initializes the class fields
     * 
     * @param applicantQueue
     *            array queue of applicants
     * @param planets
     *            - array of planets
     */
    public ColonyCalculator(
        ArrayQueue<Person> applicantQueue,
        Planet[] planets) {
        if (applicantQueue == null) {
            throw new IllegalArgumentException();
        }
        this.applicantQueue = applicantQueue;
        this.planets = planets;
        rejectBus = new AList<Person>();
    }


    /**
     * A getter method for applicant queue
     * 
     * @return ArrayQueue<Person> containing applicants
     */
    public ArrayQueue<Person> getQueue() {
        return applicantQueue;
    }


    /**
     * A getter method for the planet array
     * 
     * @return Planet[] of the planets
     */
    public Planet[] getPlanets() {
        return planets;
    }


    /**
     * This method take a planet and person as parameters
     * It checks and lets the user know if the planet can accept
     * the person.
     * 
     * @param planet
     *            trying to add to
     * @param person
     *            trying to be added
     * @return boolean telling if the planet can accept the person
     */
    private boolean canAccept(Planet planet, Person person) {
        return planet.isQualified(person);
    }


    /**
     * This method figures out which planet best suits the
     * person being passed in.
     * Returns null if the person cannot go anywhere.
     * 
     * @param nextPerson
     *            is a Person trying to join a colony
     * @return Planet of best fit for nextPerson
     */
    public Planet getPlanetForPerson(Person nextPerson) {
        if (nextPerson == null) {
            return null;
        }
        String preference = nextPerson.getPlanetPreference();
        for (int i = 0; i < planets.length; i++) {
            if (planets[i].getName().equals(preference)) {
                if (canAccept(planets[i], nextPerson)) {
                    return planets[i];
                }
                return null;
            }
        }
        return getHighestCapacityPlanet(nextPerson);

    }


    /**
     * This method find and returns the
     * planet with the highest capacity
     * that the passed in person can join
     * 
     * @param p
     *            person trying to colonize
     * @return Planet with highest capacity that p can join
     */
    private Planet getHighestCapacityPlanet(Person p) {
        Planet[] ans = Arrays.copyOf(planets, planets.length);
        Arrays.sort(ans);
        for (int i = ans.length - 1; i >= 0; i--) {
            if (ans[i].isQualified(p)) {
                return ans[i];
            }
        }
        return null;
    }


    /**
     * Attempts to add the next applicant to a colony of best fit
     * 
     * @return boolean representing if the applicant is added
     */
    public boolean accept() {
        Person curr = applicantQueue.getFront();
        if (getPlanetForPerson(curr) != null) {
            getPlanetForPerson(curr).addPerson(curr);
            applicantQueue.dequeue();
            return true;
        }
        return false;
    }


    /**
     * This method rejects an applicant and puts
     * them on the rejectBus
     */
    public void reject() {
        Person curr = applicantQueue.dequeue();
        rejectBus.add(curr);
    }


    /**
     * Finds the index of a planet given the name
     * 
     * @param planet
     *            name (String)
     * @return int representing the index of the planet
     */
    public int getPlanetIndex(String planet) {
        for (int i = 0; i < planets.length; i++) {
            if (planets[i].getName().equals(planet)) {
                return i;
            }
        }
        return -1;
    }
}
