package com.example.mobiledevelopertest.Apimodel.Fixtures;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Competition {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;

}
