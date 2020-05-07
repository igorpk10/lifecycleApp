package com.igao.lifecycleapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "job")
data class Job(

    @PrimaryKey @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String
) {

}