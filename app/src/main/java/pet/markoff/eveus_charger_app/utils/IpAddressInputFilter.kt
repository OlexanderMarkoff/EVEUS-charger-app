package pet.markoff.eveus_charger_app.utils

import android.text.InputFilter
import android.text.Spanned

class IpAddressInputFilter(private val max: Int = 255, private val min: Int = 0, private val length: Int = 3) : InputFilter {

    override fun filter(
        source: CharSequence,
        start: Int,
        end: Int,
        dest: Spanned,
        dstart: Int,
        dend: Int
    ): CharSequence? {
        try {
            val replacement = source.subSequence(start, end).toString()
            val newVal = dest.toString().substring(0, dstart) + replacement + dest.toString()
                .substring(dend, dest.toString().length)
            if (newVal.length > 1 && newVal.startsWith("0")) return ""
            val input = newVal.toInt()
            if (input in min..max &&
                newVal.length <= length) return null
        } catch (_: NumberFormatException) { }
        return ""
    }

    private fun isInRange(a: Int, b: Int, c: Int): Boolean {
        return if (b > a) c >= a && c <= b else c >= b && c <= a
    }
}


