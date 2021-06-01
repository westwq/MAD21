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
        Intent i = new Intent(MainActivity.this, ListActivity.class);
        startActivity(i);
    }
}