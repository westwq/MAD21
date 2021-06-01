package sg.edu.np.mad.mad21;

import java.util.ArrayList;
import java.util.Collections;

public class Electives {
    private String AreaOfInterest;
    private ArrayList<String> Modules = new ArrayList<>();

    public Electives(){

    }

    public Electives(String areaOfInterest, ArrayList<String> modules){
        this.AreaOfInterest = areaOfInterest;
        for(int i =0; i <modules.size(); i ++)
        {
            this.Modules.add(modules.get(i));
        }
    }

    public String getAreaOfInterest() {
        return AreaOfInterest;
    }

    public void setAreaOfInterest(String areaOfInterest) {
        AreaOfInterest = areaOfInterest;
    }

    public ArrayList<String> getModules() {
        return Modules;
    }

    public void setModules(ArrayList<String> modules) {
        Modules = modules;
    }
}
