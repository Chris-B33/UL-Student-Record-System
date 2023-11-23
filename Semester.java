import java.util.ArrayList;
public class Semester
{
    private ArrayList<Module> modules;
    private int number;
    private int year;
    private double credits;
    private double weighting;

    public Semester(int number, double weighting) {
        this.modules = new ArrayList<>();
        this.number = number;
        this.weighting = weighting;
    }
    public ArrayList<Module> getModules() {
        return modules;
    }
    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public int getYear(){
        return year;
    }
    public void setYear(int year){
        this.year = year;
    }
    public double getCredits() {
        return credits;
    }
    public void setCredits(double credits) {
        this.credits = credits;
    }
    public double getWeighting() {
        return weighting;
     }
    public void setWeighting(double weighting) {
        this.weighting = weighting;
    }
}
