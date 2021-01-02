import android.util.Log
import com.demo.androidtest.data.local.AuthDao
import com.demo.androidtest.data.local.model.User
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Concrete implementation of a data source as a db.
 */
class AuthLocalDataSource internal constructor(
    private val authDao: AuthDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend fun saveUser(user: User) = withContext(ioDispatcher) {
        authDao.insertUser(user)
        Log.e("Tag", "===> Database $user remote ${authDao.getUser()}")

    }

}
