package com.teamwork.cookiesproject.src.cores.services;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataService {
    @GET("model/accessories/getDataAccessories")
    Call<String> getDataAccessories();

}