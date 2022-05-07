package com.example.kosharyan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kosharyan.model.Costomer;
import com.example.kosharyan.R;
import com.example.kosharyan.util.Util;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CostomerRecyclerAdapter extends RecyclerView.Adapter<CostomerRecyclerAdapter.ViewHolder> {
    ArrayList<Costomer> costomers;
    Context context;

    public CostomerRecyclerAdapter(Context context , ArrayList<Costomer> costomers){
        this.costomers=costomers;
        this.context=context;

    }
    @NonNull
    @Override
    public CostomerRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_costomer, parent, false);

        return new ViewHolder(view);
        
    }

    @Override
    public void onBindViewHolder(@NonNull CostomerRecyclerAdapter.ViewHolder holder, int position) {

        Costomer costomer =costomers.get(position);
        //holder.txtTitel.setText("عنوان :"+costomer.titel);
        //holder.txtDesc.setText("توضیحات :"+costomer.description);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(context,"click item "+position,Toast.LENGTH_SHORT).show();
                Util.showToast(context,"click item "+position);
            }
        });

        Picasso.get().load(costomer.image).into(holder.imgCostomer);


    }

    @Override
    public int getItemCount() {
        return costomers.size();
    }
    // stores and recycles views as they are scrolled off screen
    public static class ViewHolder extends RecyclerView.ViewHolder {
      //  TextView txtTitel;
      //  TextView txtDesc;
        ImageView imgCostomer;


        ViewHolder(View itemView) {
            super(itemView);
           // txtTitel = itemView.findViewById(R.id.item_recycler_txt_titel);
          //  txtDesc = itemView.findViewById(R.id.item_recycler_txt_desc);
            imgCostomer=itemView.findViewById(R.id.img_costomer);
        }
    }
}