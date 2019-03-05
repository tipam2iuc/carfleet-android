package com.example.hp.carfleet;


import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;


public class Drawer extends AppCompatActivity {
    //private DrawerLayout mDrawerLayout;
// private ActionBarDrawerToggle mToggle;

    // FirebaseAuth mAuth;
    // String curent_user_id;
    // private Button signout;
//firebase


//fin firebase

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);


        /*f(curent_user_id==null){
            startActivity(new Intent(Drawer.this,SignIn.class));
            finish();
        }



        //firebase
        signout = (Button) findViewById(R.id.button_logout);
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                startActivity(new Intent(Drawer.this,SignIn.class));
                finish();
            }
        });


        mDrawerLayout=(DrawerLayout) findViewById(R.id.drawer);

        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    if(mToggle.onOptionsItemSelected(item)) {

        return true;
    }

        return super.onOptionsItemSelected(item);
    }*/
    }
}
