package com.lavineoluoch.myapplication.listviewapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.gson.Gson;
import com.lavineoluoch.myapplication.listviewapp.Model.Cow;
import com.lavineoluoch.myapplication.listviewapp.Utils.AppController;
import com.lavineoluoch.myapplication.listviewapp.Utils.Constants;
import com.lavineoluoch.myapplication.listviewapp.Utils.CustomAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView lvCow;


    //@InjectView(R.id.toolbar)Toolbar toolbar;
    //@InjectView(R.id.lvCow)ListView lvCow;
    private List<Cow> cowList = new ArrayList<Cow>();
    private CustomAdapter adapter;
    private ProgressDialog pDialog;
    Constants constants = new Constants();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        lvCow = (ListView)findViewById(R.id.lvCow);

        //ButterKnife.inject(this);

        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();

        //Replace action bar with toolbar
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Cow stuff");


        //Get data from URL

        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(constants.URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                Log.d(constants.TAG_RESULT, jsonArray.toString());
                pDialog.hide();

                try{
                    for (int i = 0; i < jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Cow cow = new Cow();
                        cow.setCow_adtitle(jsonObject.getString(constants.TAG_ADTITLE));
                        cow.setCow_breed(jsonObject.getString(constants.TAG_BREED));
                        cow.setCow_county(jsonObject.getString(constants.TAG_COUNTY));
                        cow.setCow_price(jsonObject.getString(constants.TAG_PRICE));

                        cowList.add(cow);

                    }
                    adapter.notifyDataSetChanged();


                }catch (JSONException e){
                    e.printStackTrace();

                }

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                VolleyLog.d(constants.TAG_ERROR, "Error: " + volleyError.getMessage());
                pDialog.hide();
            }
        });
        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonArrayRequest);

        //Set listview adapter
        adapter = new CustomAdapter(this,cowList);
        lvCow.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
