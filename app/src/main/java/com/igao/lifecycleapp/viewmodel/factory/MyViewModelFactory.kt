package com.igao.lifecycleapp.viewmodel.factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.igao.lifecycleapp.viewmodel.MyViewModel

class MyViewModelFactory(
    val application: Application
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MyViewModel(application) as T
    }
}