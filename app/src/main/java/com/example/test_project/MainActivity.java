package com.example.test_project;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.test_project.home.HomeFragment;
import com.example.test_project.home.MyPageFragment;
import com.example.test_project.home.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private HomeFragment homeFragment;
    private SearchFragment searchFragment;
    private MyPageFragment myPageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_home_home:
                        setFrag(0);
                        break;
                    case R.id.menu_search:
                        setFrag(1);
                        break;
                    case R.id.menu_my_page:
                        setFrag(2);
                        break;
                }
                return true;
            }
        });


        homeFragment = new HomeFragment();
        searchFragment = new SearchFragment();
        myPageFragment = new MyPageFragment();
        setFrag(0); // 첫 프래그먼트 지정

    }

    private void setFrag(int n){
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (n) {
            case 0:
                ft.replace(R.id.homeFragmentFrame, homeFragment);
                ft.commit(); // 저장을 의미
                break;
            case 1:
                ft.replace(R.id.homeFragmentFrame, searchFragment);
                ft.commit(); // 저장을 의미
                break;
            case 2:
                ft.replace(R.id.homeFragmentFrame, myPageFragment);
                ft.commit(); // 저장을 의미
                break;
        }
    }


}
