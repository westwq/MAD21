package sg.edu.np.mad.mad21;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

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
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
