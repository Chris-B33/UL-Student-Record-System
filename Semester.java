import java.util.ArrayList;
/**
 * The `Semester` class represents an academic semester with attributes such as a list of modules,
 * semester number, academic year, total credits, and semester weighting.
 */
public class Semester {

    /**
     * List of modules associated with the semester.
     */
    private ArrayList<Module> modules;

    /**
     * The number that uniquely identifies the semester.
     */
    private int number;

    /**
     * The academic year of the semester.
     */
    private int year;

    /**
     * The total number of credits for the semester.
     */
    private double credits;

    /**
     * The weighting assigned to the semester.
     */
    private double weighting;

    /**
     * Constructs a new `Semester` object with the given semester number and weighting.
     *
     * @param number    The number that uniquely identifies the semester.
     * @param weighting The weighting assigned to the semester.
     */
    public Semester(int number, double weighting) {
        this.modules = new ArrayList<>();
        this.number = number;
        this.weighting = weighting;
    }

    /**
     * Returns the list of modules associated with the semester.
     *
     * @return List of modules in the semester.
     */
    public ArrayList<Module> getModules() {
        return modules;
    }

    /**
     * Sets the list of modules associated with the semester.
     *
     * @param modules The new list of modules.
     */
    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }

    /**
     * Returns the number that uniquely identifies the semester.
     *
     * @return The semester number.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Sets the number that uniquely identifies the semester.
     *
     * @param number The new semester number.
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Returns the academic year of the semester.
     *
     * @return The academic year.
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the academic year of the semester.
     *
     * @param year The new academic year.
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Returns the total number of credits for the semester.
     *
     * @return The total credits for the semester.
     */
    public double getCredits() {
        return credits;
    }

    /**
     * Sets the total number of credits for the semester.
     *
     * @param credits The new total credits for the semester.
     */
    public void setCredits(double credits) {
        this.credits = credits;
    }

    /**
     * Returns the weighting assigned to the semester.
     *
     * @return The semester weighting.
     */
    public double getWeighting() {
        return weighting;
    }

    /**
     * Sets the weighting assigned to the semester.
     *
     * @param weighting The new semester weighting.
     */
    public void setWeighting(double weighting) {
        this.weighting = weighting;
    }
}

