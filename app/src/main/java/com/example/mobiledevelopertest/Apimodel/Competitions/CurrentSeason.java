package com.example.mobiledevelopertest.Apimodel.Competitions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrentSeason {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("startDate")
    @Expose
    public String startDate;
    @SerializedName("endDate")
    @Expose
    public String endDate;
    @SerializedName("currentMatchday")
    @Expose
    public Integer currentMatchday;
    @SerializedName("winner")
    @Expose
    public Object winner;

}
