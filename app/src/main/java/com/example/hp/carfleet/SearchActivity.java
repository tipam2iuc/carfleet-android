package com.example.hp.carfleet;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    private ArrayList<Search> searchOptions=new ArrayList<Search>();
    private FloatingActionButton mFloatingActionButton;


    private SearchActivity.OnFragmentInteractionListener listener;

    public interface OnFragmentInteractionListener {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mFloatingActionButton=findViewById(R.id.fab);
        Toolbar mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle(R.string.app_name);
        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(SearchActivity.this,
                LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setHasFixedSize(true);


        Search s0 = new Search( "Tous  les modeles de Voitures ",(R.drawable.carmultiple)
        );
        searchOptions.add(s0);
        Search s20 = new Search( "Les plus demandés",(R.drawable.sort)
        );
        searchOptions.add(s20);
        Search s1 = new Search( "Europe:Coupés sportifs SUV MP...",(R.drawable.sort)
        );
        searchOptions.add(s1);

        Search s2 = new Search( "Essence,Gazole, Hybride,Electriq...",(R.drawable.gasstation)
        );
        searchOptions.add(s2);

        Search s3 = new Search( "Boite de vitesse manuelle",(R.drawable.speedometer)
        );
        searchOptions.add(s3);

        Search s4 = new Search( "Siege tissus(de 2 a 19 places)",(R.drawable.seat)
        );
        searchOptions.add(s4);

        Search s5 = new Search( "Porte de 0 a 5",(R.drawable.cardoor)
        );

        Search s6 = new Search( "Boite de vitesse manuelle",(R.drawable.speedometer)
        );
        searchOptions.add(s6);

        Search s7 = new Search( "Siege tissus(de 2 a 19 places)",(R.drawable.seat)
        );
        searchOptions.add(s7);

        Search s8 = new Search( "Porte de 0 a 5",(R.drawable.cardoor)

        );
        searchOptions.add(s8);

        searchOptions.add(s5);
        SearchAdapter mMailAdapter = new SearchAdapter(SearchActivity.this, CommonSearch.AddSpace(searchOptions),new SearchAdapter.OnItemClickListener() {
            @Override public void onItemClick(Search item) {
                Intent intent = new Intent(SearchActivity.this, ModelListActivity.class);
                startActivity(intent);
            }
        });
        mRecyclerView.setAdapter(mMailAdapter);
        mMailAdapter.notifyDataSetChanged();

       /* if (mRecyclerView.getChildCount()==2)
        {

        }
        else
        {
            mRecyclerView.addItemDecoration(new DividerItemDecoration(SearchActivity.this,
                    DividerItemDecoration.VERTICAL));
        }*/


        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0 && mFloatingActionButton.getVisibility() == View.VISIBLE   ) {
                    mFloatingActionButton.hide();
                    // btnReset.setVisibility(View.GONE);
                } else if (dy < 0 && mFloatingActionButton.getVisibility() != View.VISIBLE ) {
                    mFloatingActionButton.show();
                    // btnReset.VISIBLE(View.NON);

                }
            }
        });
    }


}
