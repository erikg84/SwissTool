package com.batch.swisstool.Tapper;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.batch.swisstool.R;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class StressTapper extends Fragment {
    private int count;
    private Button button;
    private TextView textView;
    private String tag;
    public StressTapper() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_stress_tapper, container, false);
        count = 0;
        tag = "LIFE CYCLE METHOD : ";
        textView = rootView.findViewById(R.id.count_text);
        button = rootView.findViewById(R.id.count_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(String.valueOf(++count));
            }
        });
        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                count = 0;
                textView.setText(String.valueOf(count));
                return false;
            }
        });

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
