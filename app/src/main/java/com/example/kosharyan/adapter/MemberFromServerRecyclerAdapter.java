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
import com.example.kosharyan.model.member.Member;
import com.example.kosharyan.model.member.MemberResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MemberFromServerRecyclerAdapter extends  RecyclerView.Adapter<MemberFromServerRecyclerAdapter .ViewHolder>{
    MemberResponse member;
    Context context;
    public MemberFromServerRecyclerAdapter(Context context,MemberResponse members){
        this.context=context;
        this.member=members;
    }
    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_about, parent, false);

        return new MemberFromServerRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Member members = member.getMember().get(position);
       holder.txtName.setText(members.getName());
      holder.txtTitel.setText(members.getBody());

       // holder.txtTitel.setText("معرفی :"+aboutItem.titel);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Toast.makeText(context, "اعضای شرکت " + position, Toast.LENGTH_SHORT).show();
            }
        });

        Picasso.get().load(members.getPic()).into(holder.imgmember);
    }




    @Override
    public int getItemCount() {
        return member.getMember().size();
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
