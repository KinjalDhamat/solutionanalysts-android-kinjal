
package com.demo.androidtest.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.demo.androidtest.data.local.AuthDao
import com.demo.androidtest.data.local.model.User

/**
 * The Room Database that contains the User table.
 *
 *
 */
@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun authDao(): AuthDao
}
