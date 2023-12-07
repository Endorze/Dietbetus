package com.example.dietbetus

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class InsulinEntry(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "timestamp") val timestamp: String,
    @ColumnInfo(name = "info") val info: String
 )
