package com.teamwork.businessguideprofortiktok.src.cores.services;

public class APIServices {
    private static String baseurl = "https://script.google.com/";

    public static DataService getService() {
        return APIRetrofitClient.getClient(baseurl).create(DataService.class);
    }
}