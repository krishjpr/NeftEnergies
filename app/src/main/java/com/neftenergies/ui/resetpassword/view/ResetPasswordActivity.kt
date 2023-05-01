package com.neftenergies.ui.resetpassword.view

import android.os.Bundle
import androidx.activity.viewModels
import com.neftenergies.BR
import com.neftenergies.R
import com.neftenergies.base.BaseActivityWrapper
import com.neftenergies.databinding.ActivityResetPasswordBinding
import com.neftenergies.ui.resetpassword.ResetPasswordNavigator
import com.neftenergies.ui.resetpassword.viewmodel.ResetPasswordViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResetPasswordActivity : BaseActivityWrapper <ActivityResetPasswordBinding,ResetPasswordNavigator,ResetPasswordViewModel>(),
    ResetPasswordNavigator {
    private val resetPasswordViewModel : ResetPasswordViewModel by viewModels()
    override fun getLayoutID(): Int {
        return R.layout.activity_reset_password
    }

    override fun getBindingVariable(): Int {
       return BR.viewModel
    }

    override fun getViewModel(): ResetPasswordViewModel {
       return resetPasswordViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}