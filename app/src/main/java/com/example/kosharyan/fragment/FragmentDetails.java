package com.example.kosharyan.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kosharyan.GlideApp;
import com.example.kosharyan.R;

public class FragmentDetails extends Fragment {


   TextView txtTitle ,txDesc;

   ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_details, container, false);

       txtTitle =view.findViewById(R.id.fragmentdetails_titel);
        txDesc=view.findViewById(R.id.fragmentDetails_desc);
        imageView=view.findViewById(R.id.fragmentdetails_img);

        Bundle bundle =getArguments();

        if (bundle!=null){//اینو نوشتم اگر باندل خالی بود کرش نکنه
            txtTitle.setText(bundle.getString("titel","خالی"));
            txDesc.setText(bundle.getString("desc","خالی"));
            GlideApp.with(requireActivity()).load(bundle.getString("imageAddress")).into(imageView);
        }



        return view;
    }
}