package com.example.kosharyan.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kosharyan.R;


public class FragmentCode extends Fragment {
CardView code;
TextView code_r;
    TextView state;


    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_code, container, false);
       code=view.findViewById(R.id.card_massage_code);
       code_r=view.findViewById(R.id.frg_code_txt_code_r);
       state=view.findViewById(R.id.frg_code_txt_stat);
        Bundle bundle =new Bundle();
        bundle = getArguments();

if(bundle!=null) {
    code_r.setText("کد رهگیری شما :" + bundle.getString("code"));
    state.setText("وضعیت پاسخ به پرسش شما:" + bundle.getString("status"));
}



   return view;
    }
}