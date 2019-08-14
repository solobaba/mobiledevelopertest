package com.example.mobiledevelopertest.Competitions.CompetitionTable

import android.util.Log
import com.example.mobiledevelopertest.Competitions.CompetitionInteractor
import com.example.mobiledevelopertest.Database.Tables.TablesEntity

class CompetitionTablePresenter(
    var competitionView: CompetitionTableView,
    val competitionInteractor: CompetitionTableInteractor
) : CompetitionInteractor.HandleEvents {

    fun loadTableCompetitions(competitionId: Int) {
        competitionInteractor.callTablecompetitions(competitionId, ::onCompetitionsTableLoaded)
        Log.d("okh", "loadingStandings")
    }

    override fun oncompetitionClick() {

    }

    override fun onLoadStart() {
    }

    override fun onLoadFinished() {
    }

    private fun onCompetitionsTableLoaded(competitionId: Int) {
        competitionView.apply {
            setTable(competitionId)
            Log.d("okh", "$competitionId presenter")
        }
    }

    fun onCompetitionTableClicked(position: Int, item: MutableList<TablesEntity>) {
        Log.d("okh", item[position].name + " team click")
    }
}