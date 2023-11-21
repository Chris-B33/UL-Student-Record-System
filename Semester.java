import java.util.ArrayList;
public class Semester
{
    private ArrayList<Module> modules;
    private int number;
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
    public double getWeighting() {
        return weighting;
    }
    public void setWeighting(double weighting) {
        this.weighting = weighting;
    }
}
