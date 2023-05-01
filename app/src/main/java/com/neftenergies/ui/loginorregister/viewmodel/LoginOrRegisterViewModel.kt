package com.neftenergies.ui.loginorregister.viewmodel

import com.neftenergies.base.BaseViewModel
import com.neftenergies.data.repository.onboarding.OnBoardingRepository
import com.neftenergies.ui.home.view.HomeActivity
import com.neftenergies.ui.login.view.LoginActivity
import com.neftenergies.ui.loginorregister.LoginOrRegisterNavigator
import com.neftenergies.ui.register.view.RegisterActivity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginOrRegisterViewModel @Inject constructor(
    private val onBoardingRepository: OnBoardingRepository
) : BaseViewModel<LoginOrRegisterNavigator>(){

fun loginUser(){
    getNavigator()?.openAndFinishActivity(LoginActivity::class.java)
}

    fun registerUser(){
        getNavigator()?.openAndFinishActivity(RegisterActivity::class.java)
    }


}
