package edu.gcit.todo_16;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class wordlistadapter extends RecyclerView.Adapter<wordlistadapter.WordViewHolder> {
    private final LinkedList<String>mwordlist;
    private LayoutInflater minflater;

    public wordlistadapter(Context context, LinkedList<String>mwordlist){
        minflater=LayoutInflater.from(context);
        this.mwordlist=mwordlist;
    }

    @NonNull
    @Override
    public wordlistadapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView=minflater.inflate(R.layout.wordlist, parent);
        return new WordViewHolder(mItemView, this);

    }

    @Override
    public void onBindViewHolder(@NonNull wordlistadapter.WordViewHolder holder, int position) {
    String mcurrent=mwordlist.get(position);
    holder.wordItemView.setText(mcurrent);
    }

    @Override
    public int getItemCount() {
        return mwordlist.size();
    }
    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private  final TextView wordItemView;
        final wordlistadapter madapter;

        public WordViewHolder(@NonNull View itemView, wordlistadapter madapter) {
            super(itemView);
            wordItemView=itemView.findViewById(R.id.word);
            this.madapter=madapter;
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {

            int mposition=getLayoutPosition();
            String element=mwordlist.get(mposition);
            mwordlist.set(mposition, "Clicked!"+element);
            madapter.notifyDataSetChanged();

        }
    }


}
