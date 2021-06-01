package sg.edu.np.mad.mad21;

import java.util.ArrayList;

/****************************************************
*   This is the Area Of Interest class.             *
*   DO NOT TAMPER WITH ANYTHING IN THIS CLASS       *
*   AS IT WILL AFFECT THE OUTPUT OF THE SOLUTION.   *
****************************************************/

public class AreaOfInterest {
    private String Title;
    private ArrayList<String> Modules = new ArrayList<>();

    /*
    Default Constructors
    1. Default constructor without parameters.
    2. Default constructor with parameters.
        - Input: String of the title, Arraylist of the modules.
    */
    public AreaOfInterest(){

    }
    public AreaOfInterest(String Title, ArrayList<String> modules){
        this.Title = Title;
        for(int i =0; i <modules.size(); i ++)
        {
            this.Modules.add(modules.get(i));
        }
    }

    /*
    Getter for title.
    Output: String of title
     */
    public String getTitle() {
        return Title;
    }

    /*
    Setter for Title.
    Input: String of title
     */
    public void setTitle(String title) {
        Title = title;
    }

    /*
    Getter for Modules.
    Output: Arraylist of Modules
     */
    public ArrayList<String> getModules() {
        return Modules;
    }

    /*
    Setter for Modules.
    Input: Arraylist of Modules
     */
    public void setModules(ArrayList<String> modules) {
        Modules = modules;
    }
}
