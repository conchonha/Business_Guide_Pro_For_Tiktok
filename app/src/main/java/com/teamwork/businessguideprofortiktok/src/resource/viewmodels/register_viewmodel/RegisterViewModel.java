package com.teamwork.businessguideprofortiktok.src.resource.viewmodels.register_viewmodel;

import android.content.Intent;
import android.os.AsyncTask;
import android.text.Editable;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.teamwork.businessguideprofortiktok.src.resource.pages.login_firebase_page.LoginFirebaseActivity;
import com.teamwork.businessguideprofortiktok.src.resource.pages.register_firebase_page.RegisterFirebaseActivity;
import com.teamwork.businessguideprofortiktok.src.utils.Validations;

public class RegisterViewModel extends ViewModel {
    public FirebaseAuth mFAuth = FirebaseAuth.getInstance();
    private MutableLiveData<String>mReponse = new MutableLiveData<>();
    public MutableLiveData<Boolean>mIsLoading = new MutableLiveData<>();

    public LiveData<String>getDataReponse(){
        return mReponse;
    }

    public LiveData<Boolean>getIsLoading(){
        return mIsLoading;
    }

    public void registerFirebase(String userName, final String email, final String password, String phone){
        if(!userName.isEmpty() && Validations.isEmailValid(email) && Validations.isPasswordValid(password) && Validations.isValidPhoneNumber(phone)){
            mIsLoading.setValue(true);
            new AsyncTask<Void,Void,Void>(){
                @Override
                protected Void doInBackground(Void... voids) {
                    mFAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                mReponse.postValue("Success");
                            } else {
                                mReponse.postValue(task.toString());
                                mIsLoading.postValue(false);
                            }
                        }
                    });
                    return null;
                }
            }.execute();
        }
    }
}
