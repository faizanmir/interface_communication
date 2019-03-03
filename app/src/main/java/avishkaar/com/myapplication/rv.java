package avishkaar.com.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class rv extends RecyclerView.Adapter<rv.viewHolder> implements Dialog.pst {
    int array[];
    int flag;
    ArrayList<Integer>inflator;
    Context context;
    Dialog.pst ref;


    public rv(int[] array, int flag, Dialog.pst x) {
        this.array = array;
        this.flag= flag;
        ref = x;
    }

    public rv(ArrayList<Integer>inflator,int flag) {
        this.inflator = inflator;
        this.flag = flag;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        viewHolder viewHolder = null;
        if (flag == 0) {
            viewHolder = new viewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.faces_rv, parent, false));
        }
        else if (flag ==1)
        {
            viewHolder = new viewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.faces_rv, parent, false));
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final viewHolder holder, final int position) {
        if(flag ==0) {
            holder.imageView.setImageResource(array[position]);
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Integer position_item = position;
                    Toast.makeText(context, position_item.toString(), Toast.LENGTH_SHORT).show();
                    ref.position(position);
                }
            });
        }
        else if (flag ==1)
        {
            holder.imageView.setImageResource(R.drawable.increament_button);
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Integer position_item = position;
                    Toast.makeText(context, position_item.toString(), Toast.LENGTH_SHORT).show();
                    position(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if(flag ==0){
        return array.length;
        }
        else if (flag ==1)
        {
            return inflator.size();
        }
        return 0;
    }

    @Override
    public void position(int position) {

    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        FloatingActionButton floatingActionButton;
            public viewHolder(@NonNull View itemView) {
            super(itemView);
            if(flag==0) {
                imageView = itemView.findViewById(R.id.imageView);
            }else if (flag ==1){
                imageView = itemView.findViewById(R.id.imageView);
            }

            context = itemView.getContext();
        }
    }
}