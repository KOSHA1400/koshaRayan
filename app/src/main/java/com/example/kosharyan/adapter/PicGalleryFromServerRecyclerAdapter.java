package com.example.kosharyan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kosharyan.R;
import com.example.kosharyan.model.gallery.PicResponse;
import com.example.kosharyan.util.Util;
import com.squareup.picasso.Picasso;

public class PicGalleryFromServerRecyclerAdapter extends RecyclerView.Adapter<PicGalleryFromServerRecyclerAdapter.ViewHolder> {
    PicResponse pic;
    Context context;

    public PicGalleryFromServerRecyclerAdapter(Context context , PicResponse pics){
        this.pic =pics;
        this.context=context;

    }


    @NonNull
    @Override
    public PicGalleryFromServerRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_costomer, parent, false);

        return new PicGalleryFromServerRecyclerAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull PicGalleryFromServerRecyclerAdapter.ViewHolder holder, int position) {

      //  Object pics =object.getObject().get(position);


        // holder.txtTitel.setText("عنوان :"+costomer.titel);
        //holder.txtDesc.setText("توضیحات :"+costomer.description);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(context,"click item "+position,Toast.LENGTH_SHORT).show();
                Util.showToast(context,"click item "+position);
            }
        });

     //  Picasso.get().load(pics.getPic()).into(holder.imgCostomer);


    }

    @Override
    public int getItemCount() {
        return pic.getPics().size();
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

