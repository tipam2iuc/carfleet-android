package com.example.hp.carfleet;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;


public class Drawer extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    TabLayout tabLayout;
    ViewPager viewPager;
    PageAdapter pageAdapter;
    TabItem tabAll;
    TabItem tabCategory;
    TabItem tabAvailable;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new FragmentVehicule()).commit();
            navigationView.setCheckedItem(R.id.nav_vehicule);
        }


        tabLayout=findViewById(R.id.tabLayout);
        tabAll=findViewById(R.id.tabAll);
        tabCategory=findViewById(R.id.tabCategory);
        tabAvailable=findViewById(R.id.tabAvailable);
        viewPager = findViewById(R.id.viewPager);
        fab=findViewById(R.id.fab);

        pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0){
                    toolbar.setBackgroundColor(ContextCompat.getColor(Drawer.this,
                            R.color.blue_overlay));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(Drawer.this,
                            R.color.blue_overlay));

                    if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
                        getWindow().setStatusBarColor(ContextCompat.getColor(Drawer.this,
                                R.color.blue_overlay));
                    }
                }else if (tab.getPosition()==1){
                    toolbar.setBackgroundColor(ContextCompat.getColor(Drawer.this,
                            R.color.blue_overlay));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(Drawer.this,
                            R.color.blue_overlay));

                    if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
                        getWindow().setStatusBarColor(ContextCompat.getColor(Drawer.this,
                                R.color.blue_overlay));
                    }

                }else {
                    toolbar.setBackgroundColor(ContextCompat.getColor(Drawer.this,
                            R.color.blue_overlay));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(Drawer.this,
                            R.color.blue_overlay));
                    if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
                        getWindow().setStatusBarColor(ContextCompat.getColor(Drawer.this,
                                R.color.blue_overlay));
                    }
                }
            }



            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_vehicule:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentVehicule()).commit();
                break;
            case R.id.nav_document:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentDocument()).commit();
                break;
            case R.id.nav_parking:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentParking()).commit();
                break;
            case R.id.nav_maintenance:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentMaintenance()).commit();
                break;
            case R.id.nav_driver:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentDriver()).commit();
                break;

            case R.id.nav_logout:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentCompte()).commit();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;


    }
}


