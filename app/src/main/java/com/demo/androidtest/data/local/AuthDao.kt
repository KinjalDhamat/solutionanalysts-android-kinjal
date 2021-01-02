package com.demo.androidtest.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.demo.androidtest.data.local.model.User


/**
 * Data Access Object for the user table.
 */
@Dao
interface AuthDao {

    /**
     * Insert a task in the database. If the task already exists, replace it.
     *
     * @param user the user to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM User")
    suspend fun getUser(): List<User>
}
