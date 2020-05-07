package com.igao.lifecycleapp.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.igao.lifecycleapp.model.Job
import com.igao.lifecycleapp.model.dao.JobDAO

@Database(entities = arrayOf(Job::class), version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun jobDAO(): JobDAO
}