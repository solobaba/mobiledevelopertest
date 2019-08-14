package com.example.mobiledevelopertest.Competitions.CompetitionFixture

interface CompetitionFixtureView {
    fun showShimmer()
    fun stopShimmer()
    fun setFixture(items: MutableList<CompetitionFixtureModel>)
}