package com.neftenergies.ui.login.view

import android.os.Bundle
import androidx.activity.viewModels
import com.neftenergies.BR
import com.neftenergies.R
import com.neftenergies.base.BaseActivityWrapper
import com.neftenergies.databinding.ActivityLoginBinding
import com.neftenergies.ui.login.LoginNavigator
import com.neftenergies.ui.login.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivityWrapper<ActivityLoginBinding, LoginNavigator, LoginViewModel>(),
    LoginNavigator {
    private val loginViewModel: LoginViewModel by viewModels()

    override fun getLayoutID(): Int {
        return R.layout.activity_login
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getViewModel(): LoginViewModel {
        return loginViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}