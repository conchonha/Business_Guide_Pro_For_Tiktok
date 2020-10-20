package com.teamwork.businessguideprofortiktok.src.resource.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.teamwork.businessguideprofortiktok.src.models.IntroduceModel;
import com.teamwork.businessguideprofortiktok.src.resource.repositories.IntroduceRepository;

import java.util.List;

public class IntroduceViewModel extends ViewModel {
    private MutableLiveData<List<IntroduceModel>> arrayIntroduce;
    private IntroduceRepository introduceRepository;

    public void init(){
        if(arrayIntroduce != null){
            return;
        }
        introduceRepository = IntroduceRepository.getInstante();
        arrayIntroduce = introduceRepository.getListIntroduce();
    }

    public MutableLiveData<List<IntroduceModel>> getListIntroduce(){
        return arrayIntroduce;
    }

}
