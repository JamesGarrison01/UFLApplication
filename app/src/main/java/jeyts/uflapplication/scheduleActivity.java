//MainActivity.java

package jeyts.uflapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
//import android.widget.Toast;


import jeyts.uflapplication.Adapter.SchedArrayAdapter;
import jeyts.uflapplication.Model.MyDataModel;
import jeyts.uflapplication.Parser.JSONParser;
//import jeyts.uflapplication.util.InternetConnection;
import jeyts.uflapplication.util.Keys;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class scheduleActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<MyDataModel> list;
    private SchedArrayAdapter adapter;
    private String teamName = "Calendar";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        //Fresco.initialize(this);

        //   Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //   setSupportActionBar(toolbar);
        FloatingActionButton mapsButton = (FloatingActionButton) findViewById(R.id.fab);
        mapsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(scheduleActivity.this, MapsActivity.class));
               // startActivity(new Intent(v.getContext(), MapsActivity.class));
            }
        });
//
//        fabImageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //here
//                startActivity(new Intent(YourCurrentActivity.this,NewActivity.class));
//            }
//        });




        /**
         * Array List for Binding Data from JSON to this List
         */
        list = new ArrayList<>();
        /**
         * Binding that List to Adapter
         */
        adapter = new SchedArrayAdapter(this, list);

        /**
         * Getting List and Setting List Adapter
         */
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Snackbar.make(findViewById(R.id.parentLayout), list.get(position).getName() + " => " + list.get(position).getName(), Snackbar.LENGTH_LONG).show();
            }
        });

        new GetDataTask().execute();

    }

    /**
     * Creating Get Data Task for Getting Data From Web
     */
    class GetDataTask extends AsyncTask<Void, Void, Void> {

        ProgressDialog dialog;
        int jIndex;
        int x;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            /**
             * Progress Dialog for User Interaction
             */

            x=list.size();

            if(x==0)
                jIndex=0;
            else
                jIndex=x;

            dialog = new ProgressDialog(scheduleActivity.this);
            dialog.setTitle("Organizing Schedule: ");
            dialog.setMessage("Loading...");
            dialog.show();
        }

        @Nullable
        @Override
        protected Void doInBackground(Void... params) {

            /**
             * Getting JSON Object from Web Using okHttp
             */

            //JSONParser jsonParser = new JSONParser(teamName);
            //JSONParser.setTeamName(teamName);

            JSONObject jsonObject = JSONParser.getDataFromWeb(teamName);

            try {
                /**
                 * Check Whether Its NULL
                 */
                if (jsonObject != null) {
                    /**
                     * Check Length...
                     */
                    if(jsonObject.length() > 0) {
                        /**
                         * Getting Array named "contacts" From MAIN Json Object
                         */
                        Keys.KEY_CONTACTS = teamName;
                        JSONArray array = jsonObject.getJSONArray(Keys.KEY_CONTACTS);

                        /**
                         * Check Length of Array...
                         */


                        int lenArray = array.length();
                        if(lenArray > 0) {
                            for( ; jIndex < lenArray; jIndex++) {

                                /**
                                 * Creating Every time New Object
                                 * and
                                 * Adding into List
                                 */
                                MyDataModel model = new MyDataModel(teamName);

                                /**
                                 * Getting Inner Object from contacts array...
                                 * and
                                 * From that We will get Name of that Contact
                                 *
                                 */
                                JSONObject innerObject = array.getJSONObject(jIndex);
                                String date = innerObject.getString(Keys.KEY_date);
                                String time = innerObject.getString(Keys.KEY_time);
                                String location = innerObject.getString(Keys.Key_location);
                                String game = innerObject.getString(Keys.KEY_team);


                                model.setDate(date);
                                model.setTime2(time);
                                model.setLocation(location);
                                model.setGame(game);


                                /**
                                 * Adding name and phone concatenation in List...
                                 */
                                list.add(model);
                            }
                        }
                    }
                } else {

                }
            } catch (JSONException je) {
                Log.i(JSONParser.TAG, "" + je.getLocalizedMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            dialog.dismiss();
            /**
             * Checking if List size if more than zero then
             * Update ListView
             */
            if(list.size() > 0) {
                adapter.notifyDataSetChanged();
            } else {
                Snackbar.make(findViewById(R.id.parentLayout), "No Data Found", Snackbar.LENGTH_LONG).show();
            }
        }
    }
}