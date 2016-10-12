package co.alexwilkinson.firstapp;

import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

}
