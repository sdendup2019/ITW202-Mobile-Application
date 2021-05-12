package edu.gcit.todo_16;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private  final LinkedList<String>mwordlist=new LinkedList<>();

    private wordlistadapter madapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=0; i<20; i++){
            mwordlist.addLast("word"+1);
        }

        RecyclerView mrecycleview=findViewById(R.id.recycleview);
        madapter= new wordlistadapter(this,mwordlist);
        mrecycleview.setAdapter(madapter);
        mrecycleview.setLayoutManager(new LinearLayoutManager(this));


        FloatingActionButton plus=findViewById(R.id.floatingActionButton);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mwordlistSize=mwordlist.size();
                mwordlist.addLast("+ word"+mwordlistSize);

                mrecycleview.getAdapter().notifyItemInserted(mwordlistSize);

                mrecycleview.smoothScrollToPosition(mwordlistSize);
            }
        });

    }
}