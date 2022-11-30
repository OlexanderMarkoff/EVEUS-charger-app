package pet.markoff.eveus_charger_app.datasources.database.ip

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [IpAddressEntity::class], version = 1, exportSchema = false)
abstract class EveusDatabase: RoomDatabase() {
    abstract fun ipAddressDao(): IpAddressDao
}
