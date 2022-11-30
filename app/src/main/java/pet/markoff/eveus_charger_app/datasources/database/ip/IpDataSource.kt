package pet.markoff.eveus_charger_app.datasources.database.ip

import androidx.lifecycle.LiveData
import pet.markoff.eveus_charger_app.datasources.DataResult

interface IpDataSource {
    fun observeIp(): LiveData<DataResult<IpAddressEntity>>

    suspend fun updateIp(task: IpAddressEntity)
}