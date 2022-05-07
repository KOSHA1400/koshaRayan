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
import com.example.kosharyan.model.Product;
import com.example.kosharyan.R;
import com.example.kosharyan.fragment.FragmentDetails;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductsRecyclerAdapter extends RecyclerView.Adapter<ProductsRecyclerAdapter.ViewHolder> {
    ArrayList<Product> product;
    Context context;
    public ProductsRecyclerAdapter(Context context, ArrayList<Product> product){
        this.context=context;
        this.product=product;
    }

    @NonNull
    @Override
    public ProductsRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductsRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsRecyclerAdapter.ViewHolder holder, int position) {

Product products=product.get(position);
holder.txtTitel.setText("نام :"+products.titel);
        holder.txtDesc.setText("توضیحات:"+products.desc);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();

                bundle.putString("titel",products.titel);
                bundle.putString("desc",products.desc);
                bundle.putString("imageAddress",products.image);

                FragmentDetails fragmentDetails =new FragmentDetails();
                fragmentDetails.setArguments(bundle);

                FragmentManager manager = ((MainActivity)context).getSupportFragmentManager();
             manager.beginTransaction().replace(R.id.container,fragmentDetails,null).commit();
            }
        });
        Picasso.get().load(products.image).into(holder.imgProduct);
    }

    @Override
    public int getItemCount() {

            return product.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgProduct;
         TextView txtTitel;
         TextView txtDesc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduct=itemView.findViewById(R.id.img_product);
            txtTitel=itemView.findViewById(R.id.txt_name_product);
            txtDesc=itemView.findViewById(R.id.txt_desc_product);

        }
    }
}
