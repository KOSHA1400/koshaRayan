package com.example.kosharyan.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.kosharyan.R;

public class Util {


public static  void goToFragment(Fragment fragment , Context context){



        FragmentManager manager = ((AppCompatActivity)context).getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.container,fragment,null).commit();
    }

  public static void showToast( Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();

    }

   
}
