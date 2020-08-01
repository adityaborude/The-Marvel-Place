package com.example.themarvelplace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.themarvelplace.character.CharactersFragment;
import com.example.themarvelplace.comic.ComicsFragment;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    MaterialToolbar search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new HomeFragment()).commit();
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setSelectedItemId(R.id.nav_home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragmentSelected = null;
                switch (item.getItemId()){
                    case R.id.nav_home:
                        fragmentSelected = new HomeFragment();
                        break;

                    case R.id.nav_comics:
                        fragmentSelected = new ComicsFragment();
                        break;

                    case R.id.nav_characters:
                        fragmentSelected = new CharactersFragment();
                        break;
                }
                if (fragmentSelected != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragmentSelected).commit();
                }
                return true;
            }
        });

        search = findViewById(R.id.toolbar);
        //search.inflateMenu(R.menu.search);
        search.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Fragment fragmentSelected = new SearchFragment();
                if (fragmentSelected!=null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragmentSelected).commit();
                }
                return true;
            }
        });
    }
}