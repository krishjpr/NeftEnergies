package com.neftenergies.ui.loginorregister.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.neftenergies.BR
import com.neftenergies.R
import com.neftenergies.base.BaseActivityWrapper
import com.neftenergies.databinding.ActivityLoginOrRegisterBinding
import com.neftenergies.ui.loginorregister.LoginOrRegisterNavigator
import com.neftenergies.ui.loginorregister.viewmodel.LoginOrRegisterViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginOrRegisterActivity : BaseActivityWrapper<ActivityLoginOrRegisterBinding, LoginOrRegisterNavigator , LoginOrRegisterViewModel>(),
    LoginOrRegisterNavigator {
    private val loginOrRegisterViewModel: LoginOrRegisterViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun getLayoutID(): Int {
       return R.layout.activity_login_or_register
    }

    override fun getBindingVariable(): Int {
      return BR.viewModel
    }

    override fun getViewModel(): LoginOrRegisterViewModel {
      return loginOrRegisterViewModel
    }



}

