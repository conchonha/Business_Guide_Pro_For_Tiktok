package com.teamwork.businessguideprofortiktok.src.resource.viewmodels.login_viewmodel;

import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.teamwork.businessguideprofortiktok.src.utils.Validations;

public class LoginViewModel extends ViewModel {
    private FirebaseAuth mFAuth = FirebaseAuth.getInstance();
    public MutableLiveData<String>mReponse = new MutableLiveData<>();
    public MutableLiveData<Boolean>mIsLoading = new MutableLiveData<>();

    public LiveData<Boolean>getIsLoading(){
        return mIsLoading;
    }

    public LiveData<String>getDataReponse(){
        return  mReponse;
    }


    public void loginFirebase(final String email, final String password){
        if(Validations.isEmailValid(email) && Validations.isPasswordValid(password)){
            mIsLoading.setValue(true);
            new AsyncTask<Void,Void,Void>(){
                @Override
                protected Void doInBackground(Void... voids) {
                    mFAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                mReponse.postValue("Login Succsessfully.");
                            }else {
                                mReponse.postValue("Login Error !!!");
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
