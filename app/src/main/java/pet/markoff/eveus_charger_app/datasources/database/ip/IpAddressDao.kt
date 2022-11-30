package pet.markoff.eveus_charger_app.datasources.database.ip

import androidx.lifecycle.LiveData
import androidx.room.*
import pet.markoff.eveus_charger_app.datasources.database.DBConstants

@Dao
interface IpAddressDao {

    @Query("SELECT * FROM ${DBConstants.IP_TABLE_NAME}")
    fun observeIp(): LiveData<IpAddressEntity>

    @Update
    suspend fun updateIp(ipAddress: IpAddressEntity)
}