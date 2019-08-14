package com.example.mobiledevelopertest.Competitions.CompetitionTable

import com.example.mobiledevelopertest.Database.Competition.CompetitionEntity

interface CompetitionTableView {
    fun showShimmer()
    fun stopShimmer()
    fun setTable(competitionId : Int)
    fun getItemClicked(position: Int, item: MutableList<CompetitionEntity>)
}