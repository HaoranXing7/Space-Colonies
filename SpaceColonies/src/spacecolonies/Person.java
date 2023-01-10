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
 *
 */
public class Person {

    private String name;
    private Skillset skills;
    private String planetPreference;

    /**
     * Constructor for class that creates a person
     * and assigns all the fields
     * 
     * @param name
     *            of person (string)
     * @param agri
     *            skill value (int)
     * @param medi
     *            skill value (int)
     * @param tech
     *            skill value (int)
     * @param planet
     *            name (string)
     */
    public Person(String name, int agri, int medi, int tech, String planet) {
        this.name = name;
        planetPreference = planet;
        skills = new Skillset(agri, medi, tech);
    }


    /**
     * getter method for the name of the person
     * 
     * @return String name
     */
    public String getName() {
        return name;
    }


    /**
     * getter method for the skillset of the person
     * 
     * @return Skillset of person
     */
    public Skillset getSkills() {
        return skills;
    }


    /**
     * getter method for planetPreference of person
     * 
     * @return String of planetPreference
     */
    public String getPlanetPreference() {
        return planetPreference;
    }


    /**
     * Represents the person as a string
     * 
     * @return String representation
     */
    public String toString() {
        StringBuilder ans = new StringBuilder();
        if (planetPreference.length() == 0) {
            ans.append("No-Planet ");
        }
        ans.append(name);
        ans.append(" A:");
        ans.append(skills.getAgriculture());
        ans.append(" M:");
        ans.append(skills.getMedicine());
        ans.append(" T:");
        ans.append(skills.getTechnology());
        if (planetPreference.length() > 0) {
            ans.append(" Wants: ");
            ans.append(getPlanetPreference());
        }
        return ans.toString();
    }


    /**
     * Tells if two Persons are equal to eachother
     * 
     * @param obj
     *            of comparison
     * @return boolean representing answer
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == Person.class) {
            return this.toString().equals(obj.toString());
        }
        return false;
    }

}
