package com.example.hp.carfleet;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.hp.carfleet.VehiculeDetails.SectionsPagerAdapter.dpToPixels;

public class VehiculeDetails extends AppCompatActivity implements FrangmentSpecification.OnFragmentInteractionListener,
        FragmentDocument.OnFragmentInteractionListener,FragmentTache.OnFragmentInteractionListener {

    ViewPager viewPager;
    CardView cardView;

    WormDotsIndicator wormDotsIndicator;
    int[] images={R.drawable.voiture1,R.drawable.voiture2,R.drawable.voiture3};








    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicule_details);
        viewPager = (ViewPager) findViewById(R.id.vehicule_viewPager);

//        viewPager.setPageTransformer(false, fragmentCardShadowTransformer);
//        viewPager.setOffscreenPageLimit(3);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(R.string.title);
        toolbar.setSubtitle(R.string.subtitle);
        //toolbar.setLogo(R.drawable.mercedes1);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));




        wormDotsIndicator = (WormDotsIndicator) findViewById(R.id.indicator);


        wormDotsIndicator.setViewPager(viewPager);


        viewPager = (ViewPager) findViewById(R.id.vehicule_viewPager);
        cardView = (CardView) findViewById(R.id.vehicule_cardview);


        viewPager.setPageTransformer(false,new CardsPagerTransformerBasic(1,2,0.75f));
        final VehiculeAdapter myPagerAdapter = new VehiculeAdapter(VehiculeDetails.this, images);
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




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_notification) {
            return true;
        }
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }


    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public static class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = new FrangmentSpecification();
                    break;
                case 1:
                    fragment = new FragmentDocument();
                    break;
                case 2:
                    fragment = new FragmentTache();
                    break;

            }
            return fragment;
        }




        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        /**
         * Change value in dp to pixels
         * @param dp
         * @param context
         * @return
         */
        public static float dpToPixels(int dp, Context context) {
            return dp * (context.getResources().getDisplayMetrics().density);
        }
    }


}
