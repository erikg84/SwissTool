package com.batch.swisstool.Alphabet;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.batch.swisstool.Alphabet.AlphabetAdapter;
import com.batch.swisstool.R;

import java.util.Arrays;
import java.util.List;
import static com.batch.swisstool.Alphabet.AlphabetAdapter.SPAN_COUNT_ONE;
import static com.batch.swisstool.Alphabet.AlphabetAdapter.SPAN_COUNT_THREE;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlphabetViewer extends Fragment {
    private RecyclerView letterNames;
    private AlphabetAdapter adapter;
    private GridLayoutManager gridLayoutManager;
    private String tag;

    public AlphabetViewer() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_alphabet_viewer, container, false);
        letterNames = rootView.findViewById(R.id.alphabet_recycleview);
        tag = "LIFE CYCLE METHOD : ";
        gridLayoutManager = new GridLayoutManager(container.getContext(),SPAN_COUNT_ONE );

        RecyclerView.LayoutManager manager = new LinearLayoutManager(container.getContext());
        letterNames.setLayoutManager(manager);
        adapter = new AlphabetAdapter(getLetters(), gridLayoutManager);
        letterNames.setAdapter(adapter);
        letterNames.setLayoutManager(gridLayoutManager);
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    private List<String> getLetters(){
        return Arrays.asList("A","B","C","D","E","F","G","H","I","J","K","L",
                "M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z");
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {

        inflater.inflate(R.menu.menu_main, menu);
        //menu.findItem(R.id.menu_switch).set
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menu_switch){
            switchLayout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void switchLayout() {
        if (gridLayoutManager.getSpanCount() == SPAN_COUNT_ONE) {
            gridLayoutManager.setSpanCount(SPAN_COUNT_THREE);
        } else {
            gridLayoutManager.setSpanCount(SPAN_COUNT_ONE);
        }
        adapter.notifyItemRangeChanged(0, adapter.getItemCount());
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
