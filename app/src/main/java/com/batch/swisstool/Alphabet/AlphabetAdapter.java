package com.batch.swisstool.Alphabet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.batch.swisstool.R;

import java.util.List;

public class AlphabetAdapter extends RecyclerView.Adapter<AlphabetAdapter.AlphabetHolder> {
    public static final int SPAN_COUNT_ONE = 1;
    public static final int SPAN_COUNT_THREE = 3;

    private static final int VIEW_TYPE_SMALL = 1;
    private static final int VIEW_TYPE_BIG = 2;

    private List<String> lettets;
    private GridLayoutManager mLayoutManager;

    public AlphabetAdapter(List<String> letters, GridLayoutManager layoutManager){
        this.lettets = letters;
        mLayoutManager = layoutManager;
    }

    @NonNull
    @Override
    public AlphabetHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view;
        if(viewType == VIEW_TYPE_BIG){
            view = LayoutInflater.from(context).inflate(R.layout.list_alphabet_item,parent,false);
        }else{
            view = LayoutInflater.from(context).inflate(R.layout.grid_alphabet_item,parent,false);
        }
        return new AlphabetHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull AlphabetHolder holder, int position) {
        String letter = lettets.get(position);
        holder.item.setText(letter);
    }

    @Override
    public int getItemViewType(int position) {
        int spanCount = mLayoutManager.getSpanCount();
        if(spanCount == SPAN_COUNT_ONE){
            return VIEW_TYPE_BIG;
        }else{
            return VIEW_TYPE_SMALL;
        }
    }

    @Override
    public int getItemCount() {
        return lettets.size();
    }

    class AlphabetHolder extends RecyclerView.ViewHolder{
        private TextView item;
        public AlphabetHolder(@NonNull View itemView, int viewType) {
            super(itemView);
            item = itemView.findViewById(R.id.alphabet_list_item);
        }
        void loadData(String letter){
            item.setText(letter);
        }
    }
}
