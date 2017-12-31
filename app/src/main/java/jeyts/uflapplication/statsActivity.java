//MainActivity.java

package jeyts.uflapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
//import android.widget.Toast;


import jeyts.uflapplication.Adapter.MyArrayAdapter;
import jeyts.uflapplication.Model.MyDataModel;
import jeyts.uflapplication.Parser.JSONParser;
//import jeyts.uflapplication.util.InternetConnection;
import jeyts.uflapplication.util.Keys;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class statsActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<MyDataModel> list;
    private MyArrayAdapter adapter;
    private String teamName = "BlackOuts";
    EditText inputSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        Intent intent = getIntent();
        teamName = intent.getExtras().getString("key");

        /**
         * Array List for Binding Data from JSON to this List
         */
        list = new ArrayList<>();
        /**
         * Binding that List to Adapter
         */
        adapter = new MyArrayAdapter(this, list);

        /**
         * Getting List and Setting List Adapter
         */
        listView = (ListView) findViewById(R.id.listView);
        inputSearch = (EditText) findViewById(R.id.inputSearch);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Snackbar.make(findViewById(R.id.parentLayout), list.get(position).getName() + " => " + list.get(position).getName(), Snackbar.LENGTH_LONG).show();
            }
        });

       new GetDataTask().execute();


        /**
         * Unused search function - at one point it will search by name for stats
         * still appears but is unusued
         */
        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                statsActivity.this.adapter.getFilter().filter(cs);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }
        });

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_stats); //determines which icon is hlighlighted
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }


    /**
     * determines which activity it goes to based on selection
     */
    public BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_schedule:
                    goSched();
                    return true;
                case R.id.navigation_stats:
                    goStats();
                    return true;
                case R.id.navigation_team:
                    goTeam();
                    return true;
                case R.id.navigation_home:
                    goHome();
                    return true;
                case R.id.navigation_ruleBook:
                    goRule();
                    return true;
            }
            return false;
        }
    };

    /**
     * goes to home activity when clicked
     */
    public void goHome(){
        Intent newIntent = new Intent (this, landingPage.class);
        startActivity(newIntent);
    }

    //Goes to the team page when clicked
    public void goTeam(){
        Intent newIntent = new Intent (this, teamActivity.class);
        startActivity(newIntent);
    }

    //Goes to the rule page when clicked
    public void goRule(){
        Intent newIntent = new Intent (this, rulePage.class);
        startActivity(newIntent);
    }

    //Goes to the stats page when clicked
    public void goStats(){
        int temp = 0;
        Intent newIntent = new Intent (this, teamActivity.class);
        newIntent.putExtra("Value", temp);
        startActivity(newIntent);
    }

    //Goes to the Schedule page when clicked
    public void goSched(){
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

            dialog = new ProgressDialog(statsActivity.this);
            dialog.setTitle("Organizing Stats: ");
            dialog.setMessage("Loading...");
            dialog.show();
        }

        @Nullable
        @Override
        protected Void doInBackground(Void... params) {

            /**
             * Getting JSON Object from Web Using okHttp
             */

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
                                String name = innerObject.getString(Keys.KEY_NAME);
                                String completions = innerObject.getString(Keys.KEY_Completions);
                                String attempts = innerObject.getString(Keys.KEY_Attempts);
                                String passTouchdowns = innerObject.getString(Keys.KEY_passTouchdowns);
                                String Interceptions = innerObject.getString(Keys.KEY_Interceptions);
                                String passingUnits = innerObject.getString(Keys.KEY_passingUnits);
                                String catches = innerObject.getString(Keys.KEY_Catches);
                                String receiveTouchdowns = innerObject.getString(Keys.KEY_receiveTouchdowns);
                                String receiveUnits = innerObject.getString(Keys.KEY_receiveUnits);
                                String tackles = innerObject.getString(Keys.KEY_Tackles);
                                String defInterception = innerObject.getString(Keys.KEY_defInterception);
                                String forceFumble = innerObject.getString(Keys.KEY_forceFumble);
                                String fumbleRecovery = innerObject.getString(Keys.KEY_fumbleRecovery);
                                String sacks = innerObject.getString(Keys.KEY_Sacks);
                                String Deflections = innerObject.getString(Keys.KEY_Deflections);
                                String defTD = innerObject.getString(Keys.KEY_defTD);
                                String rushTouchdowns = innerObject.getString(Keys.KEY_rushTouchdowns);
                                String rushUnits = innerObject.getString(Keys.KEY_rushUnits);
                                String Rushes = innerObject.getString(Keys.KEY_Rushes);
                                String fgMade = innerObject.getString(Keys.KEY_fgMade);
                                String fgTry = innerObject.getString(Keys.KEY_fgTry);
                                String kickRTD = innerObject.getString(Keys.KEY_kickRTD);


                                model.setName(name);
                                model.setInterceptions(Interceptions);
                                model.setCatches(catches);
                                model.setReceiveTouchdowns(receiveTouchdowns);
                                model.setReceiveUnits(receiveUnits);
                                model.setTackles(tackles);
                                model.setForceFumble(forceFumble);
                                model.setFumbleRecovery(fumbleRecovery);
                                model.setSacks(sacks);
                                model.setRushUnits(rushUnits);
                                model.setCompletions(completions);
                                model.setAttempts(attempts);
                                model.setDefInterception(defInterception);
                                model.setDeflections(Deflections);
                                model.setDefTD(defTD);
                                model.setRushes(Rushes);
                                model.setRushTouchdowns(rushTouchdowns);
                                model.setPassingUnits(passingUnits);
                                model.setPassTouchdowns(passTouchdowns);
                                model.setKickRTD(kickRTD);
                                model.setFgTry(fgTry);
                                model.setFgMade(fgMade);


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