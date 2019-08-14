package com.example.mobiledevelopertest.Home

interface HomeView {

    //the HomeView interfaces
    fun showShimmer()
    fun stopShimmer()
    fun setFixtureItems()
    fun setCompetitionItems()
    fun openCompetitionsPage(competitionID : Int, competitionName: String)
}