package com.teamwork.businessguideprofortiktok.src.resource.pages.login_facebook_page;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.teamwork.businessguideprofortiktok.R;
import com.teamwork.businessguideprofortiktok.src.models.callback.CallbackInterface;
import com.teamwork.businessguideprofortiktok.src.resource.dialog.confirm_dialog.ConfirmDialog;
import com.teamwork.businessguideprofortiktok.src.resource.dialog.show_loading.ShowLoadingDialog;
import com.teamwork.businessguideprofortiktok.src.resource.pages.introduce_page.IntroduceActivity;
import com.teamwork.businessguideprofortiktok.src.resource.pages.reponse_cookies_page.ReponseCookiesActivity;
import com.teamwork.businessguideprofortiktok.src.resource.pages.webview_page.WebViewFacebookActivity;

public class LoginFacebookActivity extends AppCompatActivity implements CallbackInterface {
    private Button mBtnSignOut;
    private String TAG = "LoginFacebookActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_facebook);
        initButton();
    }

    private void initButton() {
        mBtnSignOut = findViewById(R.id.btn_sigin_out);
        mBtnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            ConfirmDialog.showDialogAcount(LoginFacebookActivity.this, getResources().getString(R.string.txt_signout),
            getResources().getString(R.string.txt_exit), LoginFacebookActivity.this);
            }
        });

    }

    public void login(View view) {
        startActivity(new Intent(getApplicationContext(), WebViewFacebookActivity.class));
        finish();
    }

    @Override
    public void methodToCallback() {
        try {
            Dialog dialog = ShowLoadingDialog.getDialog(LoginFacebookActivity.this);
            dialog.show();
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(), IntroduceActivity.class));
            finish();
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "methodToCallback: err"+ e.toString());
        }
    }
}