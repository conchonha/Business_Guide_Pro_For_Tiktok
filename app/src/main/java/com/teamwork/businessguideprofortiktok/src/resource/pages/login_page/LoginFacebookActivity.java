package com.teamwork.businessguideprofortiktok.src.resource.pages.login_page;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.teamwork.businessguideprofortiktok.R;
import com.teamwork.businessguideprofortiktok.src.resource.pages.webview_page.WebViewFacebookActivity;

public class LoginFacebookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_facebook);
    }

    public void login(View view) {
        startActivity(new Intent(getApplicationContext(), WebViewFacebookActivity.class));
        finish();
    }

    ;
}