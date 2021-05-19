package sg.edu.np.mad.mad21;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ModulesAdapter extends RecyclerView.Adapter<ModuleViewHolder>{
    //TODO: Update data type
    ArrayList<String> data;
    Context c;

    public ModulesAdapter(Context c, ArrayList<String> data)
    {
        this.c = c;
        this.data = data;
    }
    @NonNull
    @Override
    public ModuleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.vh_module, parent, false);

        return new ModuleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ModuleViewHolder holder, int position) {
        String data = this.data.get(position);
        holder.name.setText(data);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
