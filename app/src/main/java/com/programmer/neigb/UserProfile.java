package com.programmer.neigb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class UserProfile extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        drawerLayout=findViewById(R.id.drawer);
        navigationView=findViewById(R.id.navigationView);
        toolbar=findViewById(R.id.navtoolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        toggle=new ActionBarDrawerToggle(this,drawerLayout ,toolbar, R.string.drawerOpen, R.string.drawerClose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.profile:
                Toast.makeText(UserProfile.this ,"Profile",Toast.LENGTH_SHORT).show();
                break;

            case R.id.mentions:
                Toast.makeText(UserProfile.this ,"mentions",Toast.LENGTH_SHORT).show();
                break;

            case R.id.Discusions:
                Toast.makeText(UserProfile.this ,"Profile",Toast.LENGTH_SHORT).show();
                break;

            case R.id.Settings:
                Toast.makeText(UserProfile.this ,"Profile",Toast.LENGTH_SHORT).show();
                break;

            case R.id.Rate:
                Toast.makeText(UserProfile.this ,"Profile",Toast.LENGTH_SHORT).show();
                break;

            case R.id.logout:
                Toast.makeText(UserProfile.this ,"Profile",Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }
}
