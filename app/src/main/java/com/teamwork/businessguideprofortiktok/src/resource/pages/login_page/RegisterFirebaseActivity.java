package com.teamwork.businessguideprofortiktok.src.resource.pages.login_page;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.teamwork.businessguideprofortiktok.R;
import com.teamwork.businessguideprofortiktok.src.resource.pages.main_page.MainActivity;

public class RegisterFirebaseActivity extends AppCompatActivity {
    private EditText mEdtEmail,mEdtUserName,mEdtPassword, mEdtPhone;
    private TextView mTxtLoginApp;
    private CardView mCardClickLogin;

    private FirebaseAuth mFAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_firebase);

        init();
        initOnclick();

        if (mFAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }
    }

    private void initOnclick() {
        mCardClickLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEdtEmail.getText().toString().trim();
                String password = mEdtPassword.getText().toString().trim();
                if (TextUtils.isEmpty(email)){
                    mEdtEmail.setError("Email is Required");
                return;
                }
                if (TextUtils.isEmpty(password)){
                    mEdtPassword.setError("Password is Required");
                    return;
                }
                if (password.length() < 6 ){
                    mEdtPassword.setError("Password must be >= 6 Characters");
                }

                mFAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(RegisterFirebaseActivity.this, "User Created.", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(RegisterFirebaseActivity.this, "Error !!!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });

            }
        });
    }

    private void init() {
        mEdtEmail = findViewById(R.id.edt_Email);
        mEdtUserName = findViewById(R.id.edt_User);
        mEdtPassword = findViewById(R.id.edt_Password);
        mEdtPhone = findViewById(R.id.edt_Phone);
        mCardClickLogin = findViewById(R.id.card_login);

        mFAuth = FirebaseAuth.getInstance();
    }
}