package com.teamwork.businessguideprofortiktok.src.resource.fragments.register_fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.teamwork.businessguideprofortiktok.R;
import com.teamwork.businessguideprofortiktok.src.compoments.text_watcher_compoments.TextChangeListener;
import com.teamwork.businessguideprofortiktok.src.utils.Validations;

import java.util.Calendar;


public class Register extends Fragment {
    private View view;
    private RadioButton mRadioBtnOption1, mRadioBtnOption2;
    private EditText mEdittextEmail, mEdittextPhone, mEdittextPass, mEdittextConfirmPass ;
    private TextView mDatetime;
    private Button mButtonGetCreate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_introduce2, container, false);
        init();
        onClistener();
        return view;
    }

    private void onClistener() {
        mEdittextEmail.addTextChangedListener(new TextChangeListener(mEdittextEmail) {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                super.onTextChanged(s, start, before, count);
                if (!Validations.isEmailValid(mEdittextEmail.getText().toString())) {
                    mEdittextEmail.setError("Invalid email");
                }
            }
        });

        mEdittextPhone.addTextChangedListener(new TextChangeListener(mEdittextPhone) {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                super.onTextChanged(s, start, before, count);
                if (!Validations.isValidPhoneNumber(mEdittextPhone.getText().toString())) {
                    mEdittextPhone.setError("Invalid phone number");
                }
            }
        });

        mEdittextPass.addTextChangedListener(new TextChangeListener(mEdittextPass) {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                super.onTextChanged(s, start, before, count);
                if (!Validations.isPasswordValid(mEdittextPass.getText().toString())) {
                    mEdittextPass.setError("Invalid password");
                }
            }
        });

        mEdittextConfirmPass.addTextChangedListener(new TextChangeListener(mEdittextConfirmPass) {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                super.onTextChanged(s, start, before, count);
                if (!Validations.isPasswordValid(mEdittextConfirmPass.getText().toString())) {
                    mEdittextConfirmPass.setError("Invalid confirm password");
                }
            }
        });

        mDatetime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();

                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        mDatetime.setText(year+"/"+month+"/"+dayOfMonth);
                    }
                },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DATE));
                datePickerDialog.show();
            }
        });
    }



    private void init() {
        mRadioBtnOption1 = view.findViewById(R.id.radio_option_1);
        mRadioBtnOption2 = view.findViewById(R.id.radio_option_2);
        mEdittextEmail = view.findViewById(R.id.email);
        mEdittextPhone = view.findViewById(R.id.phonenumber);
        mEdittextPass = view.findViewById(R.id.pass);
        mEdittextConfirmPass = view.findViewById(R.id.confirmpass);
        mButtonGetCreate = view.findViewById(R.id.btn_create_account);
        mDatetime = view.findViewById(R.id.datetime);
    }
}
