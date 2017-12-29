package jeyts.uflapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class rulePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_ruleBook);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

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
}
