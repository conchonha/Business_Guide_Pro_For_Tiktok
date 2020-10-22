package com.teamwork.businessguideprofortiktok.src.resource.adapters.introduce_adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.teamwork.businessguideprofortiktok.R;
import com.teamwork.businessguideprofortiktok.src.resource.pages.introduce_page.IntroduceActivity;

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
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (position) {
            case 0:
                final FragmentSlider0 fragmentSlider0 = (FragmentSlider0) holder;
                listennerFragmentSlide1(fragmentSlider0,position);
                break;
            case 1:
                FragmentSlider1 fragmentSlider1 = (FragmentSlider1) holder;
                break;
            case 2:
                FragmentSlider2 fragmentSlider2 = (FragmentSlider2) holder;
                break;
            case 3:
                FragmentSlider3 fragmentSlider3 = (FragmentSlider3) holder;
                break;
        }
    }

    private void listennerFragmentSlide1(FragmentSlider0 fragmentSlider1,int position){
        fragmentSlider1.mBtnGetCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntroduceActivity.scroollView(1);
            }
        });
    }


    @Override
    public int getItemCount() {
        return mArrayLayout.size();
    }

    public class FragmentSlider0 extends RecyclerView.ViewHolder {
        private Button mBtnGetCreate;
        private TextView txt;

        public FragmentSlider0(@NonNull View itemView) {
            super(itemView);
            mBtnGetCreate = itemView.findViewById(R.id.btn_get_create);
            txt = itemView.findViewById(R.id.txt_content_introduce1);
        }

    }

    public class FragmentSlider1 extends RecyclerView.ViewHolder {
        public FragmentSlider1(@NonNull View itemView) {
            super(itemView);
        }
    }

    public class FragmentSlider2 extends RecyclerView.ViewHolder {
        public FragmentSlider2(@NonNull View itemView) {
            super(itemView);
        }
    }

    public class FragmentSlider3 extends RecyclerView.ViewHolder {
        public FragmentSlider3(@NonNull View itemView) {
            super(itemView);
        }
    }
}
