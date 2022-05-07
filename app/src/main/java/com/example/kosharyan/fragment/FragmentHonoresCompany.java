package com.example.kosharyan.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kosharyan.R;
import com.example.kosharyan.adapter.EftekharatRecyclerAdapter;
import com.example.kosharyan.adapter.MemberFromServerRecyclerAdapter;
import com.example.kosharyan.api.ApiClient;
import com.example.kosharyan.api.ApiInterface;
import com.example.kosharyan.model.Eftekharat;
import com.example.kosharyan.model.News;
import com.example.kosharyan.model.eftekharat.Eftekhar;
import com.example.kosharyan.model.eftekharat.EftekharResponse;
import com.example.kosharyan.model.home.CustomerResponse;
import com.example.kosharyan.model.member.MemberResponse;
import com.limerse.slider.model.CarouselItem;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentHonoresCompany extends Fragment {

    ApiInterface request;
    RecyclerView efrekharatRecyclerView;
    EftekharatRecyclerAdapter eftekharadapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_honores_company, container, false);
        efrekharatRecyclerView=view.findViewById(R.id.recycler_eftekharat);
        getEftekharrFromServer();
        return view;}

    void setupRecyclerHonores(){
        ArrayList<Eftekharat>eftekharats=new ArrayList<>();
        Eftekharat eftekharat1=new Eftekharat("افتخار اول","","توضیح افتخار اول");
        Eftekharat eftekharat2=new Eftekharat("افتخار اول","","توضیح افتخار اول");
        Eftekharat eftekharat3=new Eftekharat("افتخار اول","","توضیح افتخار اول");
        Eftekharat eftekharat4=new Eftekharat("افتخار اول","","توضیح افتخار اول");

       eftekharats.add(eftekharat1);
       eftekharats.add(eftekharat2);
       eftekharats.add(eftekharat3);
       eftekharats.add(eftekharat4);

        //  adapterNewsList =new NewsListRecyclerAdapter(requireActivity(),news);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false);
        efrekharatRecyclerView.setLayoutManager(layoutManager);
        efrekharatRecyclerView.setAdapter(eftekharadapter);
    }


    void getEftekharrFromServer(){

    //ArrayList<Eftekhar> itemList =new ArrayList<>();


    request= ApiClient.getRetrofit().create(ApiInterface.class);

        request.getEftekharFromServer().enqueue(new Callback<EftekharResponse>() {
            @Override
            public void onResponse(Call<EftekharResponse> call, Response<EftekharResponse> response) {
                try {
                    if (response.isSuccessful()){

                        eftekharadapter = new EftekharatRecyclerAdapter(requireActivity(),response.body());

                        LinearLayoutManager layoutManager = new LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false);

                        efrekharatRecyclerView.setLayoutManager(layoutManager);
                        efrekharatRecyclerView.setAdapter(eftekharadapter);


                    }else {

                        Log.i("kk","respone is not success ");
                    }
                }catch (Exception e){
                    Log.i("kk",e.getMessage());

                }


            }

            @Override
            public void onFailure(Call<EftekharResponse> call, Throwable t) {

            }
        });


    }}

