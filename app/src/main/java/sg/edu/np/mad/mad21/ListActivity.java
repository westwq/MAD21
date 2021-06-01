package sg.edu.np.mad.mad21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;


import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    //TODO: Change data type
    ArrayList<String> data = new ArrayList<>();

    DBHandler dbHandler = new DBHandler(this, null, null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //TODO: Populate data to list

        ArrayList<Electives> e = dbHandler.getAll();

        for (int i = 0; i< e.size(); i++) {
            data.add(e.get(i).getAreaOfInterest());
        }

        RecyclerView rv = findViewById(R.id.outer_rv);
        CategoriesAdapter adapter = new CategoriesAdapter(this, data);
        LinearLayoutManager layout = new LinearLayoutManager(this);
        rv.setAdapter(adapter);
        rv.setLayoutManager(layout);


    }
}