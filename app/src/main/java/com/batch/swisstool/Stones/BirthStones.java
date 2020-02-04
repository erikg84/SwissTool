package com.batch.swisstool.Stones;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.batch.swisstool.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class BirthStones extends Fragment {
    RecyclerView myRecycler;
    MyAdapter myAdapter;
    GridLayoutManager myGrid;
    private String tag;
    public BirthStones() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_birth_stones, container, false);
        tag = "LIFE CYCLE METHOD : ";
        myGrid = new GridLayoutManager(container.getContext(),2);
        myRecycler = rootView.findViewById(R.id.recycle_view);
        myRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));

        GemAPI api = new GemAPI();
        myAdapter = new MyAdapter(getActivity(), api.getList(container.getContext()),myGrid);
        myRecycler.setAdapter(myAdapter);
        myRecycler.setLayoutManager(myGrid);
        return rootView;
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.d("LIFE CYCLE METHOD : ", "ON_STOP");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(tag, "ON_DESTROY");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(tag, "ON_RESUME");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(tag, "ON_PAUSE");
    }
}
