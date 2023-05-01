package com.neftenergies.ui.resetpassword.viewmodel

import com.neftenergies.base.BaseViewModel
import com.neftenergies.data.repository.onboarding.OnBoardingRepository
import com.neftenergies.ui.login.view.LoginActivity
import com.neftenergies.ui.passwordchanged.view.PasswordChangedActivity
import com.neftenergies.ui.resetpassword.ResetPasswordNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ResetPasswordViewModel @Inject constructor(
    private val onBoardingRepository: OnBoardingRepository
) : BaseViewModel<ResetPasswordNavigator>(){

    fun resetPws(){
        getNavigator()?.openAndFinishActivity(PasswordChangedActivity::class.java)
    }
    fun loginPase(){
        getNavigator()?.openAndFinishActivity(LoginActivity::class.java)
    }
}