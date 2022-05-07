package com.example.kosharyan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kosharyan.R;
import com.example.kosharyan.model.news.NewsResponse;
import com.example.kosharyan.model.news.Newscat;

public class CategoryFromServerRecyclerAdapter extends RecyclerView.Adapter<CategoryFromServerRecyclerAdapter.ViewHolder> {
    NewsResponse newsResponse;
    Context context;

    public CategoryFromServerRecyclerAdapter(NewsResponse categories, Context context){
        this.newsResponse =categories;
        this.context=context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);

        return new CategoryFromServerRecyclerAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       Newscat categories = newsResponse.getNewscat().get(position);

       holder.txtCategory.setText(categories.getTitle());


    }

    @Override
    public int getItemCount() {
        return newsResponse.getNewscat().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtCategory;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCategory = itemView.findViewById(R.id.category);
        }
    }

}
