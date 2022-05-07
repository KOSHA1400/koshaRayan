package com.example.kosharyan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kosharyan.model.LessonTitel;
import com.example.kosharyan.R;

import java.util.ArrayList;

public class TakhasosRecyclerAdapter extends RecyclerView.Adapter<TakhasosRecyclerAdapter.ViewHolder> {
        ArrayList<LessonTitel> lessonTitels;
        Context context;

    public TakhasosRecyclerAdapter(Context context , ArrayList<LessonTitel>lessonTitels) {
        this.lessonTitels = lessonTitels;
        this.context = context;
    }
    @NonNull
    @Override
    public TakhasosRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_takhasos, parent, false);

        return new TakhasosRecyclerAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull TakhasosRecyclerAdapter.ViewHolder holder, int position) {
        LessonTitel lessonTitel = lessonTitels.get(position);
        holder.txtCaption.setText(lessonTitel.caption);
       // holder.itemView.setOnClickListener(new View.OnClickListener() {
        //    @Override
          //  public void onClick(View v) {
               // Toast.makeText(context, "click item " + position, Toast.LENGTH_SHORT).show();
           // }
      //  });

    }

    @Override
    public int getItemCount() {
        return lessonTitels.size();
    }
    // stores and recycles views as they are scrolled off screen
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtCaption;



        ViewHolder(View itemView) {
            super(itemView);
            txtCaption = itemView.findViewById(R.id.item_recycler_txt_takhasos);

        }
    }

}
