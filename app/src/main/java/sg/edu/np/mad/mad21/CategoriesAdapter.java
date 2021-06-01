package sg.edu.np.mad.mad21;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoryViewHolder>{
    //TODO: Change data type
    ArrayList<String> data = new ArrayList<>();
    Context c;

    public CategoriesAdapter(Context c, ArrayList<String> data) {
        this.c = c;
        this.data = data;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.vh_categories,parent, false);

        return new CategoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        //TODO: Update outer view holder
        String data = this.data.get(position);

        holder.title.setText(data);

        //TODO: Update inner rv
        ArrayList<String> data2 = new ArrayList<>();
        DBHandler dbHandler = new DBHandler(c, null,null, 1);
        AreaOfInterest e = dbHandler.findTitle(data);
        for (int i = 0; i < e.getModules().size(); i++)
        {
            data2.add(e.getModules().get(i));
        }

        /*
        for(int i=0; i<new Random().nextInt(6); i++)
        {
            data2.add("module /"+ i);
        }*/
        LinearLayoutManager innerLayout = new LinearLayoutManager(c);
        innerLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
        holder.modulesRv.setLayoutManager(innerLayout);
        holder.modulesRv.setAdapter(new ModulesAdapter(c, data2));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
