package pet.markoff.eveus_charger_app.datasources.database.ip

import androidx.lifecycle.*
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import pet.markoff.eveus_charger_app.EveusApp
import pet.markoff.eveus_charger_app.datasources.DataResult

class IpAddressViewModel( private val ipRepository: IpRepository
) : ViewModel() {
    private val _forceUpdate = MutableLiveData<Boolean>(false)

    val ipAddress: LiveData<DataResult<IpAddressEntity>> = ipRepository.observeIp()

//    companion object {
//        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
//            @Suppress("UNCHECKED_CAST")
//            override fun <T : ViewModel> create(
//                modelClass: Class<T>,
//                extras: CreationExtras
//            ): T {
//                // Get the Application object from extras
//                val application = checkNotNull(extras[APPLICATION_KEY])
//                // Create a SavedStateHandle for this ViewModel from extras
//                val savedStateHandle = extras.createSavedStateHandle()
//
//                return IpAddressViewModel(
//                    (application as EveusApp).ipAddressRepository
//                ) as T
//            }
//        }
//    }
}