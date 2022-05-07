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
import com.example.kosharyan.fragment.FragmentDetails;
import com.example.kosharyan.model.Mahsolat.Product;
import com.example.kosharyan.model.Mahsolat.ProductResponse;
import com.squareup.picasso.Picasso;

public class ProductFromServerRecyclerAdapter extends RecyclerView.Adapter<ProductFromServerRecyclerAdapter.ViewHolder> {
    ProductResponse product;
    Context context;
    public ProductFromServerRecyclerAdapter(Context context, ProductResponse products){
        this.context=context;
        this.product=products;
    }

    @NonNull
    @Override
    public ProductFromServerRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductFromServerRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductFromServerRecyclerAdapter.ViewHolder holder, int position) {

        Product products=product.getProducts().get(position);
        holder.txtTitel.setText("نام :"+products.getTitle());
        holder.txtDesc.setText("توضیحات:"+products.getBody());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();

                bundle.putString("titel",products.getTitle());
                bundle.putString("desc",products.getBody());
                bundle.putString("imageAddress",products.getPic());

                FragmentDetails fragmentDetails =new FragmentDetails();
                fragmentDetails.setArguments(bundle);

                FragmentManager manager = ((MainActivity)context).getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.container,fragmentDetails,null).commit();
            }
        });
        Picasso.get().load(products.getPic()).into(holder.imgProduct);
    }

    @Override
    public int getItemCount() {

        return product.getProducts().size();
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
