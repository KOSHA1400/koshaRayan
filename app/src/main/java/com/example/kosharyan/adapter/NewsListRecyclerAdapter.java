package com.example.kosharyan.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kosharyan.MainActivity;
import com.example.kosharyan.model.News;
import com.example.kosharyan.R;
import com.example.kosharyan.fragment.FragmentDetailsNews;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsListRecyclerAdapter extends RecyclerView.Adapter<NewsListRecyclerAdapter.ViewHolder> {
    ArrayList<News> news;
    Context context;
    public NewsListRecyclerAdapter(Context context , ArrayList<News> news) {
        this.news=news;
        this.context = context;
    }
    @NonNull
    @Override
    public NewsListRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);

        return new NewsListRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        News newsItem = news.get(position);
        holder.txtName.setText( newsItem.name);
        holder.txtTitel.setText("منبع :"+newsItem.titel);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Bundle bundle=new Bundle();

                bundle.putString("titel",newsItem.titel);
                bundle.putString("name",newsItem.name);
                bundle.putString("imageAddress",newsItem.image);

                FragmentDetailsNews fragmentDetailsNews =new FragmentDetailsNews();
                fragmentDetailsNews.setArguments(bundle);

                FragmentManager manager = ((MainActivity)context).getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.container,fragmentDetailsNews,null).commit();

            }
        });

        Picasso.get().load(newsItem.image).into(holder.imgNews);
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName;
        ImageView imgNews;
         TextView txtTitel;
        ViewHolder( View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.item_recycler_name_news);
            txtTitel=itemView.findViewById(R.id.item_titel);
            imgNews=itemView.findViewById(R.id.img_news);

        }
    }

}
