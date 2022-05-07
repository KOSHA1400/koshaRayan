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


public class FragmentDetailsNews extends Fragment {
    TextView txtTitle ,txtName;

    ImageView imageView;



    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_details_news, container, false);
        txtTitle =view.findViewById(R.id.fragmentDetailsNews_titel);
        txtName=view.findViewById(R.id.fragmentDetailsNews_name);
        imageView=view.findViewById(R.id.fragmentDetailsNews_img);
        Bundle bundle =getArguments();

        if (bundle!=null){//اینو نوشتم اگر باندل خالی بود کرش نکنه
            txtTitle.setText(bundle.getString("titel","خالی"));
            txtName.setText(bundle.getString("disc","خالی"));
            GlideApp.with(requireActivity()).load(bundle.getString("pic")).into(imageView);
        }
        return view;
    }
}