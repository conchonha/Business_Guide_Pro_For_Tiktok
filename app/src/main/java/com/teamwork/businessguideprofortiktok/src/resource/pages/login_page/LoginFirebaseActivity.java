package com.teamwork.businessguideprofortiktok.src.resource.pages.login_page;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.teamwork.businessguideprofortiktok.R;
import com.teamwork.businessguideprofortiktok.src.resource.pages.main_page.MainActivity;

public class LoginFirebaseActivity extends AppCompatActivity {
    private EditText mEdtEmail, mEdtPassword;
    private CardView mCardViewLogin;
    private FirebaseAuth mFAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_fibase);

        init();
        initOnclicked();

    }

    private void initOnclicked() {
        mCardViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEdtEmail.getText().toString().trim();
                String password = mEdtPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    mEdtEmail.setError("Emaill is Requied.");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    mEdtPassword.setError("Password is Requied.");
                    return;
                }
                if (password.length() < 6){
                    mEdtPassword.setError("Password Must be >=6 Characters");
                    return;
                }
                mFAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(LoginFirebaseActivity.this, "Login Succsessfully.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), LoginFacebookActivity.class));
                        }else {
                            Toast.makeText(LoginFirebaseActivity.this, "Login Error !!!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });
    }

    private void init() {
        mEdtEmail = findViewById(R.id.edt_Email);
        mEdtPassword = findViewById(R.id.edt_Password);
        mCardViewLogin = findViewById(R.id.card_login);
        mFAuth = FirebaseAuth.getInstance();
    }

    public void siginUp(View view) {
        startActivity(new Intent(getApplicationContext(),RegisterFirebaseActivity.class));
        finish();
    }
}