package com.example.hp.carfleet;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.hp.carfleet.MainActivity;

public class MyPageAdapter extends PagerAdapter {

    Context context;
    int images[];
    int pagination[];
    String title[];
    String description[];
    int button_height[];
    int button_width[];
    LayoutInflater layoutInflater;


    public MyPageAdapter(Context context, int images[],String title[],String description[],int button_height[],int button_width[]) {
        this.context = context;
        this.images = images;

        this.title=title;
        this.description=description;
        this.button_height=button_height;
        this.button_width=button_width;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == ((LinearLayout) o);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View itemView = layoutInflater.inflate(R.layout.fragment_onboarding_1, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.image);
        TextView title = (TextView) itemView.findViewById(R.id.title);
        TextView description = (TextView) itemView.findViewById(R.id.description);
        Button start=(Button) itemView.findViewById(R.id.button);


        switch (position)
        {
            case 2:
                start.setVisibility(View.VISIBLE);
                start.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(v.getContext(),MainActivity_sign.class);
                        v.getContext().startActivity(intent);

                    }
                });
        }



        imageView.setImageResource(this.images[position]);

        title.setText(this.title[position]);
        description.setText(this.description[position]);


        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
