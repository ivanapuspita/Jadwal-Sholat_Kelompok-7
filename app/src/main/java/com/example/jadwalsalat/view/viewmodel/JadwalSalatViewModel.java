package com.example.jadwalsalat.view.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.jadwalsalat.model.DataItem;
import com.example.jadwalsalat.model.JadwalSalatResponse;
import com.example.jadwalsalat.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JadwalSalatViewModel extends ViewModel {
    private ApiMain apiMain;

    private MutableLiveData<ArrayList<DataItem>> listJadwalSalat = new MutableLiveData<ArrayList<DataItem>>();

    public void setJadwalSalat() {
        if (this.apiMain == null) {
            apiMain = new ApiMain();
        }

        apiMain.getApiJadwal().getJadwalSalat().enqueue(new Callback<JadwalSalatResponse>() {
            @Override
            public void onResponse(Call<JadwalSalatResponse> call, Response<JadwalSalatResponse> response) {
                JadwalSalatResponse responseSalat = response.body();
                if (responseSalat != null && responseSalat.getData() != null) {
                    ArrayList<DataItem> data = responseSalat.getData();
                    listJadwalSalat.postValue(data);
                    Log.d("JadwalSalatViewModel", "onSuccess: "+response.body());
                }
            }

            @Override
            public void onFailure(Call<JadwalSalatResponse> call, Throwable t) {
                Log.e("JadwalSalatViewModel", "onFailure: "+t.getMessage());

            }
        });
    }
    public LiveData<ArrayList<DataItem>> getJadwaSalat(){
        return listJadwalSalat;
    }

}
