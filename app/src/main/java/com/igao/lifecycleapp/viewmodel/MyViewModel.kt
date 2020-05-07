package com.igao.lifecycleapp.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.igao.lifecycleapp.model.Job
import com.igao.lifecycleapp.model.database.AppDataBase
import com.igao.lifecycleapp.model.database.MyBuilder

class MyViewModel(context: Context) : ViewModel(), MyBuilder {

    val db: AppDataBase by lazy {
        recoverDb(context)
    }

    val jobs = MutableLiveData<List<Job>>()

    init {
        getAllJobs()
    }

    fun getAllJobs() {
        jobs.value = this.db.jobDAO().getAll()
    }

    fun loadallJobs(): LiveData<List<Job>> {
        getAllJobs()
        return jobs
    }

    fun deleteJob(job: Job) {
        this.db.jobDAO().deleteJob(job)
        getAllJobs()
    }

    fun save(name: String, description: String) {
        this.db.jobDAO().addJob(Job(name, description))
    }
}