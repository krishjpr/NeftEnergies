package com.neftenergies.ui.splash.viewmodel

import android.content.res.Resources
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.neftenergies.base.BaseViewModel
import com.neftenergies.data.repository.onboarding.OnBoardingRepository
import com.neftenergies.ui.splash.SplashNavigator
import com.neftenergies.utils.ApiResponse
import com.neftenergies.utils.SharedPreferencesHelper
import com.neftenergies.utils.SharedPreferencesKeys
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val onBoardingRepository: OnBoardingRepository
) : BaseViewModel<SplashNavigator>() {

    fun initSplash() {
        viewModelScope.launch {
            delay(1000)
            updateLiveData()
        }
    }

    private fun updateLiveData() {
        if (SharedPreferencesHelper.instance?.getBoolean(SharedPreferencesKeys.logged_in) == true) {
                    getNavigator()?.moveToHome()
                } else {
                    getNavigator()?.moveToLogin()
                }
        }
    }
