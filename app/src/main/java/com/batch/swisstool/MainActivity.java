package com.batch.swisstool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity{

   // private HomeFragment homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //homeFragment = new HomeFragment();

        //getSupportFragmentManager().beginTransaction()
          //      .replace(R.id.main_layout,homeFragment)
            //    .commit();

    }

}
