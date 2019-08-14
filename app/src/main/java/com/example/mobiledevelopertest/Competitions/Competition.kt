package com.example.mobiledevelopertest.Competitions

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.mobiledevelopertest.Competitions.CompetitionTable.CompetitionTableFragment
import com.example.mobiledevelopertest.Competitions.CompetitionTable.CompetitionTableView
import com.example.mobiledevelopertest.Competitions.CompetitionTeam.CompetitionTeamFragment
import com.example.mobiledevelopertest.Database.Competition.CompetitionEntity
import com.example.mobiledevelopertest.Competitions.CompetitionTable.CompetitionTableInteractor
import com.example.mobiledevelopertest.Competitions.CompetitionTable.CompetitionTablePresenter
import com.example.mobiledevelopertest.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_competition.*

class Competition : AppCompatActivity(), CompetitionTableView {

    override fun setTable(competitionId: Int) {

    }

    private val competitionPresenter = CompetitionTablePresenter(this, CompetitionTableInteractor())

    override fun showShimmer() {

    }

    override fun stopShimmer() {

    }


    override fun getItemClicked(position: Int, item: MutableList<CompetitionEntity>) {

    }

    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null
    companion object {
        var competitionID : Int = 0
    }
    lateinit var context : Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_competition)
        setSupportActionBar(toolbar)
        val competitionTitle = intent

        competitionID = competitionTitle.getStringExtra(getString(R.string.competition)).toInt()
        val competitionName = competitionTitle.getStringExtra(getString(R.string.competition_title))
        Log.d("okh", "$competitionID $competitionName")

        title = competitionName
        supportActionBar!!.title = competitionName
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        // Set up the ViewPager with the sections adapter.
        competitionContainer.adapter = mSectionsPagerAdapter
       // loadTableCompetitions
        competitionContainer.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(competitionContainer))

    }

    override fun onResume() {
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        // Set up the ViewPager with the sections adapter.
        competitionContainer.adapter = mSectionsPagerAdapter
        // loadTableCompetitions
        competitionContainer.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(competitionContainer))
        super.onResume()
    }

    inner class SectionsPagerAdapter(fm: androidx.fragment.app.FragmentManager) : androidx.fragment.app.FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): androidx.fragment.app.Fragment {
            var fragment : Fragment? = null
            when (position) {
                0 -> fragment = CompetitionTableFragment.newInstance(competitionID)
                1 -> fragment = CompetitionTableFragment.newInstance(competitionID)
                2 -> fragment = CompetitionTeamFragment.newInstance(competitionID)
            }
            return fragment!!
        }

        override fun getCount(): Int {
            // Show 3 total pages.
            return 3
        }
    }
}
