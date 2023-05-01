package com.neftenergies.ui.verifyotp.view

import android.os.Bundle
import androidx.activity.viewModels
import com.neftenergies.BR
import com.neftenergies.R
import com.neftenergies.base.BaseActivityWrapper
import com.neftenergies.databinding.ActivityVerifyOtpBinding
import com.neftenergies.ui.verifyotp.VerifyOtpNavigator
import com.neftenergies.ui.verifyotp.viewmodel.VerifyOtpViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VerifyOtpActivity : BaseActivityWrapper <ActivityVerifyOtpBinding,VerifyOtpNavigator,VerifyOtpViewModel>(),
    VerifyOtpNavigator {
    private val verifyOtpViewModel: VerifyOtpViewModel by viewModels()

    override fun getLayoutID(): Int {
        return R.layout.activity_verify_otp
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getViewModel(): VerifyOtpViewModel {
       return verifyOtpViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}