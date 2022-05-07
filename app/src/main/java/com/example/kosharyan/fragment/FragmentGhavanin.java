package com.example.kosharyan.fragment;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.TextView;

import com.example.kosharyan.R;
import com.example.kosharyan.adapter.MemberFromServerRecyclerAdapter;
import com.example.kosharyan.api.ApiClient;
import com.example.kosharyan.api.ApiInterface;
import com.example.kosharyan.model.ghavanin.GhavaninResponse;
import com.example.kosharyan.model.member.MemberResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.view.View.GONE;
import static android.view.View.generateViewId;


public class FragmentGhavanin extends Fragment {
    TextView txtPrivacyDescription,txtItemDesc,txtItemCopy,txtItemShoping,txtItemKhalaf,txtItemContext;
     TextView txtCopyDescription;
     TextView txtContextDescription;
      TextView txtShoppingDescription,txtKhalafDescription;
    CardView cardView,copy,shopping,context,khalaf;

    ApiInterface request;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view=  inflater.inflate(R.layout.fragment_ghavanin, container, false);
        txtPrivacyDescription=view.findViewById(R.id.txt_privacy_description);
        txtCopyDescription=view.findViewById(R.id.txt_privacy_description_copy);
        txtContextDescription=view.findViewById(R.id.txt_privacy_description_context);
        txtShoppingDescription=view.findViewById(R.id.txt_privacy_description_shopping);
        txtKhalafDescription=view.findViewById(R.id.txt_privacy_description_khalaf);
        cardView=view.findViewById(R.id.card_view_main);
        copy=view.findViewById(R.id.card_view_copy);
        shopping=view.findViewById(R.id.card_view_shopping);
        context=view.findViewById(R.id.card_view_context);
        khalaf=view.findViewById(R.id.card_view_khalaf);
        txtItemDesc= view.findViewById(R.id.item_description_title);
        txtItemCopy= view.findViewById(R.id.item_description_title_copy);
        txtItemShoping=view.findViewById(R.id.item_description_title_shoping);
        txtItemKhalaf=view.findViewById(R.id.item_description_title_khalaf);
         txtItemContext= view.findViewById(R.id.item_description_title_context);


        cardView.setOnClickListener(v -> {

            TransitionManager.beginDelayedTransition(cardView);
            txtPrivacyDescription.setVisibility(View.VISIBLE);

        });
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtPrivacyDescription.getVisibility() == View.VISIBLE){
                    txtPrivacyDescription.setVisibility(GONE);
                    RotateAnimation rotate = new RotateAnimation(180, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    rotate.setDuration(300);
                    rotate.setInterpolator(new LinearInterpolator());
                    txtPrivacyDescription.startAnimation(rotate);
                }else{
                    txtPrivacyDescription.setVisibility(View.VISIBLE);
                    RotateAnimation rotate = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    rotate.setDuration(300);
                    rotate.setInterpolator(new LinearInterpolator());
                    txtPrivacyDescription.startAnimation(rotate);
                }
                TransitionManager.beginDelayedTransition(cardView);
            }
        });
        shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtShoppingDescription.getVisibility() == View.VISIBLE){
                    txtShoppingDescription.setVisibility(GONE);
                    RotateAnimation rotate = new RotateAnimation(180, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    rotate.setDuration(300);
                    rotate.setInterpolator(new LinearInterpolator());
                    txtShoppingDescription.startAnimation(rotate);
                }else{
                    txtShoppingDescription.setVisibility(View.VISIBLE);
                    RotateAnimation rotate = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    rotate.setDuration(300);
                    rotate.setInterpolator(new LinearInterpolator());
                    txtShoppingDescription.startAnimation(rotate);
                }
                TransitionManager.beginDelayedTransition(shopping);
            }
        });
        context.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtContextDescription.getVisibility() == View.VISIBLE){
                    txtContextDescription.setVisibility(GONE);
                    RotateAnimation rotate = new RotateAnimation(180, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    rotate.setDuration(300);
                    rotate.setInterpolator(new LinearInterpolator());
                    txtContextDescription.startAnimation(rotate);
                }else{
                    txtContextDescription.setVisibility(View.VISIBLE);
                    RotateAnimation rotate = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    rotate.setDuration(300);
                    rotate.setInterpolator(new LinearInterpolator());
                    txtContextDescription.startAnimation(rotate);
                }
                TransitionManager.beginDelayedTransition(context);
            }
        });

        khalaf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtKhalafDescription.getVisibility() == View.VISIBLE){
                    txtKhalafDescription.setVisibility(GONE);
                    RotateAnimation rotate = new RotateAnimation(180, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    rotate.setDuration(300);
                    rotate.setInterpolator(new LinearInterpolator());
                    txtKhalafDescription.startAnimation(rotate);
                }else{
                    txtKhalafDescription.setVisibility(View.VISIBLE);
                    RotateAnimation rotate = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    rotate.setDuration(300);
                    rotate.setInterpolator(new LinearInterpolator());
                    txtKhalafDescription.startAnimation(rotate);
                }
                TransitionManager.beginDelayedTransition(khalaf);
            }
        });
        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtCopyDescription.getVisibility() == View.VISIBLE){
                    txtCopyDescription.setVisibility(GONE);
                    RotateAnimation rotate = new RotateAnimation(180, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    rotate.setDuration(300);
                    rotate.setInterpolator(new LinearInterpolator());
                    txtCopyDescription.startAnimation(rotate);
                }else{
                    txtCopyDescription.setVisibility(View.VISIBLE);
                    RotateAnimation rotate = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    rotate.setDuration(300);
                    rotate.setInterpolator(new LinearInterpolator());
                    txtCopyDescription.startAnimation(rotate);
                }
                TransitionManager.beginDelayedTransition(copy);
            }
        });
        getGhavaninFromServer();
        return view;
    }


    void getGhavaninFromServer(){

        request= ApiClient.getRetrofit().create(ApiInterface.class);

        request.getGhavaninFromServer().enqueue(new Callback<GhavaninResponse>() {
            @Override
            public void onResponse(Call<GhavaninResponse> call, Response<GhavaninResponse> response) {
                try {
                    if (response.isSuccessful()){

                        Log.i("kk","fragment ghavanin title is  : "+response.body().getResult().get(0).getTitle());



                        txtItemDesc.setText(response.body().getResult().get(0).getTitle());
                        txtContextDescription.setText(response.body().getResult().get(0).getBody());
                        txtItemCopy.setText(response.body().getResult().get(1).getTitle());
                        txtCopyDescription.setText(response.body().getResult().get(1).getBody());
                        txtItemKhalaf.setText(response.body().getResult().get(2).getTitle());
                        txtKhalafDescription.setText(response.body().getResult().get(2).getBody());
                        txtItemShoping.setText(response.body().getResult().get(3).getTitle());
                        txtShoppingDescription.setText(response.body().getResult().get(3).getBody());
                        txtItemContext.setText(response.body().getResult().get(4).getTitle());
                        txtContextDescription.setText(response.body().getResult().get(4).getBody());

                    }else {

                        Log.i("kk","respone is not success ");
                    }
                }catch (Exception e){
                    Log.i("kk",e.getMessage());

                }


            }

            @Override
            public void onFailure(Call<GhavaninResponse> call, Throwable t) {

            }
        });


    }

}