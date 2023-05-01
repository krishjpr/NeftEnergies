package com.neftenergies.ui.register.viewmodel

import com.neftenergies.base.BaseViewModel
import com.neftenergies.data.repository.onboarding.OnBoardingRepository
import com.neftenergies.ui.home.view.HomeActivity
import com.neftenergies.ui.login.view.LoginActivity
import com.neftenergies.ui.register.RegisterNavigator
import com.neftenergies.ui.registerdone.view.RegisterDoneActivity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


    @HiltViewModel
    class RegisterViewModel @Inject constructor(
        private val onBoardingRepository: OnBoardingRepository
    ) : BaseViewModel<RegisterNavigator>(){

        fun loginBack(){
            getNavigator()?.openAndFinishActivity(LoginActivity::class.java)
        }

        fun registerDone(){
            getNavigator()?.openAndFinishActivity(RegisterDoneActivity::class.java)

        }

    }