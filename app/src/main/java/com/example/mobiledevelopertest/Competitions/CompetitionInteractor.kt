package com.example.mobiledevelopertest.Competitions

import androidx.appcompat.app.AppCompatActivity
import com.example.mobiledevelopertest.Competitions.CompetitionFixture.CompetitionFixtureModel
import com.example.mobiledevelopertest.Competitions.CompetitionTeam.CompetitionTeamModel
import com.example.mobiledevelopertest.Database.Tables.TablesEntity

class CompetitionInteractor : AppCompatActivity() {

    interface HandleEvents {
        fun oncompetitionClick()
        fun onLoadStart()
        fun onLoadFinished()
    }

    fun callTeamcompetitions(callback: (MutableList<CompetitionTeamModel>) -> Unit) {

    }

    fun callFixturecompetitions(callback: (MutableList<CompetitionFixtureModel>) -> Unit) {

    }

    private fun createCompetitionTableModel(): MutableList<TablesEntity> {

        return ArrayList()
    }

}