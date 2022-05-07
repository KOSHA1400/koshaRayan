package com.example.kosharyan.fragment;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kosharyan.R;
import com.example.kosharyan.api.ApiClient;
import com.example.kosharyan.api.ApiInterface;
import com.example.kosharyan.model.member.MemberResponse;
import com.example.kosharyan.model.tamasbama.TamasbamaResponse;
import com.example.kosharyan.util.Util;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentCall extends Fragment {
CardView call,email,addres,whatsapp,contactus;
ImageView whatesapp,telegram,instagram;
TextView emaill,calll,adress,moshaverh;
    ApiInterface request;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_call, container, false);
        call=view.findViewById(R.id.fragment_call_call);
        emaill=view.findViewById(R.id.email);
       calll=view.findViewById(R.id.call);
        adress=view.findViewById(R.id.map);
        moshaverh=view.findViewById(R.id.moshaver);
        email=view.findViewById(R.id.fragment_call_email);
        addres=view.findViewById(R.id.fragment_call_addres);
       // whatsapp=view.findViewById(R.id.fragment_call_whatsapp);
        contactus =view.findViewById(R.id.fragment_call_contactus);
        whatesapp=view.findViewById(R.id.frg_call_whatsapp);
        telegram=view.findViewById(R.id.frg_call_telegram);
       instagram=view.findViewById(R.id.frg_call_instagram);

        contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               Util.goToFragment(new FragmentContactUs(),requireActivity());


            }
        });
      //  telegram.setOnClickListener(new View.OnClickListener() {
         //   @Override
          //  public void onClick(View v) {
               // Intent telegram = new Intent(android.content.Intent.ACTION_SEND);
              //  telegram.setData(Uri.parse("http://telegram.me/myId"));
              //  telegram.setPackage("org.telegram.messenger");
               // Test.this.startActivity(Intent.createChooser(telegram, "Share with"));
        ///    }//
      //  });

        whatesapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                sendIntent.setType("text/plain");
                sendIntent.setPackage("com.whatsapp");
                startActivity(Intent.createChooser(sendIntent, ""));
                startActivity(sendIntent);
            }
        });
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://instagram.com/_u/xxx");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                likeIng.setPackage("com.instagram.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/xxx")));
                }
            }
        });
         telegram.setOnClickListener(new View.OnClickListener() {
          @Override
         public void onClick(View v) {
         Intent telegram = new Intent(android.content.Intent.ACTION_SEND);
          telegram.setData(Uri.parse("http://telegram.com"));
          telegram.setPackage("telegram.com");
          startActivity(Intent.createChooser(telegram, "Share with"));
          }
         });
        getTamasFromServer();
        return view;
    }
    void getTamasFromServer(){

        request= ApiClient.getRetrofit().create(ApiInterface.class);

        request.getTamasFromServer().enqueue(new Callback<TamasbamaResponse>() {
            @Override
            public void onResponse(Call<TamasbamaResponse> call, Response<TamasbamaResponse> response) {
                try {
                    if (response.isSuccessful()){




                   emaill.setText("ایمیل :"+response.body().getTamas().getEmail());
                       calll.setText("شماره:"+response.body().getTamas().getMobail());
                       adress.setText(response.body().getTamas().getAddress());



                    }else {

                        Log.i("kk","respone is not success ");
                    }
                }catch (Exception e){
                    Log.i("kk",e.getMessage());

                }


            }

            @Override
            public void onFailure(Call<TamasbamaResponse> call, Throwable t) {

            }
        });


    }

}