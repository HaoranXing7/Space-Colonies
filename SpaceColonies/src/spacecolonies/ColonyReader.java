package spacecolonies;

import java.io.File;
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

public class ColonyReader {

    private Planet[] planets;
    private ArrayQueue<Person> queue;

    public ColonyReader(String applicantFileName, String planetFileName)
        throws Exception {
        queue = readQueueFile(applicantFileName);
        planets = readPlanetFile(planetFileName);
        ColonyCalculator calc = new ColonyCalculator(queue, planets);
        @SuppressWarnings("unused")
        SpaceWindow window = new SpaceWindow(calc);
    }


    private Planet[] readPlanetFile(String fileName) throws Exception {
        Planet[] planets = new Planet[3];
        @SuppressWarnings("resource")
        Scanner file = new Scanner(new File(fileName));
        for (int i = 0; i < 3 && file.hasNextLine(); i++) {
            String[] params = file.nextLine().split(", ");
            if (params.length != 5) {
                throw new ParseException(fileName, i + 1);
            }
            int agri = Integer.valueOf(params[1]);
            int medi = Integer.valueOf(params[2]);
            int tech = Integer.valueOf(params[3]);
            int cap = Integer.valueOf(params[4]);
            if (!isInSkillRange(agri, medi, tech)) {
                throw new SpaceColonyDataException("Invalid skill values");
            }
            planets[i] = new Planet(params[0], agri, medi, tech, cap);
        }
        file.close();
        if (planets[2] == null) {
            throw new SpaceColonyDataException("Not enough planets entered");
        }
        return planets;
    }


    private ArrayQueue<Person> readQueueFile(String fileName)
        throws SpaceColonyDataException,
        FileNotFoundException,
        ParseException {
        Scanner file = new Scanner(new File(fileName));
        ArrayQueue<Person> temp = new ArrayQueue<Person>(20);
        while (file.hasNextLine()) {
            String[] skills;
            skills = file.nextLine().split(", *");
            for (int i = 0; i < skills.length; i++) {
                if (skills[i] == null || skills[i].equals("")) {
                    file.close();
                    throw (new ParseException(
                        "Error: There weren't three skills given for person",
                        i));
                }
            }
            if (!isInSkillRange(Integer.valueOf(skills[1]), Integer.valueOf(
                skills[2]), Integer.valueOf(skills[3]))) {
                file.close();
                System.out.println("SCDE");
                throw (new SpaceColonyDataException(
                    "Error: For person, skill wasn't between 1 and 5"));
            }
            try {
                temp.enqueue(new Person(skills[0], Integer.valueOf(skills[1]),
                    Integer.valueOf(skills[2]), Integer.valueOf(skills[3]),
                    skills[4]));
            }
            catch (ArrayIndexOutOfBoundsException e) {
                temp.enqueue(new Person(skills[0], Integer.valueOf(skills[1]),
                    Integer.valueOf(skills[2]), Integer.valueOf(skills[3]),
                    ""));
            }
        }
        file.close();
        return temp;
    }


    private boolean isInSkillRange(int num1, int num2, int num3) {
        if (num1 < ColonyCalculator.MIN_SKILL_LEVEL
            || num1 > ColonyCalculator.MAX_SKILL_LEVEL) {
            return false;
        }
        else if (num2 < ColonyCalculator.MIN_SKILL_LEVEL
            || num2 > ColonyCalculator.MAX_SKILL_LEVEL) {
            return false;
        }
        else if (num3 < ColonyCalculator.MIN_SKILL_LEVEL
            || num3 > ColonyCalculator.MAX_SKILL_LEVEL) {
            return false;
        }
        else {
            return true;
        }
    }
}
