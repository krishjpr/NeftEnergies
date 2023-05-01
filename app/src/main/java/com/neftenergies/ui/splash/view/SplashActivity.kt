package com.neftenergies.ui.splash.view

import android.os.Bundle
import androidx.activity.viewModels
import com.neftenergies.BR
import com.neftenergies.R
import com.neftenergies.base.BaseActivityWrapper
import com.neftenergies.databinding.ActivitySplashBinding
import com.neftenergies.ui.home.view.HomeActivity
import com.neftenergies.ui.loginorregister.view.LoginOrRegisterActivity
import com.neftenergies.ui.splash.SplashNavigator
import com.neftenergies.ui.splash.viewmodel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity :
    BaseActivityWrapper<ActivitySplashBinding, SplashNavigator, SplashViewModel>(),
    SplashNavigator {
    private val splashViewModel: SplashViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startApp()
    }

    private fun startApp(){
        splashViewModel.initSplash()
    }

    override fun getLayoutID(): Int {
        return R.layout.activity_splash
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getViewModel(): SplashViewModel {
        return splashViewModel
    }
    override fun moveToLogin() {
        openAndFinishActivity(LoginOrRegisterActivity::class.java, null)
    }

    override fun moveToHome() {
        openAndFinishActivity(HomeActivity::class.java,null)
    }

}

