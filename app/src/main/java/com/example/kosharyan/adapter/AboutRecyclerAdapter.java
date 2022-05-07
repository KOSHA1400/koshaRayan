package com.example.kosharyan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kosharyan.model.About;
import com.example.kosharyan.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AboutRecyclerAdapter extends  RecyclerView.Adapter<AboutRecyclerAdapter .ViewHolder>{
    ArrayList<About> abouts;
    Context context;
    public  AboutRecyclerAdapter(Context context, ArrayList<About>abouts){
        this.context=context;
        this.abouts=abouts;
    }
    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_about, parent, false);

        return new AboutRecyclerAdapter .ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       About aboutItem = abouts.get(position);
        holder.txtName.setText( aboutItem.name);
        holder.txtTitel.setText("معرفی :"+aboutItem.titel);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Toast.makeText(context, "اعضای شرکت " + position, Toast.LENGTH_SHORT).show();
            }
        });

        Picasso.get().load(aboutItem.image).into(holder.imgmember);
    }




    @Override
    public int getItemCount() {
        return abouts.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName;
        ImageView imgmember;
        TextView txtTitel;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.about_item_caption);
            txtTitel=itemView.findViewById(R.id.about_item_titel);
            imgmember=itemView.findViewById(R.id.img_member);
        }
    }
}
