package com.teamwork.businessguideprofortiktok.src.resource.pages.face_page;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.teamwork.businessguideprofortiktok.R;

public class FacebookActivity extends AppCompatActivity {
    private WebView mWebViewFb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face_book);

        initWebViewFB();

        mWebViewFb.loadUrl("https://www.facebook.com/");
        mWebViewFb.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                String strCookies = CookieManager.getInstance().getCookie("https://www.facebook.com/");

                String[]arrayCookies = strCookies.split(";");

                if (arrayCookies.length == 6){
                    FacebookActivity.this.finish();
                }
            }
        });


    }

    private void initWebViewFB() {
        mWebViewFb = findViewById(R.id.webViewFB);
    }
}