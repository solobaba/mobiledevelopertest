package com.example.mobiledevelopertest.Competitions.CompetitionFixture

import android.util.Log
import com.example.mobiledevelopertest.Competitions.CompetitionInteractor

class CompetitionFixturePresenter(
    var competitionView: CompetitionFixtureView,
    val competitionInteractor: CompetitionFixtureInteractor
) : CompetitionInteractor.HandleEvents {

    fun loadFixtureCompetitions() {
        competitionInteractor.callFixturecompetitions(::onCompetitionsFixtureLoaded)
        Log.d("okh", "loadingCompetitions")
    }


    override fun oncompetitionClick() {
    }

    override fun onLoadStart() {
    }

    override fun onLoadFinished() {
        competitionView.apply {
            stopShimmer()
        }
    }

    private fun onCompetitionsFixtureLoaded(items: MutableList<CompetitionFixtureModel>) {
        competitionView.apply {
            setFixture(items)
        }
    }

    fun onCompetitionFixtureClicked(position: Int, item: MutableList<CompetitionFixtureModel>) {
        Log.d("okh", item[position].teamName + " team click")

    }

}