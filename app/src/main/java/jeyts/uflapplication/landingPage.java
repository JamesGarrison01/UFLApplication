package jeyts.uflapplication;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class landingPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

    }

    //Goes to the team page when clicked
    public void goTeam(View view){
        Intent newIntent = new Intent (this, teamActivity.class);
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

}
