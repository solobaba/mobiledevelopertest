package com.example.mobiledevelopertest.Home

import com.example.mobiledevelopertest.Apimodel.Competitions.HomeCompetitionModel
import com.example.mobiledevelopertest.Apimodel.Player35.Match35
import com.example.mobiledevelopertest.Apimodel.Players.TeamPlayerModel
import com.example.mobiledevelopertest.Apimodel.Tables.TableModel
import com.example.mobiledevelopertest.Apimodel.Teams.TeamModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface HomeService {

    @GET("/v2/competitions")
     fun getCompetitions(@Header("X-Auth-Token") apiKey : String): Observable<HomeCompetitionModel>

   @GET("/v2/matches")
     fun getFixtures(@Header("X-Auth-Token") apiKey : String): Observable<Match35>

   @GET("/v2/competitions/{id}/standings")
     fun getTables(@Header("X-Auth-Token") apiKey : String, @Path("id") id : Int): Observable<TableModel>

    @GET("/v2/competitions/{id}/teams")
     fun getTeams(@Header("X-Auth-Token") apiKey : String, @Path("id") id : Int): Observable<TeamModel>

    @GET("/v2/teams/{id}")
    fun getTeamPlayers(@Header("X-Auth-Token") apiKey : String, @Path("id") id : Int): Observable<TeamPlayerModel>
}