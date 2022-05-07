package com.example.kosharyan.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.kosharyan.MainActivity;
import com.example.kosharyan.R;
import com.example.kosharyan.adapter.CostomerFromServerRecyclerAdapter;
import com.example.kosharyan.api.ApiClient;
import com.example.kosharyan.api.ApiInterface;
import com.example.kosharyan.model.home.CustomerResponse;
import com.example.kosharyan.model.tamas.TamasResponse;
import com.example.kosharyan.util.Util;
import com.google.android.material.button.MaterialButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;


public class FragmentContactUs extends Fragment {

    EditText email,number,name,massage;
MaterialButton send;
    ApiInterface request;
MainActivity mainActivity;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact_us, container, false);
        email = view.findViewById(R.id.frg_cantect_us_email);
        number = view.findViewById(R.id.frg_cantect_us_namber);
        name = view.findViewById(R.id.frg_cantect_us_name);
        massage = view.findViewById(R.id.frg_cantect_us_massage);
        send = view.findViewById(R.id.frg_cantect_us_BtnSend);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Util.goToFragment(new FragmentHome(),requireActivity());

                sendTamasForm("1",name.getText().toString(),email.getText().toString(),number.getText().toString(),"1400",massage.getText().toString());

                Util.showToast(requireActivity(),"پیام شما با موفقیت ثبت وارسال شد.");
            }
        });

        return view;



    }















    void sendTamasForm( String insert, String name,  String email,  String mobile,  String creat, String message){
    request= ApiClient.getRetrofit().create(ApiInterface.class);

    request.sendTamasForm(insert, name, email, mobile, creat, message).enqueue(new Callback<TamasResponse>() {
        @Override
        public void onResponse(Call<TamasResponse> call, Response<TamasResponse> response) {
            try {
                if (response.isSuccessful()){

                   // Log.i("kk","respone count is "+response.body().getStat());

               Util.showToast(requireActivity(),response.body().getStat());

                }else {

                    Log.i("kk","respone is not success ");
                }
            }catch (Exception e){
                Log.i("kk",e.getMessage());

            }


        }

        @Override
        public void onFailure(Call<TamasResponse> call, Throwable t) {

        }
    });

}
}