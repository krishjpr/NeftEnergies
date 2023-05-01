package com.neftenergies.ui.forgetpassword.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.neftenergies.BR
import com.neftenergies.R
import com.neftenergies.base.BaseActivityWrapper
import com.neftenergies.databinding.ActivityForgetPasswordBinding
import com.neftenergies.ui.forgetpassword.ForgetPasswordNavigator
import com.neftenergies.ui.forgetpassword.viewmodel.ForgetPasswordViewModel
import com.neftenergies.ui.login.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

@AndroidEntryPoint
class ForgetPasswordActivity : BaseActivityWrapper <ActivityForgetPasswordBinding,ForgetPasswordNavigator,ForgetPasswordViewModel>(),
    ForgetPasswordNavigator{
    private val forgetPasswordViewModel: ForgetPasswordViewModel by viewModels()
    override fun getLayoutID(): Int {

        return R.layout.activity_forget_password
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getViewModel(): ForgetPasswordViewModel {
       return forgetPasswordViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}