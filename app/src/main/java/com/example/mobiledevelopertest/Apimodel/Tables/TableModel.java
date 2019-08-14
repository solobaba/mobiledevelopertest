
package com.example.mobiledevelopertest.Apimodel.Tables;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TableModel {

    @SerializedName("filters")
    @Expose
    public Filters filters;
    @SerializedName("competition")
    @Expose
    public Competition competition;
    @SerializedName("season")
    @Expose
    public Season season;
    @SerializedName("standings")
    @Expose
    public final List<Standing> standings = null;

}
