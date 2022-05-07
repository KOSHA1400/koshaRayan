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
import com.example.kosharyan.R;
import com.example.kosharyan.fragment.FragmentDetailsNews;
import com.example.kosharyan.model.home.Customer;
import com.example.kosharyan.model.home.CustomerResponse;
import com.example.kosharyan.model.news.News;
import com.example.kosharyan.model.news.NewsResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsListFromServerRecyclerAdapter extends RecyclerView.Adapter<NewsListFromServerRecyclerAdapter.ViewHolder> {
   NewsResponse news;
    Context context;
    public NewsListFromServerRecyclerAdapter(Context context , NewsResponse news) {
        this.news=news;
        this.context = context;
    }
    @NonNull
    @Override
    public NewsListFromServerRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);

        return new NewsListFromServerRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       News newses =news.getNews().get(position);

      holder.txtTitel.setText( newses.getBody());

       holder.txtName.setText(newses.getTitle());

      //  holder.txtName.setText( new);
      //  holder.txtTitel.setText("منبع :"+news.titel);
      holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Bundle bundle=new Bundle();

                bundle.putString("titel",newses.getTitle());
                bundle.putString("disc",newses.getBody());
                bundle.putString("image",newses.getPic());

                FragmentDetailsNews fragmentDetailsNews =new FragmentDetailsNews();
                fragmentDetailsNews.setArguments(bundle);

                FragmentManager manager = ((MainActivity)context).getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.container,fragmentDetailsNews,null).commit();

            }
        });

        Picasso.get().load(newses.getPic()).into(holder.imgNews);
    }

    @Override
    public int getItemCount() {
        return news.getNews().size();
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
