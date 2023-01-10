// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- HaoranXing
package spacecolonies;

/**
 * //Virginia Tech Honor Code Pledge:
 * //
 * //As a Hokie, I will conduct myself with honor and integrity at all times.
 * //I will not lie, cheat, or steal, nor will I accept the actions of those who
 * do.
 * // HaoranXing (906565302)
 * /**
 * Class description
 * 
 **/
/**
 * @author HaoranXing
 * @version 2022/11/4
 *
 */

public class ProjectRunner {
    public ProjectRunner() {

    }


    /**
     * Main method
     * 
     * @param args
     *            input
     * @throws Exception
     */
    @SuppressWarnings("unused")

    public static void main(String[] args) throws Exception {
        if (args.length == 2) {
            ColonyReader colony = new ColonyReader(args[0], args[1]);
        }
        else {
            ColonyReader colony = new ColonyReader("E:\\Doc\\input.txt",
                "E:\\\\Doc\\\\planets.txt");
        }
    }
}
