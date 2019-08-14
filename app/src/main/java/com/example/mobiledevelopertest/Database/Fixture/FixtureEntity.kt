package com.example.mobiledevelopertest.Database.Fixture

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fixtureTable")
data class FixtureEntity(

    @PrimaryKey
    @ColumnInfo(name = "id")
    var fixtureID: Int,

    @ColumnInfo(name = "count")
    var fixtureCount: String,

    @ColumnInfo(name = "time")
    var fixtureTime: String,

    @ColumnInfo(name = "status")
        var fixtureStatus: String,

    @ColumnInfo(name = "homeTeam")
        var fixtureHomeTeam: String,

    @ColumnInfo(name = "awayTeam")
        var fixtureAwayTeam: String,


    @ColumnInfo(name = "homeTeamScore")
         var fixtureHomeTeamScore: String,

    @ColumnInfo(name = "awayTeamScore")
    var fixtureAwayTeamScore: String

)
