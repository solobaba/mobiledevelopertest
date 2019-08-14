package com.example.mobiledevelopertest.Database.Tables

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TablesDao{
    @Query("SELECT * FROM tablesTable WHERE competition LIKE :competitionid order by id")
    fun allTables(competitionid : Int):List<TablesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(tablesEntity: TablesEntity)
}