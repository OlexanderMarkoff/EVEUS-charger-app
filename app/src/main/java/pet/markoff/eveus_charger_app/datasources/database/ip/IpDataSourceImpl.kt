package pet.markoff.eveus_charger_app.datasources.database.ip

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pet.markoff.eveus_charger_app.datasources.DataResult
import pet.markoff.eveus_charger_app.datasources.DataResult.Success

class IpDataSourceImpl internal constructor(
    private val ipAddressDao: IpAddressDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : IpDataSource {

    override fun observeIp(): LiveData<DataResult<IpAddressEntity>> {
        return ipAddressDao.observeIp().map {
            Success(it)
        }
    }

    override suspend fun updateIp(task: IpAddressEntity) = withContext(ioDispatcher) {
        ipAddressDao.updateIp(task)
    }
}