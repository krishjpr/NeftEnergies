package com.neftenergies.ui.verifyotp.viewmodel

import com.neftenergies.base.BaseViewModel
import com.neftenergies.data.repository.onboarding.OnBoardingRepository
import com.neftenergies.ui.resetpassword.view.ResetPasswordActivity
import com.neftenergies.ui.verifyotp.VerifyOtpNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

    @HiltViewModel
    class VerifyOtpViewModel @Inject constructor(
        private val onBoardingRepository: OnBoardingRepository
    ) : BaseViewModel<VerifyOtpNavigator>(){

     fun submitOtp (){
         getNavigator()?.openAndFinishActivity(ResetPasswordActivity::class.java)
     }

    }