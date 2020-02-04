package com.batch.swisstool.Stones;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.batch.swisstool.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class GemDetailViewFragment extends Fragment {

    ImageView imageView;
    TextView nameView;
    TextView descView;
    String name, description;
    int imageId;
    private String tag;
    public GemDetailViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_gem_detail_view, container, false);
        tag = "LIFE CYCLE METHOD: ";

        imageView = rootView.findViewById(R.id.detail_image);
        nameView = rootView.findViewById(R.id.detail_name);
        descView = rootView.findViewById(R.id.detail_description);

        Bundle bundle = this.getArguments();
        name = bundle.getString("name");
        description = bundle.getString("description");
        imageId = bundle.getInt("imageId",0);

        imageView.setImageResource(imageId);
        nameView.setText(name);
        descView.setText(description);

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
