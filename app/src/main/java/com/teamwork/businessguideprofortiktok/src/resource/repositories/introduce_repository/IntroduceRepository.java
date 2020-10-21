package com.teamwork.businessguideprofortiktok.src.resource.repositories.introduce_repository;

import androidx.lifecycle.MutableLiveData;


import com.teamwork.businessguideprofortiktok.src.models.introduce_model.IntroduceModel;

import java.util.ArrayList;
import java.util.List;

//làm việc vs webserver
public class IntroduceRepository {
    private List<IntroduceModel> mArrayIntroduce = new ArrayList<>();
    private static IntroduceRepository instante;

    // Khởi tạo BannerRepository
    public static IntroduceRepository getInstante(){
        if(instante == null){
            instante = new IntroduceRepository();
        }
        return instante;
    }
    // Quan sát & lắng nghe dữ liệu
    public MutableLiveData<List<IntroduceModel>> getListIntroduce(){
        MutableLiveData<List<IntroduceModel>>arrayTmp = new MutableLiveData<>();
        setDataArrayIntroduce();
        arrayTmp.setValue(mArrayIntroduce);
        return arrayTmp;
    }
    //Tạo dữ liệu ảo
    private void setDataArrayIntroduce(){
        for (int i = 0; i <= 7; i++){
            IntroduceModel model = new IntroduceModel();
            model.setmImage("https://www.imgacademy.com/themes/custom/imgacademy/images/helpbox-contact.jpg");
            mArrayIntroduce.add(model);
        }
    }
}
