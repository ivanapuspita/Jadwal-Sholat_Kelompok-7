package com.example.jadwalsalat.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class JadwalSalatResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("data")
    private ArrayList<DataItem> data;

    @SerializedName("status")
    private String status;

    public void setCode(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public void setData(ArrayList<DataItem> data){
        this.data = data;
    }

    public ArrayList<DataItem> getData(){
        return data;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }

    @Override
    public String toString(){
        return
                "JadwalSalatResponse{" +
                        "code = '" + code + '\'' +
                        ",data = '" + data + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}
