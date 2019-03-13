package com.example.hp.carfleet;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    Button button;
    Button button1;

    WormDotsIndicator wormDotsIndicator;


    int images[] = {R.drawable.par, R.drawable.driver, R.drawable.document};
    String title[] = {"Car management", "Driver management", "Document management"};
    String description[] = {"Les différents véhicule sont gerés avec éfficacité dans chaque paarking",
            "Les conducteurs de chaque véhicule sont identifiés",
            "Chaque document est archivé et garder en toute sécurité"};
    int button_width[] = {0, 0, 35};
    int button_height[] = {0, 0, 15};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.activity_main_viewpager);
        wormDotsIndicator = (WormDotsIndicator) findViewById(R.id.worm_dots_indicator);


        final MyPageAdapter myPagerAdapter = new MyPageAdapter(MainActivity.this, images, title, description, button_height, button_width);
        viewPager.setAdapter(myPagerAdapter);

        wormDotsIndicator.setViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                if (i < (myPagerAdapter.getCount()) - 1 && i < (images.length - 1)) {

                }
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }
}
