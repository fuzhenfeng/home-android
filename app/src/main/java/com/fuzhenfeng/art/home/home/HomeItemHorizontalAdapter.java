package com.fuzhenfeng.art.home.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fuzhenfeng.art.home.R;

import java.util.ArrayList;

public class HomeItemHorizontalAdapter extends RecyclerView.Adapter<HomeItemHorizontalAdapter.HomeActivityViewHolder> {

  private Context context;
  private final LayoutInflater layoutInflater;
  private ArrayList<String> pages = new ArrayList<>();

  public void setPages(ArrayList<String> pages) {
    this.pages = pages;
    notifyDataSetChanged();
  }

  public HomeItemHorizontalAdapter(Context context) {
    this.context = context;
    layoutInflater = LayoutInflater.from(context);
  }

  @Override
  public HomeActivityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new HomeActivityViewHolder(layoutInflater.inflate(R.layout.home_item_horizontal, parent, false));
  }

  @Override
  public void onBindViewHolder(HomeActivityViewHolder holder, int position) {
    ImageView imageView = holder.imageView;
    Glide.with(context)
            .load(pages.get(position))
            .into(imageView);
  }

  @Override
  public int getItemCount() {
    return null == pages ? 0 : pages.size();
  }

  public class HomeActivityViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;

    public HomeActivityViewHolder(View itemView) {
      super(itemView);
      imageView = itemView.findViewById(R.id.imageView);
    }
  }

}
