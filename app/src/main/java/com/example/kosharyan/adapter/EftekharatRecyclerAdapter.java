package com.example.kosharyan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kosharyan.R;
import com.example.kosharyan.model.Eftekharat;
import com.example.kosharyan.model.eftekharat.Eftekhar;
import com.example.kosharyan.model.eftekharat.EftekharResponse;
import com.example.kosharyan.model.news.News;
import com.example.kosharyan.util.Util;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class EftekharatRecyclerAdapter extends RecyclerView.Adapter<EftekharatRecyclerAdapter.ViewHolder> {
    EftekharResponse eftekhar;
    Context context;
    public EftekharatRecyclerAdapter(Context context, EftekharResponse eftekhar){
     this.context=context;
     this.eftekhar=eftekhar;
    }
    @NonNull
    @Override
    public EftekharatRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_eftekharat, parent, false);

        return new  EftekharatRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EftekharatRecyclerAdapter.ViewHolder holder, int position) {
       Eftekhar eftekharat =eftekhar.getEftekhar().get(position);
        holder.txtName.setText( eftekharat.getTitle());
        holder.txtDesc.setText( eftekharat.getBody());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(context,"click item "+position,Toast.LENGTH_SHORT).show();
                Util.showToast(context,"click item "+position);
            }
        });

        Picasso.get().load(eftekharat.getPic()).into(holder.imgEftekharat);
    }

    @Override
    public int getItemCount() {
        return eftekhar.getEftekhar().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         TextView txtName;
          TextView txtDesc;
        ImageView imgEftekharat;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
