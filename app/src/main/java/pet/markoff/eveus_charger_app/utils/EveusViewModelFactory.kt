package pet.markoff.eveus_charger_app.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import pet.markoff.eveus_charger_app.EveusApp
import pet.markoff.eveus_charger_app.datasources.database.ip.IpAddressViewModel

@Suppress("UNCHECKED_CAST")
val EveusViewModelFactory = object : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T =
        with(modelClass) {
            val application = checkNotNull(extras[APPLICATION_KEY]) as EveusApp
            val ipAddressRepository = application.ipAddressRepository
            when {
                isAssignableFrom(IpAddressViewModel::class.java) ->
                    IpAddressViewModel(ipAddressRepository)
                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
}