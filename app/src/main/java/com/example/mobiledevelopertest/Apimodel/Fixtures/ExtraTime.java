package com.example.mobiledevelopertest.Apimodel.Fixtures;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExtraTime {

    @SerializedName("homeTeam")
    @Expose
    public Object homeTeam;
    @SerializedName("awayTeam")
    @Expose
    public Object awayTeam;

}