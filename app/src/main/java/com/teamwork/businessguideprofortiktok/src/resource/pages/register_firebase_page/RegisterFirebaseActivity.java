package com.teamwork.businessguideprofortiktok.src.resource.pages.register_firebase_page;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.firebase.auth.FirebaseAuth;
import com.teamwork.businessguideprofortiktok.R;
import com.teamwork.businessguideprofortiktok.src.compoments.text_watcher_compoments.TextChangeListener;
import com.teamwork.businessguideprofortiktok.src.resource.pages.login_firebase_page.LoginFirebaseActivity;
import com.teamwork.businessguideprofortiktok.src.resource.viewmodels.register_viewmodel.RegisterViewModel;
import com.teamwork.businessguideprofortiktok.src.utils.Validations;

public class RegisterFirebaseActivity extends AppCompatActivity {
    private EditText mEdtEmail, mEdtUserName, mEdtPassword, mEdtPhone;
    private CardView mCardClickLogin;
    private RegisterViewModel mRegisterViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_firebase);
        mRegisterViewModel = ViewModelProviders.of(RegisterFirebaseActivity.this).get(RegisterViewModel.class);
        init();
        listennerViewmodel();
        listennerView();
        initView();
        listenerOnclicked();
    }

    private void listennerViewmodel() {
        mRegisterViewModel.getDataReponse().observe(RegisterFirebaseActivity.this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if (s.equals("Success")) {
                    Toast.makeText(RegisterFirebaseActivity.this, getResources().getString(R.string.txt_register_success), Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), LoginFirebaseActivity.class));
                } else {
                    Toast.makeText(RegisterFirebaseActivity.this, getResources().
                            getString(R.string.txt_register_error), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void listennerView() {
        mEdtEmail.addTextChangedListener(new TextChangeListener(mEdtEmail) {
            @Override
            public void afterTextChanged(Editable s) {
                super.afterTextChanged(s);
                if (!Validations.isEmailValid(mEdtEmail.getText().toString())) {
                    mEdtEmail.setError(getResources().getString(R.string.txt_email_invalid));
                }
            }
        });
        mEdtPassword.addTextChangedListener(new TextChangeListener(mEdtPassword) {
            @Override
            public void afterTextChanged(Editable s) {
                super.afterTextChanged(s);
                if (!Validations.isPasswordValid(mEdtPassword.getText().toString())) {
                    mEdtPassword.setError(getResources().getString(R.string.txt_password_invalid));
                }
            }
        });

        mEdtUserName.addTextChangedListener(new TextChangeListener(mEdtUserName) {
            @Override
            public void afterTextChanged(Editable s) {
                super.afterTextChanged(s);
                if (!Validations.isValidName(mEdtUserName.getText())) {
                    mEdtUserName.setError(getResources().getString(R.string.txt_name_invalid));
                }
            }
        });

        mEdtPhone.addTextChangedListener(new TextChangeListener(mEdtUserName) {
            @Override
            public void afterTextChanged(Editable s) {
                super.afterTextChanged(s);
                if (!Validations.isValidPhoneNumber(mEdtPhone.getText().toString())) {
                    mEdtPhone.setError(getResources().getString(R.string.txt_phone_invalid));
                }
            }
        });
    }

    private void init() {
        if (mRegisterViewModel.mFAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), LoginFirebaseActivity.class));
            finish();
        }
    }

    private void listenerOnclicked() {
        mCardClickLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRegisterViewModel.registerFirebase(mEdtEmail.getText(), mEdtEmail.getText().toString(),
                        mEdtPassword.getText().toString(), mEdtPhone.getText().toString());
            }
        });
    }

    private void initView() {
        mEdtEmail = findViewById(R.id.edt_Email);
        mEdtUserName = findViewById(R.id.edt_User);
        mEdtPassword = findViewById(R.id.edt_Password);
        mEdtPhone = findViewById(R.id.edt_Phone);
        mCardClickLogin = findViewById(R.id.card_login);
    }
}