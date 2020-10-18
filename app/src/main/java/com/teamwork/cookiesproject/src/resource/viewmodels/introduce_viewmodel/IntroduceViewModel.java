package com.teamwork.cookiesproject.src.resource.viewmodels.introduce_viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.teamwork.cookiesproject.src.models.introduce_model.IntroduceModel;
import com.teamwork.cookiesproject.src.resource.repositories.introduce_repository.IntroduceRepository;

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
