package com.teamwork.businessguideprofortiktok.src.resource.pages.reponse_cookies_page;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.IntentCompat;
import androidx.lifecycle.ViewModelProviders;

import com.google.firebase.auth.FirebaseAuth;
import com.teamwork.businessguideprofortiktok.R;
import com.teamwork.businessguideprofortiktok.src.models.callback.CallbackInterface;
import com.teamwork.businessguideprofortiktok.src.resource.dialog.confirm_dialog.ConfirmDialog;
import com.teamwork.businessguideprofortiktok.src.resource.dialog.show_loading.ShowLoadingDialog;
import com.teamwork.businessguideprofortiktok.src.resource.pages.introduce_page.IntroduceActivity;
import com.teamwork.businessguideprofortiktok.src.resource.pages.webview_page.WebViewFacebookActivity;
import com.teamwork.businessguideprofortiktok.src.resource.viewmodels.reponse_cookies.ReponseCookiesViewmodel;


public class ReponseCookiesActivity extends AppCompatActivity implements CallbackInterface {
    private TextView mTxtRandom;
    private ImageView mImageCopy;
    private ReponseCookiesViewmodel mReponseCookiesViewmodel;
    private String TAG = "ReponseCookiesActivity";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_facebook);
        mReponseCookiesViewmodel = ViewModelProviders.of(ReponseCookiesActivity.this).get(ReponseCookiesViewmodel.class);
        initView();
        setDataView();
        listenerOnclickedView();

    }

    private void listenerOnclickedView() {
        mImageCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager mClipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                mClipboardManager.setPrimaryClip(ClipData.newPlainText("auto_copy_text", mTxtRandom.getText().toString()));
                Toast.makeText(ReponseCookiesActivity.this, getResources().getString(R.string.txt_copy_success), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setDataView() {
        mTxtRandom.setText(mReponseCookiesViewmodel.getStrRandom());
    }


    private void initView() {
        mTxtRandom = findViewById(R.id.txtRandom);
        mImageCopy = findViewById(R.id.imgCopy);
    }

    public void logout(View view) {
        ConfirmDialog.showDialogAcount(ReponseCookiesActivity.this, getResources().getString(R.string.txt_signout), getResources().getString(R.string.txt_exit), ReponseCookiesActivity.this);
    }

//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        //ConfirmDialog.showDialogAcount(ReponseCookiesActivity.this, getResources().getString(R.string.txt_signout), getResources().getString(R.string.txt_exit), new ReponseCookiesActivity());
//    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            ConfirmDialog.showDialogAcount(ReponseCookiesActivity.this, getResources().getString(R.string.txt_signout),
                    getResources().getString(R.string.txt_exit),  ReponseCookiesActivity.this);
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void methodToCallback() {
        try {
            Dialog dialog = ShowLoadingDialog.getDialog(ReponseCookiesActivity.this);
            dialog.show();

//            FirebaseAuth.getInstance().signOut();
            Thread.sleep(2000);

            Intent nextScreen = new Intent(ReponseCookiesActivity.this, IntroduceActivity.class);
            nextScreen.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(nextScreen);
            ActivityCompat.finishAffinity(ReponseCookiesActivity.this);

            finish();
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "methodToCallback: err"+ e.toString());
        }
    }
}