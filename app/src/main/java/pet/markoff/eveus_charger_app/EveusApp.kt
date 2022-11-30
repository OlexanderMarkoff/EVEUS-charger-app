package pet.markoff.eveus_charger_app

import android.app.Application
import pet.markoff.eveus_charger_app.datasources.database.ip.IpRepository
import pet.markoff.eveus_charger_app.utils.ServiceLocator

class EveusApp: Application() {

    val ipAddressRepository: IpRepository
        get() = ServiceLocator.createIpRepository(this)
}