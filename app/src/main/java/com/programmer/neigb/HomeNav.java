package com.programmer.neigb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.Switch;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeNav extends AppCompatActivity {
    Toolbar mtoolbar;
    FloatingActionButton floatbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_nav);



        //creating reference for floating action button
        floatbtn=(FloatingActionButton) findViewById(R.id.floater);
        floatbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeNav.this,SharingActivity.class);
                startActivity(intent);
            }


        });


        BottomNavigationView bottomNavigationView=findViewById(R.id.homenav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        // here we create our default fragment when the app is being started this helps
        //our screen not to remain empty onthe start of the activity

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentholder,new HomeFragment()).commit();
    }

    //Settin g searchview activity on the tool bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.toolbaritem,menu);
       // MenuItem SearchViewItem=menu.findItem(R.id.search);
       // final SearchView searchView=(SearchView) MenuItemCompat.getActionView(SearchViewItem);

        return true;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener= new
            BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment=null;

            switch (menuItem.getItemId()){
                case R.id.nav_home:
                selectedFragment=new HomeFragment();
                break;
                case R.id.people:
                    selectedFragment=new PeopleFragment();
                    break;
                case R.id.notify:
                    selectedFragment=new NotificationFragment();
                    break;
                case R.id.nav_sms:
                    selectedFragment=new MessageFragment();
                    break;
            }
            //shows the fragments when you switch on them and  shows the fragments inthe layout we want them to be shown
            //in our our case we have the frame layout and the fragment we want to show which is our "selected fragment"
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentholder,selectedFragment).commit();

            //return boolean true which means we want to select the clicked item

            return  true;
        }
    };


}
