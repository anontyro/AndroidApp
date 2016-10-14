package co.alexwilkinson.firstapp;

/**
 * Created by Alex on 14/10/2016.
 */

public class AdapterItems {
    public int id;
    public String jobTitle;
    public String description;

    AdapterItems(int id, String jobTitle, String description){
        this.id = id;
        this.jobTitle = jobTitle;
        this.description = description;
    }
}
