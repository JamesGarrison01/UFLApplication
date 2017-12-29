package jeyts.uflapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import jeyts.uflapplication.Adapter.StandArrayAdapter;
import jeyts.uflapplication.Model.MyDataModel;
import jeyts.uflapplication.Parser.JSONParser;
import jeyts.uflapplication.util.Keys;

public class newLanding extends AppCompatActivity {

    private ListView listView;
    private ArrayList<MyDataModel> list;
    private StandArrayAdapter adapter;
    private String teamName = "Standings";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_landing);



        /**
         * Array List for Binding Data from JSON to this List
         */
        list = new ArrayList<>();
        /**
         * Binding that List to Adapter
         */
        adapter = new StandArrayAdapter(this, list);

        /**
         * Getting List and Setting List Adapter
         */
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        new newLanding.GetDataTask().execute();

    }


    //Goes to the team page when clicked
    public void goTeam(View view){
        Intent newIntent = new Intent (this, teamActivity.class);
        startActivity(newIntent);
    }

    //Goes to the rule page when clicked
    public void goRule(View view){
        Intent newIntent = new Intent (this, rulePage.class);
        startActivity(newIntent);
    }

    //Goes to the stats page when clicked
    public void goStats(View view){
        Intent newIntent = new Intent (this, teamActivity.class);
        startActivity(newIntent);
    }

    //Goes to the Schedule page when clicked
    public void goSched(View view){
        Intent newIntent = new Intent (this, scheduleActivity.class);
        startActivity(newIntent);
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

            dialog = new ProgressDialog(newLanding.this);
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
                                String teamStand = innerObject.getString(Keys.KEY_teamStand);
                                String standScore = innerObject.getString(Keys.KEY_standScore);





                                /**
                                 * Getting Object from Object "phone"
                                 */
                                //JSONObject phoneObject = innerObject.getJSONObject(Keys.KEY_PHONE);
                                //String phone = phoneObject.getString(Keys.KEY_MOBILE);

                                model.setTeamStand(teamStand);
                                model.setStandScore(standScore);



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

