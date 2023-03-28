package com.fuzhenfeng.art.home.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fuzhenfeng.art.home.R;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  public static final int HORIZONTAL = 1;
  public static final int VERTICAL = 2;

  private Context context;

  public HomeAdapter(Context context) {
    this.context = context;
  }

  @Override
  public int getItemViewType(int position) {
    if (position == HORIZONTAL) {
      return HORIZONTAL;
    } else {
      return VERTICAL;
    }
  }

  @Override
  public int getItemCount() {
    return 2;
  }

  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    switch (viewType) {
      case HORIZONTAL:
        return new Item1(inflater.inflate(R.layout.home_type1, parent, false));
      case VERTICAL:
        return new Item2(inflater.inflate(R.layout.home_type2, parent, false));
      default:
        return null;
    }
  }

  @Override
  public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {
    if (viewHolder instanceof Item1) {
      Item1 holder = (Item1) viewHolder;
      RecyclerView recyclerview = holder.recyclerView;
      recyclerview.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
      recyclerview.setHasFixedSize(true);
      HomeItemAdapter adapter = new HomeItemAdapter(context);
      recyclerview.setAdapter(adapter);
      ArrayList<String> pages = new ArrayList<>();
      pages.add("https://pic3.zhimg.com/80/v2-5faa2ffcac1992a2663c8746abbde9ae_hd.jpg");
      pages.add("https://pic1.zhimg.com/80/v2-78b72fb37fbcd6224940b7f15d76ef64_hd.jpg");
      pages.add("https://pic4.zhimg.com/80/v2-84c93abead7d8744422af35167aeeb2b_hd.jpg");
      adapter.setPages(pages);
      return;
    }
    if (viewHolder instanceof Item2) {
      Item2 holder = (Item2) viewHolder;
      RecyclerView recyclerview = holder.recyclerView;
      recyclerview.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
      recyclerview.setHasFixedSize(true);

      HomeItemAdapter adapter = new HomeItemAdapter(context);
      recyclerview.setAdapter(adapter);
      ArrayList<String> pages = new ArrayList<>();
      pages.add("https://pic3.zhimg.com/80/v2-5faa2ffcac1992a2663c8746abbde9ae_hd.jpg");
      pages.add("https://pic1.zhimg.com/80/v2-78b72fb37fbcd6224940b7f15d76ef64_hd.jpg");
      pages.add("https://pic4.zhimg.com/80/v2-84c93abead7d8744422af35167aeeb2b_hd.jpg");
      adapter.setPages(pages);
      return;
    }
  }

  public class Item1 extends RecyclerView.ViewHolder {
    RecyclerView recyclerView;

    public Item1(View itemView) {
      super(itemView);
      recyclerView = itemView.findViewById(R.id.recyclerview1);

    }
  }

  public class Item2 extends RecyclerView.ViewHolder {
    RecyclerView recyclerView;

    public Item2(View itemView) {
      super(itemView);
      recyclerView = itemView.findViewById(R.id.recyclerview2);
    }
  }


}
