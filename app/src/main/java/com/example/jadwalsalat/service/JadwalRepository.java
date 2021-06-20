package com.example.jadwalsalat.service;

import com.example.jadwalsalat.model.JadwalSalatResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JadwalRepository {
    @GET("v1/calendarByAddress?address=yogyakarta&method=2&month=juni&year=2021")
    Call<JadwalSalatResponse> getJadwalSalat();

}
