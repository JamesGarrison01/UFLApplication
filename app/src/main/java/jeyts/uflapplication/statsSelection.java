package jeyts.uflapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class statsSelection extends AppCompatActivity {

    private Spinner spinner, spinner2;
    private Button btnSubmit;
    public String teamSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats_selection);

        addItemsOnSpinner();
        addListenerOnButton();
 //       addListenerOnSpinnerItemSelection();

    }

    public void addItemsOnSpinner(){

        spinner = (Spinner) findViewById(R.id.spinner);
        List<String> list = new ArrayList<String>();
        list.add("Blackouts");
        list.add("Beardos");
        list.add("Chupacabras");
        list.add("Gnarwhals");
        list.add("HotDogs");
        list.add("Unicorns");
        list.add("Unicycos");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);


    }

//    public void addListenerOnSpinnerItemSelection(){
//        spinner2 = (Spinner) findViewById(R.id.spinner2);
//        spinner2.setOnItemSelectedListener(new CustomOnItemSelectedListener());
//    }


    public void addListenerOnButton(){
        spinner = (Spinner) findViewById(R.id.spinner);
//        spinner2 = (Spinner) findViewById(R.id.spinner2);
        btnSubmit = (Button) findViewById(R.id.teamStatsBtn);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teamSelection = spinner.getSelectedItem().toString();
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                //teamSelection = parent.getItemAtPosition(pos);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });
    }





}
