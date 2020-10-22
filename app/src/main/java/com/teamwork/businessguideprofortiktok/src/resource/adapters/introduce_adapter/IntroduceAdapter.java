package com.teamwork.businessguideprofortiktok.src.resource.adapters.introduce_adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;

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
            case 4:
                return new FragmentSlider4(layoutInflater.inflate(mArrayLayout.get(4), parent, false));
            case 5:
                return new FragmentSlider5(layoutInflater.inflate(mArrayLayout.get(5), parent, false));
            case 6:
                return new FragmentSlider6(layoutInflater.inflate(mArrayLayout.get(6), parent, false));
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (position) {
            case 0:
                final FragmentSlider0 fragmentSlider0 = (FragmentSlider0) holder;
                listenerOnclickedSlider0(fragmentSlider0);
                break;
            case 1:
                FragmentSlider1 fragmentSlider1 = (FragmentSlider1) holder;
                break;
            case 2:
                FragmentSlider2 fragmentSlider2 = (FragmentSlider2) holder;
                listenerOnclickedSlider2(fragmentSlider2);
                break;
            case 3:
                FragmentSlider3 fragmentSlider3 = (FragmentSlider3) holder;
                break;
            case 4:
                final FragmentSlider4 fragmentSlider4 = (FragmentSlider4) holder;
                listenerOnclicked(fragmentSlider4);
                break;
            case 5:
                FragmentSlider5 fragmentSlider5 = (FragmentSlider5) holder;
                break;
            case 6:
                FragmentSlider6 fragmentSlider6 = (FragmentSlider6) holder;
                listenerOnclickedSlider6(fragmentSlider6);
                break;
        }
    }

    private void listenerOnclickedSlider6(FragmentSlider6 fragmentSlider6) {
        fragmentSlider6.mBtnGetCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntroduceActivity.scroollView(4);
            }
        });
    }

    private void listenerOnclickedSlider2(FragmentSlider2 fragmentSlider2) {
        fragmentSlider2.mBtnGetCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntroduceActivity.scroollView(4);
            }
        });
    }

    private void listenerOnclickedSlider0(FragmentSlider0 fragmentSlider0) {
        fragmentSlider0.mBtnGetCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntroduceActivity.scroollView(4);
            }
        });
    }

    private void listenerOnclicked(final FragmentSlider4 fragmentSlider4) {
        fragmentSlider4.mRadioB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentSlider4.mLinearIntroduce4.setVisibility(View.VISIBLE);
            }
        });
        fragmentSlider4.mRadioA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentSlider4.mLinearIntroduce4.setVisibility(View.GONE);
            }
        });
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
        private RadioButton mRadioB, mRadioA;
        private LinearLayout mLinearIntroduce4;

        public FragmentSlider4(@NonNull View itemView) {
            super(itemView);
            mRadioB = itemView.findViewById(R.id.radio_b);
            mLinearIntroduce4 = itemView.findViewById(R.id.linearIntroduce4);
            mRadioA = itemView.findViewById(R.id.radio_a);
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
}
