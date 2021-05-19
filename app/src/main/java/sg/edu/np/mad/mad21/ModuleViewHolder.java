package sg.edu.np.mad.mad21;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ModuleViewHolder extends RecyclerView.ViewHolder{
    View v;
    TextView name;
    public ModuleViewHolder(@NonNull View itemView) {
        super(itemView);
        v = itemView;
        name = itemView.findViewById(R.id.module_name);
    }
}
