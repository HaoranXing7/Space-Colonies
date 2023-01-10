/**
 * 
 */
package spacecolonies;

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
 * @version 2022/10/29
 */
public class Planet implements Comparable<Planet> {

    private String name;
    private Skillset minSkills;
    private Person[] population;
    private int populationSize;
    private int capacity;

    /**
     * The constructor of the class
     * Sets all of the fields
     * 
     * @param planetName
     *            String
     * @param planetAgri
     *            int representing ag skill
     * @param planetMedi
     *            int representing med skill
     * @param planetTech
     *            int representing tech skill
     * @param planetCap
     *            int representing planet capacity
     */
    public Planet(
        String planetName,
        int planetAgri,
        int planetMedi,
        int planetTech,
        int planetCap) {
        capacity = planetCap;
        populationSize = 0;
        population = new Person[planetCap];
        name = planetName;
        minSkills = new Skillset(planetAgri, planetMedi, planetTech);
    }


    /**
     * setter method for planet name
     * 
     * @param name
     *            of planet (String)
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * getter method for planet name
     * 
     * @return String of planet name
     */
    public String getName() {
        return name;
    }


    /**
     * a getter method for minimum skillset required
     * to populate planet
     * 
     * @return Skillset representing this minimum
     */
    public Skillset getSkills() {
        return minSkills;
    }


    /**
     * getter method for population
     * 
     * @return Person[] representing the population
     */
    public Person[] getPopulation() {
        return population;
    }


    /**
     * A getter method
     * 
     * @return int population size
     */
    public int getPopulationSize() {
        return populationSize;
    }


    /**
     * A getter method
     * 
     * @return int capacity
     */
    public int getCapacity() {
        return capacity;
    }


    /**
     * A getter method
     * 
     * @return int availability
     */
    public int getAvailability() {
        return capacity - populationSize;
    }


    /**
     * This method tells us if a planet is full
     * 
     * @return boolean representing if the planet is full
     */
    public boolean isFull() {
        return capacity == populationSize;
    }


    /**
     * This method determines if a person is qualified for
     * the planet of reference
     * 
     * @param p
     *            person of reference
     * @return boolean representing if the person is qualified
     */
    public boolean isQualified(Person p) {
        if (isFull()) {
            return false;
        }
        else if (p.getSkills().getAgriculture() < minSkills.getAgriculture()) {
            return false;
        }
        else if (p.getSkills().getMedicine() < minSkills.getMedicine()) {
            return false;
        }
        return (p.getSkills().getTechnology() >= minSkills.getTechnology());
    }


    /**
     * This method attempts to add a person to the planet
     * 
     * @param newbie
     *            Person to be added
     * @return boolean representing if add is successful
     */
    public boolean addPerson(Person newbie) {
        if (isFull()) {
            return false;
        }
        if (isQualified(newbie)) {
            population[populationSize] = newbie;
            populationSize++;
            return true;
        }
        return false;
    }


    /**
     * A toString method for the class
     * represents the planet as a string
     * 
     * @return String representing the planet
     */
    public String toString() {
        StringBuilder ans = new StringBuilder();
        ans.append(name);
        ans.append(", population ");
        ans.append(populationSize);
        ans.append("(cap: ");
        ans.append(capacity);
        ans.append("), Requires: A >= ");
        ans.append(minSkills.getAgriculture());
        ans.append(", M >= ");
        ans.append(minSkills.getMedicine());
        ans.append(", T >= ");
        ans.append(minSkills.getTechnology());
        return ans.toString();
    }


    /**
     * This method compares two planet objects
     * it returns -1 if the object being called upon is
     * less than the one being passed in.
     * it returns 1 if the object being called upon is greater.
     * returns zero if fully equal.
     * 
     * @return int representing comparison
     */
    @Override
    public int compareTo(Planet other) {
        if (other.getCapacity() == this.getCapacity()) {
            if (other.getAvailability() == this.getAvailability()) {
                if (this.getSkills().compareTo(other.getSkills()) != 0) {
                    return this.getSkills().compareTo(other.getSkills());
                }
                if (this.getName().compareTo(other.getName()) > 0) {
                    return 1;
                }
                else if (this.getName().compareTo(other.getName()) < 0) {
                    return -1;
                }
                return 0;
            }
            else if (other.getAvailability() > this.getAvailability()) {
                return -1;
            }
            return 1;
        }
        else if (other.getCapacity() > this.getCapacity()) {
            return -1;
        }
        return 1;

    }


    /**
     * determine if two planets are equal
     * 
     * @param obj
     *            - object passed in
     * @return boolean representing if the planet
     *         and object passed in are equal
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == Planet.class) {
            return this.toString().equals(obj.toString());
        }
        return false;
    }

}
