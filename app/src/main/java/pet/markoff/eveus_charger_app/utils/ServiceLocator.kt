package pet.markoff.eveus_charger_app.utils

import android.content.Context
import androidx.annotation.VisibleForTesting
import androidx.room.Room
import kotlinx.coroutines.runBlocking
import pet.markoff.eveus_charger_app.datasources.database.ip.*

object ServiceLocator {
    private val lock = Any()
    private var database: EveusDatabase? = null
    @Volatile
    var ipRepository: IpRepository? = null
        @VisibleForTesting set

    fun provideTasksRepository(context: Context): IpRepository {
        synchronized(this) {
            return ipRepository ?: ipRepository ?: createIpRepository(context)
        }
    }

    fun createIpRepository(context: Context): IpRepository {
        val newRepo =
            IpRepositoryImpl(createIpLocalDataSource(context))
        ipRepository = newRepo
        return newRepo
    }

    private fun createIpLocalDataSource(context: Context): IpDataSource {
        val database = database ?: createDataBase(context)
        return IpDataSourceImpl(database.ipAddressDao())
    }

    private fun createDataBase(context: Context): EveusDatabase {
        val result = Room.databaseBuilder(
            context.applicationContext,
            EveusDatabase::class.java, DB_NAME
        ).build()
        database = result
        return result
    }

    @VisibleForTesting
    fun resetRepository() {
        synchronized(lock) {
            // Clear all data to avoid test pollution.
            database?.apply {
                clearAllTables()
                close()
            }
            database = null
            ipRepository = null
        }
    }
}

private const val DB_NAME = "Eveus.db"