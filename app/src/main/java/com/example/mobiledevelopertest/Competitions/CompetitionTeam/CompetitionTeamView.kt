package com.example.mobiledevelopertest.Competitions.CompetitionTeam

import com.example.mobiledevelopertest.Database.Team.TeamsEntity

interface CompetitionTeamView {
    fun showShimmer()
    fun stopShimmer()
    fun setTeams(competitionId: Int)
    fun openTeamPlayerPage(position : Int, items: MutableList<TeamsEntity>)
}