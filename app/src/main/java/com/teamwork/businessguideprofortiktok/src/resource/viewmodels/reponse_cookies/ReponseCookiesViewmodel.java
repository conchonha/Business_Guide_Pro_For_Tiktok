package com.teamwork.businessguideprofortiktok.src.resource.viewmodels.reponse_cookies;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class ReponseCookiesViewmodel extends ViewModel {
    private String TAG = "Reponse_Cookies_Actyvity";
    private String[] liststr = {"A","B","C","D","W","R","4","1","8","6","N"};

    public String getStrRandom(){
        Random random = new Random();
        String str = "";
        for (int i = 0 ; i < liststr.length ; i++){
            str += liststr[random.nextInt(liststr.length)];
            Log.d(TAG ,"strRandom: " + str);
        }
        return  str;
    }

}
