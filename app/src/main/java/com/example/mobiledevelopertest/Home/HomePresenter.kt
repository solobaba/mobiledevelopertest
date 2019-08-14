package com.example.mobiledevelopertest.Home

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.mobiledevelopertest.Database.Competition.CompetitionEntity
import com.example.mobiledevelopertest.Database.Fixture.FixtureEntity
import com.example.mobiledevelopertest.Database.Tables.TablesEntity

class HomePresenter(var homeView: HomeView, val homeInteractor: HomeInteractor) : AppCompatActivity() {

    fun onLoadStart() {
        homeView.apply {
            showShimmer()
        }
    }

    fun onLoadFinished() {
        homeView.apply {
            stopShimmer()
        }
    }

    fun loadFixtures() {
        onLoadStart()
        homeInteractor.callFixtures(::onFixturesLoaded)
    }

    fun loadCompetitions() {
        onLoadStart()
        homeInteractor.callCompetitions(::onCompetitionsLoaded)
    }

    private fun onFixturesLoaded(items: FixtureEntity) {
        homeView.apply {
            setFixtureItems()
        }
    }

    private fun onCompetitionsLoaded(items: CompetitionEntity) {
        homeView.apply {
            setCompetitionItems()
        }
    }

    fun onFixtureItemClicked(position: Int, item: MutableList<FixtureEntity>) {
        homeView.apply {
            Log.d("okh", item[position].fixtureAwayTeam + position)
        }
    }

    fun onCompetitionItemClicked(position: Int, item: MutableList<CompetitionEntity>) {

        Log.d("okh", item[position].competitionID.toString() + " clickcomp")
        homeView.apply {

            openCompetitionsPage(item[position].competitionID, item[position].competitionName)
        }
    }

    fun onTableLoaded(position: Int, item: MutableList<TablesEntity>) {

        Log.d("okh", item[position].name + " clickcomp")
        homeView.apply {
            openCompetitionsPage(item[position].tablesID, item[position].name)
        }
    }
}