package com.example.mobiledevelopertest.Competitions.CompetitionTeam.TeamPlayer

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.mobiledevelopertest.App
import com.example.mobiledevelopertest.Database.TeamPlayer.TeamPlayersEntity
import com.example.mobiledevelopertest.Database.Team.TeamsEntity
import com.example.mobiledevelopertest.R
import kotlinx.android.synthetic.main.activity_team_player.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class TeamPlayer : AppCompatActivity(), TeamPlayerView {

    private val teamPlayerPresenter = TeamPlayerPresenter(this, TeamPlayerInteractor())

    var team: TeamsEntity? = null

    override fun showShimmer() {

    }

    override fun stopShimmer() {

    }

    override fun onResume() {
        callTeamPlayer()
        super.onResume()
    }

    override fun setTeamPlayer(teamId: Int) {

        doAsync {
            var teamPlayersList = App.getInstance(this@TeamPlayer).teamPlayerDao().allTeams(team!!.tablesID)
            Log.d("okh", "$teamPlayersList from teamplayerfragment")

            uiThread {
                var teamsPlayersEntity: MutableList<TeamPlayersEntity> = ArrayList()
                for (football in 0 until teamPlayersList.size) {
                    teamsPlayersEntity.add(football, teamPlayersList[football])
                    Log.d("okh", teamPlayersList[football].teamName + " from team fragment")

                    var homeAdapter =
                        TeamPlayerAdapter(this@TeamPlayer, teamsPlayersEntity, teamPlayerPresenter::onTeamPlayerClicked)
                    playerRecylerView.adapter = homeAdapter
                }
            }
        }
    }

    fun callTeamPlayer() {
        doAsync {
            var teamPlayersList = App.getInstance(this@TeamPlayer).teamPlayerDao().allTeams(team!!.tablesID)
            Log.d("okh", "$teamPlayersList from teamplayerfragment")

            uiThread {
                var teamsPlayersEntity: MutableList<TeamPlayersEntity> = ArrayList()
                for (football in 0 until teamPlayersList.size) {
                    teamsPlayersEntity.add(football, teamPlayersList[football])
                    Log.d("okh", teamPlayersList[football].teamName + " from team fragment")

                    var homeAdapter =
                        TeamPlayerAdapter(this@TeamPlayer, teamsPlayersEntity, teamPlayerPresenter::onTeamPlayerClicked)
                    playerRecylerView.adapter = homeAdapter
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_player)

        var mLayoutManager = androidx.recyclerview.widget.GridLayoutManager(this, 1)
        playerRecylerView.layoutManager = mLayoutManager
        val playerIntent = intent
        team = playerIntent.extras!!.getSerializable(getString(R.string.competition)) as TeamsEntity
        playerTeamName.text = team!!.teamName
        teamPlayerPresenter.loadTeamPlayer(team!!.tablesID)
        playerCancel.setOnClickListener {
            finish()
        }
    }
}
