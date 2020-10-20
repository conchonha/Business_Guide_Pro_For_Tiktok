package com.teamwork.businessguideprofortiktok.src.resource.pages.reponse_cookies_page;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.teamwork.businessguideprofortiktok.R;

import java.util.Collections;
import java.util.Random;

public class ReponseCookiesActivity extends AppCompatActivity {
    private TextView mTxtRandom;
    private ImageView mImageCopy;
    private String[] liststr = {"A","B","C","D","W","R","4","1","8","6","N"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_facebook);
        Log.d("TAGrandom", "onCreate: "+strRandom());
        strRandom();
        initViewRandom();
        setDataView();
        listenerOnclickedView();

    }

    private void listenerOnclickedView() {
        mImageCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager mClipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                mClipboardManager.setPrimaryClip(ClipData.newPlainText("auto_copy_text", mTxtRandom.getText().toString()));
                Toast.makeText(ReponseCookiesActivity.this, "Copy Susscessfully", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setDataView() {
        mTxtRandom.setText(strRandom());

    }


    private void initViewRandom() {
        mTxtRandom = findViewById(R.id.txtRandom);
        mImageCopy = findViewById(R.id.imgCopy);
    }

    private String strRandom(){
        Random random = new Random();
        String str = "";
        for (int i = 0 ; i < liststr.length ; i++){
            str += liststr[random.nextInt(liststr.length)];
            Log.d("TAGstr" ,"strRandom: " + str);
        }

        return  str;
    }
}
