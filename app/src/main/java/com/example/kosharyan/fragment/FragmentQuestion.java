package com.example.kosharyan.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.kosharyan.R;
import com.example.kosharyan.api.ApiClient;
import com.example.kosharyan.api.ApiInterface;
import com.example.kosharyan.model.followQuestion.FollowQuestionModel;
import com.example.kosharyan.model.porsesh.PorseshResponse;
import com.example.kosharyan.model.tamas.TamasResponse;
import com.example.kosharyan.util.Util;
import com.google.android.material.button.MaterialButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Query;


public class FragmentQuestion extends Fragment {
EditText email,usrname,titelQustion,bodyQustion;
MaterialButton sendQustion;
    ApiInterface request;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_question, container, false);
       email=view.findViewById(R.id.frg_qustion_email);
       usrname=view.findViewById(R.id.frg_qustion_username);
       titelQustion=view.findViewById(R.id.frg_qustion);
       bodyQustion=view.findViewById(R.id.frg_qustion_massage_qustion);
       sendQustion=view.findViewById(R.id.frg__BtnSend_qustion);
       sendQustion.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Util.goToFragment(new FragmentCode(),requireActivity());
               sendPorshForm(titelQustion.getText().toString(),email.getText().toString(),usrname.getText().toString(),bodyQustion.getText().toString());
               Util.showToast(requireActivity(),"پیام شما با موفقیت ثبت وارسال شد.");
           }
       });
       return view;


    }
    void sendPorshForm( String title, String email,String name,String body){
        request= ApiClient.getRetrofit().create(ApiInterface.class);

        request.sendPorseshForm(title, email, name,body ).enqueue(new Callback<PorseshResponse>() {
            @Override
            public void onResponse(Call<PorseshResponse> call, Response<PorseshResponse> response) {
                try {
                    if (response.isSuccessful()){

                        // Log.i("kk","respone count is "+response.body().getStat());

                        getFollowQuestion(response);

                        Util.showToast(requireActivity(),response.body().getState());

                    }else {

                        Log.i("kk","respone is not success ");
                    }
                }catch (Exception e){
                    Log.i("kk",e.getMessage());

                }


            }

            @Override
            public void onFailure(Call<PorseshResponse> call, Throwable t) {

            }
        });

    }
    void getFollowQuestion( Response<PorseshResponse> responsePorsesh ){
        request= ApiClient.getRetrofit().create(ApiInterface.class);

        request.followQuestionRequest(responsePorsesh.body().getCodeR() ).enqueue(new Callback<FollowQuestionModel>() {
            @Override
            public void onResponse(Call<FollowQuestionModel> call, Response<FollowQuestionModel> response) {
                try {
                    if (response.isSuccessful()){

                        // Log.i("kk","respone count is "+response.body().getStat());

                        Bundle bundle = new Bundle();

                        bundle.putString("code",responsePorsesh.body().getCodeR());
                        bundle.putString("status",response.body().getState());

                        FragmentCode fragmentm =new FragmentCode();

                        fragmentm.setArguments(bundle);

                        Util.goToFragment(fragmentm ,requireActivity());



                        Util.showToast(requireActivity(),response.body().getState());

                    }else {

                        Log.i("kk","respone is not success ");
                    }
                }catch (Exception e){
                    Log.i("kk",e.getMessage());

                }


            }

            @Override
            public void onFailure(Call<FollowQuestionModel> call, Throwable t) {

            }
        });

    }

}