package com.neftenergies.ui.passwordchanged.viewmodel

import com.neftenergies.base.BaseViewModel
import com.neftenergies.data.repository.onboarding.OnBoardingRepository
import com.neftenergies.ui.login.view.LoginActivity
import com.neftenergies.ui.passwordchanged.PasswordChangedNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PasswordChangedViewModel @Inject constructor(
    private val onBoardingRepository: OnBoardingRepository
) : BaseViewModel<PasswordChangedNavigator>(){

    fun backToLogin(){
        getNavigator()?.openAndFinishActivity(LoginActivity::class.java)
    }


}