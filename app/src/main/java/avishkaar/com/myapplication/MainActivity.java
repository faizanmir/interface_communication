package avishkaar.com.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    ImageView imageView;
    Integer count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button3);
        Button button1 = findViewById(R.id.button4);
        imageView = findViewById(R.id.imageView3);
        final int  array[] ={R.drawable.angry_icon,R.drawable.batbot_icon,R.drawable.dog_icon,R.drawable.happy_icon,R.drawable.hi_icon,
                R.drawable.meep_icon,R.drawable.runner_icon,R.drawable.sad_icon,R.drawable.sad_icon,R.drawable.shock_icon,R.drawable.x_icon};
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog obj = new Dialog();
                Dialog.to_main_Activity ref = new Dialog.to_main_Activity() {
                    @Override
                    public void postiontomain(int position) {
                        imageView.setImageResource(array[position]);
                    }
                };
                obj.interface_method(ref);
                obj.show(getSupportFragmentManager(),"Dialog");
            }
        });
        count =0;

        button1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                count++;
                Toast.makeText(MainActivity.this, count.toString(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }

}
