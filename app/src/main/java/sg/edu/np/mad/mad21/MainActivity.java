package sg.edu.np.mad.mad21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Database start here
    DBHandler dbHandler = new DBHandler(this, null, null, 1);

    private final static String SKIP = "pref_skip";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox cb = findViewById(R.id.checkBox);
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor prefEdit = getSharedPreferences(SKIP, MODE_PRIVATE).edit();
                prefEdit.putBoolean(SKIP, true);
                prefEdit.apply();

                launchRV();
            }
        });

        SharedPreferences pref = getSharedPreferences(SKIP, MODE_PRIVATE);
        if(pref.getBoolean(SKIP, false)) {
            launchRV();
        }
        else {
            //Countdown can be in oncreate/../onresume
            new CountDownTimer(3000, 3000) {

                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    launchRV();
                }
            }.start();
        }
    }

    private void launchRV()
    {
        //TODO Creation of database
        /*String [] cloudList = {"Advanced Databases", "Cloud Architecture & Technologies",
                "Developing Cloud Applications", "Server & Cloud Security", "Virtualisation and Data Centre Management"};
        String [] dsaList = {"Big Data", "Data Visualisation", "Deep Learning", "Descriptive Analytics",
                "Machine Learning", "Quantitative Analysis"};
        String [] esmList = {"Customer Decision Making & Negotiation Skills",
                "Customer Experience Management", "Enterprise Resource Planning",
                "Infocomm Sales & Marketing Strategies", "Technology for Financial Institutions"};
        String [] gamesList = {"Artificial Intelligence for Games"};

        ArrayList<String> cloudModule = new ArrayList<>();
        ArrayList<String> dsaModule = new ArrayList<>();
        ArrayList<String> esmModule = new ArrayList<>();
        ArrayList<String> gamesModule = new ArrayList<>();

        for(int i = 0; i < cloudList.length; i++)
        {
            cloudModule.add(cloudList[i]);
        }
        for(int i = 0; i < dsaList.length; i ++)
        {
            dsaModule.add(dsaList[i]);
        }
        for(int i = 0; i < esmList.length; i ++)
        {
            esmModule.add(esmList[i]);
        }
        for(int i = 0; i < gamesList.length; i ++)
        {
            gamesModule.add(gamesList[i]);
        }
        String [] areaOfInterestList = {"Cloud Computing", "Data Science & Analytics", "Enterprice Solutioning & Marketing",
        "Games Programming"};
        ArrayList [] moduleList = {cloudModule, dsaModule, esmModule, gamesModule};
        Log.v("DATABASE", String.valueOf(moduleList.length));
        for(int i = 0; i < moduleList.length; i++) {
            Electives electives = new Electives(areaOfInterestList[i], moduleList[i]);
            dbHandler.addElectives(electives);
        }*/



        Intent i = new Intent(MainActivity.this, ListActivity.class);
        startActivity(i);
    }
}