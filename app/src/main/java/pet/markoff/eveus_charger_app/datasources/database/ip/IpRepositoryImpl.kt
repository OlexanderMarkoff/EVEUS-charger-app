package pet.markoff.eveus_charger_app.datasources.database.ip

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import pet.markoff.eveus_charger_app.datasources.DataResult

class IpRepositoryImpl(
    private val ipLocalDataSource: IpDataSource
) : IpRepository {

    override fun observeIp(): LiveData<DataResult<IpAddressEntity>> {
            return ipLocalDataSource.observeIp()
    }

    override suspend fun updateIp(ipAddress: IpAddressEntity) {
        coroutineScope {
            launch { ipLocalDataSource.updateIp(ipAddress) }
        }
    }
}