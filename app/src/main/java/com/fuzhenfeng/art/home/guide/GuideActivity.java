package com.fuzhenfeng.art.home.guide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import com.fuzhenfeng.art.home.R;
import com.fuzhenfeng.art.home.home.HomeActivity;

public class GuideActivity extends AppCompatActivity {
    private int[] images = {
            R.drawable.guide_1_bg,
            R.drawable.guide_2_bg,
            R.drawable.guide_3_bg
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ViewPager vp_launch = findViewById(R.id.guide);
        GuideAdapter adapter = new GuideAdapter(this, images, v -> {
            Intent home =  new Intent(GuideActivity.this, HomeActivity.class);
            startActivity(home);
        });
        vp_launch.setAdapter(adapter);
        vp_launch.setCurrentItem(0);
    }
}