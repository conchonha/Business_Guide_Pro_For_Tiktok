package com.teamwork.businessguideprofortiktok.src.cores.services;

import com.teamwork.businessguideprofortiktok.src.utils.Constant;

public class APIServices {
    public static DataService getService() {
        return APIRetrofitClient.getClient(Constant.mBaseUrlGoogleSheet).create(DataService.class);
    }
}