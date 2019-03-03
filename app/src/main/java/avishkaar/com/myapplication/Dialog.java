package avishkaar.com.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class Dialog extends DialogFragment
{
    public interface pst
{
    void position(int position);
}
public interface to_main_Activity{
        void postiontomain(int position);
}
to_main_Activity tma;

    Button button;
    Button button2;
    int flag;
    ArrayList<Integer>array_list;
    int position_rv;
    void interface_method(to_main_Activity ref){
        tma = ref;
    }

    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        window.setGravity(Gravity.CENTER);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_box,container,false);
        button = view.findViewById(R.id.button);
        button2 =view.findViewById(R.id.button2);
        final ImageView imageView = view.findViewById(R.id.imageView2);
        array_list = new ArrayList<>();
        for(int i=0;i<=63;i++)
        {
            array_list.add(i);
        }
        final int  array[] ={R.drawable.angry_icon,R.drawable.batbot_icon,R.drawable.dog_icon,R.drawable.happy_icon,R.drawable.hi_icon,
                R.drawable.meep_icon,R.drawable.runner_icon,R.drawable.sad_icon,R.drawable.sad_icon,R.drawable.shock_icon,R.drawable.x_icon};

        final RecyclerView recyclerView = view.findViewById(R.id.rv);
        final RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(5,1);
        final RecyclerView.LayoutManager layoutManager1 = new StaggeredGridLayoutManager(5,1);
        final pst x = new Dialog.pst() {
            @Override
            public void position(int position) {
                position_rv = position;
                imageView.setImageResource(array[position]);
                tma.postiontomain(position);

            }
        };
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag =0;
                rv obj = new rv(array,0,x);
                recyclerView.setAdapter(obj);
                recyclerView.setLayoutManager(layoutManager);
                ;
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag =1;
                rv obj = new rv(array_list,1);
                recyclerView.setAdapter(obj);
                recyclerView.setLayoutManager(layoutManager1);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            tma = (to_main_Activity)getActivity();
        }catch (ClassCastException e ){

        }
    }
}

