package com.igao.lifecycleapp.model.dao

import androidx.room.*
import com.igao.lifecycleapp.model.Job

@Dao
interface JobDAO {
    @Query("SELECT * FROM Job")
    fun getAll(): List<Job>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addJob(job: Job)

    @Delete
    fun deleteJob(job: Job)
}