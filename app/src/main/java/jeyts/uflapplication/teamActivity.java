package jeyts.uflapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

public class teamActivity extends AppCompatActivity {


    private String teamBlackouts = "Blackouts";
    private String teamBeardos = "Beardos";
    private String teamGnarwhals = "Gnarwhals";
    private String teamHotDogs = "Hotdogs";
    private String teamChupacbras = "Chupacabras";
    private String teamUnicychos = "Unicychos";
    private String teamUnicorns = "Unicorns";
    private String teamTDB = "TDB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);

        Intent newIntent = getIntent();
        int Check = newIntent.getIntExtra("Value", 1);

        if(Check == 0){
            navigation.setSelectedItemId(R.id.navigation_stats);
        }
        else{
            navigation.setSelectedItemId(R.id.navigation_team);
        }
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

    public void goBlackouts(View view){
        Intent newIntent = new Intent (this, statsActivity.class);
        newIntent.putExtra("key", teamBlackouts);
        startActivity(newIntent);
    }

    public void goBeardos(View view){
        Intent newIntent = new Intent (this, statsActivity.class);
        newIntent.putExtra("key", teamBeardos);
        startActivity(newIntent);
    }

    public void goGnarwhals(View view){
        Intent newIntent = new Intent (this, statsActivity.class);
        newIntent.putExtra("key", teamGnarwhals);
        startActivity(newIntent);
    }

    public void goHotdogs(View view){
        Intent newIntent = new Intent (this, statsActivity.class);
        newIntent.putExtra("key", teamHotDogs);
        startActivity(newIntent);
    }

    public void goChupacabras(View view){
        Intent newIntent = new Intent (this, statsActivity.class);
        newIntent.putExtra("key", teamChupacbras);
        startActivity(newIntent);
    }

    public void goUnicychos(View view){
        Intent newIntent = new Intent (this, statsActivity.class);
        newIntent.putExtra("key", teamUnicychos);
        startActivity(newIntent);
    }

    public void goUnicorns(View view){
        Intent newIntent = new Intent (this, statsActivity.class);
        newIntent.putExtra("key", teamUnicorns);
        startActivity(newIntent);
    }

    public void goTDB(View view){
        Intent newIntent = new Intent (this, statsActivity.class);
        newIntent.putExtra("key", teamTDB);
        startActivity(newIntent);
    }

}
