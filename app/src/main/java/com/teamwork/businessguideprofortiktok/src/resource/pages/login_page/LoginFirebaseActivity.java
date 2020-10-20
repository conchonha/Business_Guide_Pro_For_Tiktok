package com.teamwork.businessguideprofortiktok.src.resource.pages.login_page;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.teamwork.businessguideprofortiktok.R;

public class LoginFirebaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_fibase);
    }

    public void siginUp(View view) {
        startActivity(new Intent(getApplicationContext(),RegisterFirebaseActivity.class));
        finish();
    }
}