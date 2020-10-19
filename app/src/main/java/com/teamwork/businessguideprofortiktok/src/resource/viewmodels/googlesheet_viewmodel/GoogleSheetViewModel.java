package com.teamwork.businessguideprofortiktok.src.resource.viewmodels.googlesheet_viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.teamwork.businessguideprofortiktok.src.resource.repositories.google_sheet_repository.GoogleSheetRepository;

public class GoogleSheetViewModel extends ViewModel {
    private GoogleSheetRepository mGoogleSheetRepository;
    private MutableLiveData<String>   mMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<String>  ip = new MutableLiveData<>();;
    public MutableLiveData<String> cookies = new MutableLiveData<>();

    public void init(){
        if(mMutableLiveData != null){
            return;
        }
        mGoogleSheetRepository = mGoogleSheetRepository.getInstante();
        mMutableLiveData = mGoogleSheetRepository.getDataGoogleSheet(getIp().getValue(),getCookies().getValue());
    }

    public  void senData(String id,String cookies){
        mGoogleSheetRepository = mGoogleSheetRepository.getInstante();
        mMutableLiveData = mGoogleSheetRepository.getDataGoogleSheet(id,cookies);
    }

    public MutableLiveData<String> getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip.setValue(ip);
    }

    public void setCookies(String cookies) {
        this.cookies.setValue(cookies);
    }

    public MutableLiveData<String> getmMutableLiveData() {
        return mMutableLiveData;
    }



    public MutableLiveData<String> getCookies() {
        return cookies;
    }

}
