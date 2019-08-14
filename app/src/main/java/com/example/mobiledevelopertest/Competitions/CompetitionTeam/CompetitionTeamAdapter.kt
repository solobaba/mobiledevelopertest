package com.example.mobiledevelopertest.Competitions.CompetitionTeam

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.mobiledevelopertest.Database.Team.TeamsEntity
import com.example.mobiledevelopertest.R

class CompetitionTeamAdapter() : androidx.recyclerview.widget.RecyclerView.Adapter<CompetitionTeamAdapter.MyViewHolder>() {

    var context : Context? = null
    var competitionTeamList : MutableList<TeamsEntity>? = null
    lateinit var listener : (Int, MutableList<TeamsEntity>) -> Unit

    constructor(context: FragmentActivity?, competitionTeamList: MutableList<TeamsEntity>?, listener: (Int, MutableList<TeamsEntity>) -> Unit) : this() {
        this.context = context
        this.competitionTeamList = competitionTeamList
        this.listener = listener
    }

    class MyViewHolder(v: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(v) {

        var competitionTeamLogo :  ImageView? = null
        var competitionTeamName :  TextView? = null
        var card_view :  androidx.cardview.widget.CardView? = null

        init {
            this.competitionTeamLogo = v.findViewById(R.id.competitionTeamLogo)
            this.competitionTeamName = v.findViewById(R.id.competitionTeamName)
            this.card_view = v.findViewById(R.id.card_view)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView : View = LayoutInflater.from(parent.context).inflate(R.layout.competition_team_card, parent, false)

        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return  competitionTeamList!!.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = competitionTeamList!![position]
        Log.d("okh", competitionTeamList.toString() +" adapts")
        Glide.with(this!!.context!!)
            .load(item.crestUrl)
            .thumbnail(0.5f)
            .override(200, 200)
            .placeholder(R.drawable.ic_placeholder)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(holder.competitionTeamLogo!!)
        Log.d("okh", item.teamName+" from team" + item.tablesID +" team id")
        holder.competitionTeamLogo!!.setImageResource(R.mipmap.ic_launcher_round)
        holder.competitionTeamName!!.text = item.teamName
        holder.card_view!!.setOnClickListener { listener(position, competitionTeamList!!) }
    }
}
