package com.example.kosharyan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kosharyan.model.Honors;
import com.example.kosharyan.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HonorsRecyclerAdapter extends RecyclerView.Adapter<HonorsRecyclerAdapter .ViewHolder> {
    ArrayList<Honors>honors;
    Context context;

    public  HonorsRecyclerAdapter(Context context, ArrayList<Honors>honors){
        this.context=context;
        this.honors=honors;
    }
    @NonNull
    @Override
    public HonorsRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_honors, parent, false);

        return new HonorsRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HonorsRecyclerAdapter.ViewHolder holder, int position) {
        Honors honorsItem = honors.get(position);

        holder.imghonors.setImageDrawable(context.getResources().getDrawable(honorsItem.image));

      holder.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Toast.makeText(context, "افتخارات " + position, Toast.LENGTH_SHORT).show();
          }
      });
        Picasso.get().load(honorsItem.image).into(holder.imghonors);
        }

    @Override
    public int getItemCount() {
        return honors.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imghonors;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imghonors=itemView.findViewById(R.id.img_honors);
        }
    }
}
