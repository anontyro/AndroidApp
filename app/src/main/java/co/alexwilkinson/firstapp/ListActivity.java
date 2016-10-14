package co.alexwilkinson.firstapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    //create and array list to send the values to the adapter
    ArrayList<AdapterItems> listJobs = new ArrayList<>();
    MyCustomAdapter myadapter; //creates a new instance of the adapter to work with

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //create the ListView object
        ListView lvList = (ListView)findViewById(R.id.lvlist);

        //add items to the arraylist
        listJobs.add(new AdapterItems(R.drawable.one,"Web developer","designing sites"));
        listJobs.add(new AdapterItems(R.drawable.two,"Web developer","designing sites"));
        listJobs.add(new AdapterItems(R.drawable.three,"Web developer","designing sites"));

        //set up the adapter to take the arraylist
        myadapter= new MyCustomAdapter(listJobs);
        //add the adapter to the listView
        lvList.setAdapter(myadapter);

        //when item is selected in the list do this
        lvList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //what do you want to do when you select an item

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //floating toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    //adding a new item to a list
    public void addItem(View view) {

        //item to add
        listJobs.add(new AdapterItems(R.drawable.two,"New Developer","Developing stuff"));
        //automatically refresh the list without reloading
        myadapter.notifyDataSetChanged();
    }

    private class MyCustomAdapter extends BaseAdapter{
        public ArrayList<AdapterItems> dataAdapterList;

        public MyCustomAdapter(ArrayList<AdapterItems> dataAdapterList){
            this.dataAdapterList = dataAdapterList;
        }

        @Override
        public int getCount() {
            return dataAdapterList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        //will iterate as many times as the getCount returns the size
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            //inflator wil connect to the layout_job layout to pull the items
            LayoutInflater myInflater = getLayoutInflater();
            View myView = myInflater.inflate(R.layout.layout_job, null);

            final AdapterItems adapI = dataAdapterList.get(i);

            //these create the elements to display and write to
            ImageView ivImage =(ImageView) myView.findViewById(R.id.ivImage);
            ivImage.setImageResource(adapI.id);

            TextView tvTitle =(TextView)myView.findViewById(R.id.tvTitle);
            tvTitle.setText(adapI.jobTitle);

            TextView tvDesc =(TextView)myView.findViewById(R.id.tvDesc);
            tvDesc.setText(adapI.description);

            return myView;
        }
    }


}
