package com.neftenergies.ui.login.viewmodel

import com.neftenergies.base.BaseViewModel
import com.neftenergies.data.repository.onboarding.OnBoardingRepository
import com.neftenergies.ui.forgetpassword.view.ForgetPasswordActivity
import com.neftenergies.ui.home.view.HomeActivity
import com.neftenergies.ui.login.LoginNavigator
import com.neftenergies.ui.register.view.RegisterActivity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val onBoardingRepository: OnBoardingRepository
) : BaseViewModel<LoginNavigator>(){

    fun verifyUser(){
        getNavigator()?.openAndFinishActivity(HomeActivity::class.java)

    }

    fun registerUser(){
        getNavigator()?.openAndFinishActivity(RegisterActivity::class.java)
    }
    fun forgetPws(){
        getNavigator()?.openAndFinishActivity(ForgetPasswordActivity::class.java)
    }
}
