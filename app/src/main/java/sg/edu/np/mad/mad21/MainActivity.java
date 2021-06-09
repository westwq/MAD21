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
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private final static String SKIP = "pref_skip";
    private boolean skip = false;
    private TimerTask autoLaunch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences pref = getSharedPreferences(SKIP, MODE_PRIVATE);
        if(skip = pref.getBoolean(SKIP, false)) {
            launchRV();
        }

        CheckBox cb = findViewById(R.id.checkBox);
        cb.setChecked(skip);
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pref.edit().putBoolean(SKIP, cb.isChecked()).apply();

                autoLaunch.cancel();
                launchRV();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        //timer
        autoLaunch = new TimerTask() {
            @Override
            public void run() {
                launchRV();
            }
        };
        new Timer().schedule(autoLaunch, 3000);
//        new CountDownTimer(3000, 3000) {
//
//            @Override
//            public void onTick(long l) {
//
//            }
//
//            @Override
//            public void onFinish() {
//                launchRV();
//            }
//        }.start();
    }

    private void launchRV()
    {
        Intent i = new Intent(MainActivity.this, ListActivity.class);
        //i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(i);
    }
}