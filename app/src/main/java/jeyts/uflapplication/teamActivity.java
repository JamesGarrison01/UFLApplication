package jeyts.uflapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
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
