package com.example.kosharyan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kosharyan.R;
import com.example.kosharyan.model.eftekharat.Eftekhar;
import com.example.kosharyan.model.eftekharat.EftekharResponse;
import com.squareup.picasso.Picasso;

public class HonorsFromServerRecyclerAdapter extends RecyclerView.Adapter<HonorsFromServerRecyclerAdapter.ViewHolder> {
    EftekharResponse eftekhar;
    Context context;

    public HonorsFromServerRecyclerAdapter(Context context, EftekharResponse eftekhar){
        this.context=context;
        this.eftekhar= eftekhar;
    }
    @NonNull
    @Override
    public HonorsFromServerRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_honors, parent, false);

        return new HonorsFromServerRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HonorsFromServerRecyclerAdapter.ViewHolder holder, int position) {
       Eftekhar eftekharat =eftekhar.getEftekhar().get(position);

        eftekharat.getPic();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "افتخارات " + position, Toast.LENGTH_SHORT).show();
            }
        });
        Picasso.get().load(eftekharat.getPic()).into(holder.imghonors);
    }

    @Override
    public int getItemCount() {
        return eftekhar.getEftekhar().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imghonors;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imghonors=itemView.findViewById(R.id.img_honors);
        }
    }
}
