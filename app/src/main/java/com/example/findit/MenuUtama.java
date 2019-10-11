package com.example.findit;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.MenuItem;
import android.widget.TextView;

public class MenuUtama extends AppCompatActivity {
    private TextView mTextMessage;
    private ActionBar toolbar;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_maps:
                   //toolbar.setTitle("Maps");
                    fragment = new MapsFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_search:
                  //  toolbar.setTitle("Lihat Spot");
                    fragment = new LihatSpotFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_pengaturan:
                    //toolbar.setTitle("Pengaturan");
                    fragment = new PengaturanFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);

        BottomNavigationView navView = findViewById(R.id.nav_view);

       // mTextMessage = findViewById(R.id.message);

        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

      //  toolbar = getSupportActionBar();
       // toolbar.setTitle("Lihat Spot");
        loadFragment(new LihatSpotFragment());
    }

    private void loadFragment(Fragment fragment){
        //load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}
