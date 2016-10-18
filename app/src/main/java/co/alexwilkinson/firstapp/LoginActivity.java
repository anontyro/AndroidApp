package co.alexwilkinson.firstapp;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbManager = new DBManager(this);

    }

    public void buLogin(View view) {
        EditText etUser = (EditText)findViewById(R.id.etName);
        EditText etPass = (EditText)findViewById(R.id.etPassword);

        ContentValues values = new ContentValues();
        values.put(DBManager.colUsername, etUser.getText().toString());
        values.put(DBManager.colPassword, etPass.getText().toString());

        long id = dbManager.insert(values);
        if(id>0){
            Toast.makeText(getApplicationContext(),"Added Successfully id: "+id, Toast.LENGTH_LONG)
                    .show();
        }
        else{
            Toast.makeText(getApplicationContext(),"Error cannot insert",Toast.LENGTH_LONG).show();
        }

    }

    public void buCheck(View view) {

    }
}
