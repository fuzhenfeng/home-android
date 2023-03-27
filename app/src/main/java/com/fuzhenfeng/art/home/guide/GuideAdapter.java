package com.fuzhenfeng.art.home.guide;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.viewpager.widget.PagerAdapter;

import com.fuzhenfeng.art.home.R;

import java.util.ArrayList;

public final class GuideAdapter extends PagerAdapter {
    private ArrayList<View> views = new ArrayList<>();

    public GuideAdapter(Context context, int[] imageArray, View.OnClickListener onClickListener) {
        for (int i = 0; i < imageArray.length; i++) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_guide, null);
            ImageView iv_launch = view.findViewById(R.id.iv_launch);
            RadioGroup rg_indicate = view.findViewById(R.id.rg_indicate);
            Button btn_start = view.findViewById(R.id.btn_start);
            iv_launch.setImageResource(imageArray[i]);
            for (int j = 0; j < imageArray.length; j++) {
                RadioButton radio = new RadioButton(context);
                radio.setLayoutParams
                        (new ViewGroup.LayoutParams
                                (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                radio.setButtonDrawable(R.drawable.launch_guide);
                radio.setPadding(10, 10, 10, 10);
                rg_indicate.addView(radio);
            }
            ((RadioButton) rg_indicate.getChildAt(i)).setChecked(true);
            if (i == imageArray.length - 1) {
                btn_start.setVisibility(View.VISIBLE);
                btn_start.setOnClickListener(onClickListener);
            }
            views.add(view);
        }
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(views.get(position));
        return views.get(position);
    }
}