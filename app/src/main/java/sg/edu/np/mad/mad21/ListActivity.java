package sg.edu.np.mad.mad21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    //TODO: Change data type
    ArrayList<String> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //TODO: Populate data to list
        for(int i=0; i<6; i++)
        {
            data.add("Category #" + i);
        }

        RecyclerView rv = findViewById(R.id.outer_rv);
        CategoriesAdapter adapter = new CategoriesAdapter(this, data);
        LinearLayoutManager layout = new LinearLayoutManager(this);
        rv.setAdapter(adapter);
        rv.setLayoutManager(layout);
    }
}