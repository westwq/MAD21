package sg.edu.np.mad.mad21;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryViewHolder extends RecyclerView.ViewHolder{
    TextView title;
    RecyclerView modulesRv;
    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title);
        modulesRv = itemView.findViewById(R.id.inner_rv);
    }
}
