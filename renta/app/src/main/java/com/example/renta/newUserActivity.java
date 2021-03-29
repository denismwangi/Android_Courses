package com.example.renta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class newUserActivity extends AppCompatActivity {

    db userDb = new db(this);
    public EditText fname, lname, uname, email, cont, pass;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newuser);
        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        uname = findViewById(R.id.uname);
        email = findViewById(R.id.emain);
        cont = findViewById(R.id.cont);
        pass = findViewById(R.id.pass);
    }


    /**
     * Called when Save button is clicked
     * @param view
     */
    public void addNewUser(View view) {
        HashMap<String, String> queryValues = new HashMap<String, String>();
        queryValues.put("firstname", fname.getText().toString());
        queryValues.put("lastname", lname.getText().toString());
        queryValues.put("username", uname.getText().toString());
        queryValues.put("email", email.getText().toString());
        queryValues.put("contacts", cont.getText().toString());
        queryValues.put("password", pass.getText().toString());
        if (fname.getText().toString() != null && fname.getText().toString().trim().length() != 0) {
            userDb.insertUser(queryValues);
            this.callHomeActivity(view);
        } else {
            Toast.makeText(getApplicationContext(), "Please enter first name",
                    Toast.LENGTH_LONG).show();
        }
        if (lname.getText().toString() != null && lname.getText().toString().trim().length() != 0) {
            userDb.insertUser(queryValues);
            this.callHomeActivity(view);
        } else {
            Toast.makeText(getApplicationContext(), "Please enter last name",
                    Toast.LENGTH_LONG).show();
        }
        if (uname.getText().toString() != null && uname.getText().toString().trim().length() != 0) {
            userDb.insertUser(queryValues);
            this.callHomeActivity(view);
        } else {
            Toast.makeText(getApplicationContext(), "Please enter User name",
                    Toast.LENGTH_LONG).show();
        }
        if (email.getText().toString() != null && email.getText().toString().trim().length() != 0) {
            userDb.insertUser(queryValues);
            this.callHomeActivity(view);
        } else {
            Toast.makeText(getApplicationContext(), "Please enter email",
                    Toast.LENGTH_LONG).show();
        }
        if (cont.getText().toString() != null && cont.getText().toString().trim().length() != 0) {
            userDb.insertUser(queryValues);
            this.callHomeActivity(view);
        } else {
            Toast.makeText(getApplicationContext(), "Please enter contacts",
                    Toast.LENGTH_LONG).show();
        }
        if (pass.getText().toString() != null && pass.getText().toString().trim().length() != 0) {
            userDb.insertUser(queryValues);
            this.callHomeActivity(view);
        } else {
            Toast.makeText(getApplicationContext(), "Please enter password",
                    Toast.LENGTH_LONG).show();
        }

    }
    /**
     * Navigate to Home Screen
     * @param view
     */
    public void callHomeActivity(View view) {
        Intent objIntent = new Intent(getApplicationContext(),
                MainActivity.class);
        startActivity(objIntent);
    }





}
