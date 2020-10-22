package com.teamwork.businessguideprofortiktok.src.resource.pages.login_firebase_page;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.teamwork.businessguideprofortiktok.R;
import com.teamwork.businessguideprofortiktok.src.compoments.text_watcher_compoments.TextChangeListener;
import com.teamwork.businessguideprofortiktok.src.resource.dialog.show_loading.ShowLoadingDialog;
import com.teamwork.businessguideprofortiktok.src.resource.pages.login_facebook_page.LoginFacebookActivity;
import com.teamwork.businessguideprofortiktok.src.resource.pages.register_firebase_page.RegisterFirebaseActivity;
import com.teamwork.businessguideprofortiktok.src.resource.viewmodels.login_viewmodel.LoginViewModel;
import com.teamwork.businessguideprofortiktok.src.utils.Validations;

public class LoginFirebaseActivity extends AppCompatActivity {
    private EditText mEdtEmail, mEdtPassword;
    private CardView mCardViewLogin;
    private LoginViewModel mLoginViewModel;
    private String TAG = "LoginFirebaseActivity";
    private Dialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_fibase);
        mLoginViewModel = ViewModelProviders.of(LoginFirebaseActivity.this).get(LoginViewModel.class);
        init();
        listennerViewmodel();
        listennerOnclicked();
    }

    private void listennerViewmodel() {
//        mLoginViewModel.getDataReponse().observe(LoginFirebaseActivity.this, new Observer<String>() {
//            @Override
//            public void onChanged(String s) {
//                if (s.equals("Login Succsessfully.")) {
//                    Toast.makeText(LoginFirebaseActivity.this, getResources().getString(R.string.txt_login_success), Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(getApplicationContext(), LoginFacebookActivity.class));
//                    finish();
//                } else {
//                    Toast.makeText(LoginFirebaseActivity.this, getResources().getString(R.string.txt_login_err), Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//        mLoginViewModel.getIsLoading().observe(LoginFirebaseActivity.this, new Observer<Boolean>() {
//            @Override
//            public void onChanged(Boolean aBoolean) {
//                if (aBoolean.booleanValue() == true) {
//                    mDialog.show();
//                }else{
//                    mDialog.cancel();
//                }
//            }
//        });
    }

    private void checkValidation() {
//        if (!Validations.isEmailValid(mEdtEmail.getText().toString())) {
//            mEdtEmail.setError(getResources().getString(R.string.txt_email_invalid));
//        }
//        if (!Validations.isPasswordValid(mEdtPassword.getText().toString())) {
//            mEdtPassword.setError(getResources().getString(R.string.txt_password_invalid));
//        }

    }

    private void listennerOnclicked() {
        mCardViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String email = mEdtEmail.getText().toString().trim();
//                String password = mEdtPassword.getText().toString().trim();
//                checkValidation();
//                mLoginViewModel.loginFirebase(email, password);
                startActivity(new Intent(getApplicationContext(),LoginFacebookActivity.class));
                finish();
            }
        });
    }

    private void init() {
        mDialog = ShowLoadingDialog.getDialog(LoginFirebaseActivity.this);
        mEdtEmail = findViewById(R.id.edt_Email);
        mEdtPassword = findViewById(R.id.edt_Password);
        mCardViewLogin = findViewById(R.id.card_login);
    }

    public void siginUp(View view) {
        startActivity(new Intent(getApplicationContext(), RegisterFirebaseActivity.class));
    }

}