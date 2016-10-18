package co.alexwilkinson.firstapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {
    TextView txtDisplay;
    EditText userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtDisplay = (TextView) findViewById(R.id.textView);
        txtDisplay.setText("");

        userName = (EditText) findViewById(R.id.name);

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Welcome, do you want to contiune?")
                .setTitle("Welcome")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .show();

    }

    public void buClick(View view) {

        String input = userName.getText().toString().trim();
        System.out.print(input);
        if(!input.equals("")){


            System.out.println(txtDisplay.getText());
            Intent intent =  new Intent(this, SecondActivity.class);
            intent.putExtra("name", input);
            startActivity(intent);
        }
        else{
            Toast.makeText(MainActivity.this, "Error no name entered", Toast.LENGTH_LONG).show();
        }

//        if((txtDisplay.getText()).equals("Click me more!")){
//            txtDisplay.setText("How now!");
//        }
//        else {
//            txtDisplay.setText("Click me more!");
//        }
    }

    public void buShow(View view) {
        //allow access to another view using the inflator
        LayoutInflater myInflator = getLayoutInflater();
        View view1 = myInflator.inflate(R.layout.showlayout,null);

        //call the EditText field from the other view and change it
        EditText et = (EditText) view1.findViewById(R.id.etTitle);
        et.setText("Welcome");

        //displays the showlayout page using the Toast command
        Toast toast = new Toast(getApplicationContext());
        toast.setView(view1);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
        toast.show();
    }

    public void buCalc(View view) {
        Intent intent = new Intent(this, CalcActivity.class);
        startActivity(intent);
    }

    public void buList(View view) {
        Intent intent = new Intent(this, ListActivity.class );
        startActivity(intent);
    }

    public void buLoginNow(View view) {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
}
