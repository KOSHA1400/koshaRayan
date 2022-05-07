package com.example.kosharyan.fragment;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kosharyan.model.Honors;
import com.example.kosharyan.adapter.HonorsRecyclerAdapter;
import com.example.kosharyan.adapter.NewsListRecyclerAdapter;
import com.example.kosharyan.R;
import com.example.kosharyan.util.Util;

import java.util.ArrayList;


public class FragmentAboutUs extends Fragment {


   // RecyclerView recyclerView3;
   NewsListRecyclerAdapter adapter3;



RecyclerView honorsRecyclerAdapter;
   HonorsRecyclerAdapter honorsRecyclerAdapter1;
   CardView ghavanin,honors,album,member,qustion;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about_us, container, false);
        ghavanin=view.findViewById(R.id.frg_about_ghavanin);
        honors=view.findViewById(R.id.frg_about_honoers);
        album=view.findViewById(R.id.frg_about_albumpic);
        qustion=view.findViewById(R.id.frg_about_qustion);





        qustion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Util.goToFragment(new FragmentQuestion() ,requireActivity());
            }
        });
       member=view.findViewById(R.id.frg_about_members_company);
        ghavanin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Util.goToFragment(new FragmentGhavanin() ,requireActivity());
            }
        });
       honors.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Util.goToFragment(new FragmentHonoresCompany(),requireActivity());
           }
       });
       album.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Util.goToFragment(new FragmentAlbum(),requireActivity());
           }
       });
       member.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Util.goToFragment(new FragmentMemberCompany(),requireActivity());
           }
       });

       // honorsRecyclerAdapter=view.findViewById(R.id.recycler_honors);
      //  recyclerView3 = view.findViewById(R.id.recycler_member);


     /*
        */

      //  setupRecyclerHonors();
        return view;
    }





    void setupRecyclerHonors() {

        ArrayList<Honors>honors= new ArrayList<>();



        Honors honors1 = new Honors(R.drawable.pictuer);
      Honors honors2 = new Honors(R.drawable.pic);
        Honors honors3 = new Honors(R.drawable.honor);
        Honors honors4 = new Honors(R.drawable.honors);

     /*  honors.add(honors1);
       honors.add(honors2);
       honors.add(honors3);
       honors.add(honors4);*/

        honorsRecyclerAdapter1 = new HonorsRecyclerAdapter(requireActivity(),honors);


        LinearLayoutManager layoutManager = new LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false);

       honorsRecyclerAdapter.setLayoutManager(layoutManager);
        honorsRecyclerAdapter.setAdapter(honorsRecyclerAdapter1);


    }

}