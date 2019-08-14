package com.example.mobiledevelopertest.Competitions

import com.example.mobiledevelopertest.Competitions.CompetitionFixture.CompetitionFixtureModel
import com.example.mobiledevelopertest.Competitions.CompetitionTeam.CompetitionTeamModel
import com.example.mobiledevelopertest.Database.Tables.TablesEntity

interface CompetitionView {
    fun showShimmer()
    fun stopShimmer()
    fun setTable(items: MutableList<TablesEntity>)
    fun setTeams(items: MutableList<CompetitionTeamModel>)
    fun setFixture(items: MutableList<CompetitionFixtureModel>)
}