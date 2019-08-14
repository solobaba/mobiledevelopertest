package com.example.mobiledevelopertest.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mobiledevelopertest.Database.Competition.CompetitionDao
import com.example.mobiledevelopertest.Database.Competition.CompetitionEntity
import com.example.mobiledevelopertest.Database.Fixture.FixtureDao
import com.example.mobiledevelopertest.Database.Fixture.FixtureEntity
import com.example.mobiledevelopertest.Database.Tables.TablesDao
import com.example.mobiledevelopertest.Database.Tables.TablesEntity
import com.example.mobiledevelopertest.Database.Team.TeamsDao
import com.example.mobiledevelopertest.Database.Team.TeamsEntity
import com.example.mobiledevelopertest.Database.TeamPlayer.TeamPlayersDao
import com.example.mobiledevelopertest.Database.TeamPlayer.TeamPlayersEntity

@Database(entities = [CompetitionEntity::class, FixtureEntity::class, TablesEntity::class, TeamsEntity::class, TeamPlayersEntity::class], version = 2)

abstract class RoomSingleton : RoomDatabase() {

    abstract fun competitionDao(): CompetitionDao
    abstract fun fixtureDao(): FixtureDao
    abstract fun tablesDao() : TablesDao
    abstract fun teamsDao() : TeamsDao
    abstract fun teamPlayerDao() : TeamPlayersDao

    companion object {
        private var INSTANCE: RoomSingleton? = null
        fun getInstance(context: Context): RoomSingleton {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    RoomSingleton::class.java,
                    "roomdb")
                    .build()
            }
            return INSTANCE as RoomSingleton
        }
    }
}
