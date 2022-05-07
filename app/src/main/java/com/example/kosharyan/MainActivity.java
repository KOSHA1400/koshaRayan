package com.example.kosharyan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;


import com.example.kosharyan.fragment.FragmentAboutUs;
import com.example.kosharyan.fragment.FragmentCall;
import com.example.kosharyan.fragment.FragmentHome;
import com.example.kosharyan.fragment.FragmentNewsList;
import com.example.kosharyan.fragment.FragmentProduct;
import com.example.kosharyan.util.Util;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity {


    Toolbar toolbar ;
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager=getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.container,new FragmentHome(),null).commit();


       toolbar = findViewById(R.id.toolbar);
       bottomNavigation=findViewById(R.id.bottom_nav);

      setupToolbar();
      setupBottomNavigation();





    }

    void setupToolbar(){
       // toolbar.setTitle("Kosha Rayan");
       // toolbar.setNavigationIcon(R.drawable.logo);
        setSupportActionBar(toolbar);
    }
    private static long back_pressed;
    @Override
    public void onBackPressed() {

      Fragment fragment= getSupportFragmentManager().findFragmentById(R.id.container);
        if (fragment instanceof FragmentHome){

            if (back_pressed + 2000000000 > System.currentTimeMillis()) {
                super.onBackPressed();
            } else {
                Toast.makeText(getBaseContext(), "برای خروج از برنامه لطفا دوباره کلیک کنید.",
                        Toast.LENGTH_SHORT).show();
                back_pressed = System.currentTimeMillis();
            }
        }else {

            Util.goToFragment(new FragmentHome(),this);
            bottomNavigation.setSelectedItemId(R.id.item_3);
        }


    }



    void setupBottomNavigation() {

        bottomNavigation.setSelectedItemId(R.id.item_3);
        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.item_3:{

                       Util.goToFragment(new FragmentHome(),MainActivity.this);
                        return true;
                    }
                    case R.id.item_2:{

                        FragmentManager fragmentManager=getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.container,new FragmentProduct(),null).commit();

                        return true;
                    }
                    case R.id.item_1:{

                        FragmentManager fragmentManager=getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.container,new FragmentAboutUs(),null).commit();

                        return true;
                    }
                    case R.id.item_5:{

                        FragmentManager fragmentManager=getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.container,new FragmentCall(),null).commit();

                        return true;
                    }
                    case R.id.item_4:{

                        FragmentManager fragmentManager=getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.container,new FragmentNewsList(),null).commit();

                        return true;
                    }


                }

                return false;
            }

        });

    }


}