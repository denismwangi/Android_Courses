package com.example.renta;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.util.ArrayList;
import java.util.HashMap;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    db userDb = new db(this);
    //Progress Dialog Object
    ProgressDialog prgDialog;
    private Button addbtn;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addbtn = findViewById(R.id.button1);
        //Get User records from SQLite DB
        ArrayList<HashMap<String, String>> userList =  userDb.getAllUsers();
        //
        if(userList.size()!=0){
            //Set the User Array list in ListView
            ListAdapter adapter = new SimpleAdapter( MainActivity.this,userList, R.layout.view_user,
                    new String[] { "userId","firstname"},
                    new int[] {R.id.userId, R.id.firstname});
            ListView myList =(ListView)findViewById(android.R.id.list);
            myList.setAdapter(adapter);
            //Display Sync status of SQLite DB
            Toast.makeText(getApplicationContext(), userDb.getSyncStatus(), Toast.LENGTH_LONG).show();
        }
        //Initialize Progress Dialog properties
        prgDialog = new ProgressDialog(this);
        prgDialog.setMessage("Synching Data Please wait...");
        prgDialog.setCancelable(false);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, newUserActivity.class );
                startActivity(intent);
                finish();
            }
        });


    }


        //sync user with online db
    public void syncSQLiteMySQLDB(){
        //Create AsycHttpClient object
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        ArrayList<HashMap<String, String>> userList =  userDb.getAllUsers();
        if(userList.size()!=0){
            if(userDb.dbSyncCount() != 0){
                prgDialog.show();
                params.put("usersJSON", userDb.composeJSONfromSQLite());
                client.post("https://rentaapi.herokuapp.com/api/v1/auth/signup",params ,new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody ) {
                        System.out.println(responseBody);
                        prgDialog.hide();
//                        try {
//                            JSONArray arr = new JSONArray(response);
//
//                            System.out.println(arr.length());
//                            for(int i=0; i<arr.length();i++){
//                                JSONObject obj = (JSONObject)arr.get(i);
//                                System.out.println(obj.get("id"));
//                                System.out.println(obj.get("status"));
//                                userDb.updateSyncStatus(obj.get("id").toString(),obj.get("status").toString());
//                            }
                            Toast.makeText(getApplicationContext(), "DB Sync completed!", Toast.LENGTH_LONG).show();
//                        } catch (JSONException e) {
//                            // TODO Auto-generated catch block
//                            Toast.makeText(getApplicationContext(), "Error Occured [Server's JSON response might be invalid]!", Toast.LENGTH_LONG).show();
//                            e.printStackTrace();
//                        }

                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        // TODO Auto-generated method stub
                        prgDialog.hide();
                        if(statusCode == 404){
                            Toast.makeText(getApplicationContext(), "Requested resource not found", Toast.LENGTH_LONG).show();
                        }else if(statusCode == 500){
                            Toast.makeText(getApplicationContext(), "Something went wrong at server end", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(getApplicationContext(), "Unexpected Error occcured! [Most common Error: Device might not be connected to Internet]", Toast.LENGTH_LONG).show();
                        }

                    }


                });
            }else{
                Toast.makeText(getApplicationContext(), "SQLite and Remote MySQL DBs are in Sync!", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(getApplicationContext(), "No data in SQLite DB, please do enter User name to perform Sync action", Toast.LENGTH_LONG).show();
        }
    }

    public void syncUser(View view) {
        syncSQLiteMySQLDB();
    }
}

