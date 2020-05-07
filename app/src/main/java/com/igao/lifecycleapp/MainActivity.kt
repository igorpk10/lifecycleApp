package com.igao.lifecycleapp

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.igao.lifecycleapp.model.Job
import com.igao.lifecycleapp.viewmodel.MyViewModel
import com.igao.lifecycleapp.viewmodel.factory.MyViewModelFactory
import com.igao.lifecycleapp.views.AddActivity

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity(), MainAdapter.InteractionAdapter {

    private val viewModel: MyViewModel by lazy {
        ViewModelProvider(
            this,
            MyViewModelFactory(this.application)
        ).get(MyViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.loadallJobs().observe(this, Observer {
            setupviews(it)
        })

        button_add.setOnClickListener { view ->
            startActivity(AddActivity.newIntent(this))
        }
    }

    override fun onRestart() {
        super.onRestart()
        viewModel.getAllJobs()
    }

    private fun setupviews(list: List<Job>) {
        main_recycler.layoutManager = LinearLayoutManager(this)
        main_recycler.adapter = MainAdapter(list, this, this)
    }

    override fun onInteractonAdapter(job: Job) {
        viewModel.deleteJob(job)
    }

}
