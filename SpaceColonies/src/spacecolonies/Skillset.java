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
public class Skillset {
    /**
     * 
     */
    protected int agriculture;
    /**
     * 
     */
    protected int medicine;
    /**
     * 
     */
    protected int technology;

    /**
     * 
     * @param aGrade
     *            aGrade
     * @param mGrade
     *            aGrade
     * @param tGrade
     *            aGrade
     */
    public Skillset(int aGrade, int mGrade, int tGrade) {
        this.agriculture = aGrade;
        this.medicine = mGrade;
        this.technology = tGrade;
    }


    /**
     * @return the agriculture
     */
    public int getAgriculture() {
        return agriculture;
    }


    /**
     * @return the medicine
     */
    public int getMedicine() {
        return medicine;
    }


    /**
     * @return the technology
     */
    public int getTechnology() {
        return technology;
    }


    /**
     * 
     * @param other
     *            other
     * @return true or false
     */
    public boolean isLessThanOrEqualTo(Skillset other) {

        return (this.agriculture <= other.agriculture
            && this.medicine <= other.medicine
            && this.technology <= other.technology);

    }


    @Override
    public String toString() {
        return "A:" + agriculture + " M:" + medicine + " T:" + technology;
    }


    /**
     * @param obj
     *            the object
     * @return true or false
     */
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        return (((Skillset)obj).getAgriculture() == this.agriculture
            && ((Skillset)obj).getMedicine() == this.medicine && ((Skillset)obj)
                .getTechnology() == this.technology);
    }


    /**
     * 
     * @param set
     *            set
     * @return the number ,-1, 0 or 1;
     */
    public int compareTo(Skillset set) {
        if (this.agriculture + this.medicine + this.technology < set.agriculture
            + set.medicine + set.technology) {
            return -1;
        }
        if (this.agriculture + this.medicine
            + this.technology == set.agriculture + set.medicine
                + set.technology) {
            return 0;
        }
        return 1;
    }

}
