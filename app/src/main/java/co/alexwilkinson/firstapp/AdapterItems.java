package co.alexwilkinson.firstapp;

/**
 * Created by Alex on 14/10/2016.
 * Used for the ListActivity
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
