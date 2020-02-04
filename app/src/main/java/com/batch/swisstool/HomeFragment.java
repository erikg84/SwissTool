package com.batch.swisstool;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.batch.swisstool.Alphabet.AlphabetViewer;
import com.batch.swisstool.Stones.BirthStones;
import com.batch.swisstool.Tapper.StressTapper;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private Button tapper;
    private Button stones;
    private Button alphabet;
    private BirthStones stonesFragment;
    private AlphabetViewer alphabetFragment;
    private StressTapper stressTapper;
    private String tag;
    private NavController navController;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        setup(rootView);


        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        NavigationUI.setupActionBarWithNavController(((AppCompatActivity) getActivity()),navController);
        onButtonClickListeners();
    }

    public void onButtonClickListeners() {
        alphabet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.next_alphabet);
            }
        });
        stones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.next_stones);
            }
        });
        tapper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.next_tapper);
            }
        });
    }
    private void setup(View rootView){
        tag = "LIFE CYCLE METHOD: ";
        getActivity().setTitle(R.string.home_fragment_title);
        alphabetFragment = new AlphabetViewer();
        stonesFragment = new BirthStones();
        stressTapper = new StressTapper();
        alphabet = rootView.findViewById(R.id.alphabet_button);
        stones = rootView.findViewById(R.id.stones_button);
        tapper = rootView.findViewById(R.id.tapper_button);
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
