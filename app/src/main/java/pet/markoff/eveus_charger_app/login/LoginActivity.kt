package pet.markoff.eveus_charger_app.login

import android.os.Bundle
import android.text.InputFilter
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import pet.markoff.eveus_charger_app.R
import pet.markoff.eveus_charger_app.datasources.database.ip.IpAddressViewModel
import pet.markoff.eveus_charger_app.utils.EveusViewModelFactory
import pet.markoff.eveus_charger_app.utils.IpAddressInputFilter

class LoginActivity : AppCompatActivity() {

    private val viewModel: IpAddressViewModel by viewModels { EveusViewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupViews()
        setupViewModels()
    }

    private fun setupViews() {
        et_ip_section1.filters = arrayOf<InputFilter>(IpAddressInputFilter())
        et_ip_section2.filters = arrayOf<InputFilter>(IpAddressInputFilter())
        et_ip_section3.filters = arrayOf<InputFilter>(IpAddressInputFilter())
        et_ip_section4.filters = arrayOf<InputFilter>(IpAddressInputFilter())
    }

    private fun setupViewModels() {
        viewModel.ipAddress.observe(this) { ipResult ->
            print("Result")
        }
    }
}