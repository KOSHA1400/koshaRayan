package com.example.kosharyan.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kosharyan.adapter.CostomerFromServerRecyclerAdapter;
import com.example.kosharyan.adapter.MemberFromServerRecyclerAdapter;
import com.example.kosharyan.api.ApiClient;
import com.example.kosharyan.api.ApiInterface;
import com.example.kosharyan.model.About;
import com.example.kosharyan.adapter.AboutRecyclerAdapter;
import com.example.kosharyan.R;
import com.example.kosharyan.model.home.CustomerResponse;
import com.example.kosharyan.model.member.Member;
import com.example.kosharyan.model.member.MemberResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentMemberCompany extends Fragment {
    RecyclerView aboutRecyclerView;
    ApiInterface request;
   MemberFromServerRecyclerAdapter adapterabout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_member_company, container, false);
        aboutRecyclerView = view.findViewById(R.id.recycler_about);
      //  setupRecyclerAbout();
        getMemberFromServer();
        return view;
    }
    void getMemberFromServer(){

        request= ApiClient.getRetrofit().create(ApiInterface.class);

        request.getMemberFromServer().enqueue(new Callback<MemberResponse>() {
            @Override
            public void onResponse(Call<MemberResponse> call, Response<MemberResponse> response) {
                try {
                    if (response.isSuccessful()){

                        Log.i("kk","respone count is "+response.body().getMember().size());
                        adapterabout = new MemberFromServerRecyclerAdapter(requireActivity(),response.body());

                        LinearLayoutManager layoutManager = new LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false);

                        aboutRecyclerView.setLayoutManager(layoutManager);
                        aboutRecyclerView.setAdapter( adapterabout );


                    }else {

                        Log.i("kk","respone is not success ");
                    }
                }catch (Exception e){
                    Log.i("kk",e.getMessage());

                }


            }

            @Override
            public void onFailure(Call<MemberResponse> call, Throwable t) {

            }
        });


    }

    void setupRecyclerAbout(){
        ArrayList<About> abouts= new ArrayList<>();

        About member1=new About("خانم مهندس یاری  ","https://files.virgool.io/upload/users/378554/posts/lcea6f6qhoo5/jojluuvepb2s.png","خانم مهندس یاری فارغ التحصیل رشته نرم افزار ومتخصص قسمت بک اند");
        About member2=new About("خانم مهندس تنهایی","https://files.virgool.io/upload/users/378554/posts/lcea6f6qhoo5/jojluuvepb2s.png","فارغ التحصیل آی تی دانشگاه ایلام ومتخصص قسمت فرونت اند") ;
        About member3=new About("خانم مهندس سلطانی","https://files.virgool.io/upload/users/378554/posts/lcea6f6qhoo5/jojluuvepb2s.png","خانممهندس سلطانی فارغ التحصیل رشته نرم افزار ومتخصص قسمت بک اند");
        About member4=new About("خانم مهندس عبداللهی","https://files.virgool.io/upload/users/378554/posts/lcea6f6qhoo5/jojluuvepb2s.png"," خانم مهندس عبداللهی دانشجوی رشته نرم افزار و متخصص قسمت اندروید  ");
        abouts.add(member1);
        abouts.add(member2);
        abouts.add(member3);
        abouts.add(member4);



        AboutRecyclerAdapter adapter2;

        adapter2 = new AboutRecyclerAdapter(requireActivity(), abouts);

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false);

        aboutRecyclerView.setLayoutManager(layoutManager);
        aboutRecyclerView.setAdapter(adapterabout);
    }
}