package com.neftenergies.ui.register.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.neftenergies.BR
import com.neftenergies.R
import com.neftenergies.base.BaseActivityWrapper
import com.neftenergies.databinding.ActivityRegisterBinding
import com.neftenergies.ui.loginorregister.viewmodel.LoginOrRegisterViewModel
import com.neftenergies.ui.register.RegisterNavigator
import com.neftenergies.ui.register.viewmodel.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterActivity : BaseActivityWrapper<ActivityRegisterBinding, RegisterNavigator, RegisterViewModel>(),
RegisterNavigator {
    private val registerViewModel: RegisterViewModel by viewModels()
    override fun getLayoutID(): Int {
       return R.layout.activity_register
    }

    override fun getBindingVariable(): Int {
       return BR.viewModel
    }

    override fun getViewModel(): RegisterViewModel {
        return registerViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}