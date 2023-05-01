package com.neftenergies.ui.registerdone.viewmodel

import com.neftenergies.base.BaseViewModel
import com.neftenergies.data.repository.onboarding.OnBoardingRepository
import com.neftenergies.ui.login.view.LoginActivity
import com.neftenergies.ui.registerdone.RegisterDoneNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterDoneViewModel @Inject constructor(
    private val onBoardingRepository: OnBoardingRepository
) : BaseViewModel<RegisterDoneNavigator>(){

 fun loginToBack(){
     getNavigator()?.openAndFinishActivity(LoginActivity::class.java)

 }

}