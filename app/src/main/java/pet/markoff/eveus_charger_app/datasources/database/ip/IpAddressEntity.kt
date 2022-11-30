package pet.markoff.eveus_charger_app.datasources.database.ip

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import pet.markoff.eveus_charger_app.datasources.database.DBConstants

@Entity(tableName = DBConstants.IP_TABLE_NAME)
data class IpAddressEntity @JvmOverloads constructor(
    @ColumnInfo(name = "section1", defaultValue = "192") var section1: String = "",
    @ColumnInfo(name = "section2", defaultValue = "168") var section2: String = "",
    @ColumnInfo(name = "section3", defaultValue = "4") var section3: String = "",
    @ColumnInfo(name = "section4", defaultValue = "1") var section4: String = "",
    @PrimaryKey @ColumnInfo(name = "id") var id: String = "1"
)