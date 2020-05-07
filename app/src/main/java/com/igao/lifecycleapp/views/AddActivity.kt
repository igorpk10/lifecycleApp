package com.igao.lifecycleapp.views

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.igao.lifecycleapp.R
import com.igao.lifecycleapp.viewmodel.MyViewModel
import com.igao.lifecycleapp.viewmodel.factory.MyViewModelFactory
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {

    private lateinit var viewModel: MyViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        viewModel = ViewModelProvider(
            this,
            MyViewModelFactory(this.application)
        ).get(MyViewModel::class.java)


        button_save.setOnClickListener {
            if (!hasErrors()){
                viewModel.save(inputName.text.toString(), inputDescription.text.toString())
                finish()
            }
        }

    }

    private fun hasErrors(): Boolean {
        if(inputName.text.isNullOrEmpty()) {
            inputName.error = "I'm not accept blank texts D:"
            return true
        }
        if(inputDescription.text.isNullOrEmpty()) {
            inputDescription.error = "I'm not accept blank texts D:"
            return true
        }
        return false
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, AddActivity::class.java)
        }
    }
}
