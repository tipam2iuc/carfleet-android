package com.example.hp.carfleet;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.view.View;

public class CardsPagerTransformerBasic implements ViewPager.PageTransformer {
    private int baseElevation;
    private int raisingElevation;
    private float smallerScale;

    public CardsPagerTransformerBasic(int baseElevation, int raisingElevation, float smallerScale) {
        this.baseElevation = baseElevation;
        this.raisingElevation = raisingElevation;
        this.smallerScale = smallerScale;
    }

    @Override
    public void transformPage(View page, float position) {

        float absPosition = Math.abs(position);

        if (absPosition >= 1) {
            page.setElevation(baseElevation);
            page.setScaleY(smallerScale);
        } else {
            // This will be during transformation
            page.setElevation(((1 - absPosition) * raisingElevation + baseElevation));
            page.setScaleY((smallerScale - 1) * absPosition + 1);

        }

    }



}
