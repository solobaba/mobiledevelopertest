package com.example.mobiledevelopertest.Database.Competition

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CompetitionDao{
    @Query("SELECT * FROM footballTable")
    fun allCompetitions():List<CompetitionEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(competitionEntity: CompetitionEntity)
}