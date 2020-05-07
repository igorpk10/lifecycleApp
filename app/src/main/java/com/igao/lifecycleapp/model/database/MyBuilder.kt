package com.igao.lifecycleapp.model.database

import android.content.Context
import androidx.room.Room

interface MyBuilder {
    fun recoverDb(context: Context): AppDataBase {
        return Room.databaseBuilder(context, AppDataBase::class.java, "mydb").allowMainThreadQueries().build()
    }
}