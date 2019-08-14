package com.example.mobiledevelopertest.Competitions.CompetitionTeam.TeamPlayer

import android.util.Log
import com.example.mobiledevelopertest.Database.TeamPlayer.TeamPlayersEntity
import com.example.mobiledevelopertest.Competitions.CompetitionInteractor

class TeamPlayerPresenter(var teamPlayerView: TeamPlayerView, val teamPlayerInteractor: TeamPlayerInteractor) :
    CompetitionInteractor.HandleEvents {

    fun loadTeamPlayer(teamId: Int) {
        teamPlayerInteractor.callTeamPlayer(teamId, ::onTeamPlayerLoaded)
        Log.d("okh", "loadingCompetitions")
    }

    override fun oncompetitionClick() {
    }

    override fun onLoadStart() {
    }

    override fun onLoadFinished() {
    }


    private fun onTeamPlayerLoaded(teamId: Int) {
        teamPlayerView.apply {
            setTeamPlayer(teamId)
        }
    }

    fun onTeamPlayerClicked(position: Int, item: MutableList<TeamPlayersEntity>) {
        Log.d("okh", item[position].teamName + " team click")

    }
}