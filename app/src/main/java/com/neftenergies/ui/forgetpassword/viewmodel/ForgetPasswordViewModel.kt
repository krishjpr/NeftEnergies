package com.neftenergies.ui.forgetpassword.viewmodel

import com.neftenergies.base.BaseViewModel
import com.neftenergies.data.repository.onboarding.OnBoardingRepository
import com.neftenergies.ui.forgetpassword.ForgetPasswordNavigator
import com.neftenergies.ui.login.view.LoginActivity
import com.neftenergies.ui.verifyotp.view.VerifyOtpActivity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ForgetPasswordViewModel @Inject constructor(
    private val onBoardingRepository: OnBoardingRepository
) : BaseViewModel<ForgetPasswordNavigator>(){

    fun sendOtp(){
        getNavigator()?.openAndFinishActivity(VerifyOtpActivity::class.java)
    }
    fun loginActivity(){
        getNavigator()?.openAndFinishActivity(LoginActivity::class.java)
    }

}