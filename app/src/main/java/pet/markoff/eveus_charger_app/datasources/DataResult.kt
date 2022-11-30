package pet.markoff.eveus_charger_app.datasources

import pet.markoff.eveus_charger_app.datasources.DataResult.Success

sealed class DataResult<out Result> {

    data class Success<out Result>(val data: Result) : DataResult<Result>()
    data class Error(val exception: Exception) : DataResult<Nothing>()
    object Loading : DataResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            Loading -> "Loading"
        }
    }
}

/**
 * `true` if [Result] is of type [Success] & holds non-null [Success.data].
 */
val DataResult<*>.succeeded
    get() = this is Success && data != null