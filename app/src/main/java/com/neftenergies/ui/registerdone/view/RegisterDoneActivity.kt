package com.neftenergies.ui.registerdone.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.neftenergies.BR
import com.neftenergies.R
import com.neftenergies.base.BaseActivityWrapper
import com.neftenergies.databinding.ActivityRegisterBinding
import com.neftenergies.databinding.ActivityRegisterDoneBinding
import com.neftenergies.ui.register.RegisterNavigator
import com.neftenergies.ui.register.viewmodel.RegisterViewModel
import com.neftenergies.ui.registerdone.RegisterDoneNavigator
import com.neftenergies.ui.registerdone.viewmodel.RegisterDoneViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterDoneActivity : BaseActivityWrapper<ActivityRegisterDoneBinding, RegisterDoneNavigator, RegisterDoneViewModel>(),
    RegisterDoneNavigator {
    private val registerDoneViewModel: RegisterDoneViewModel by viewModels()
    override fun getLayoutID(): Int {
        return R.layout.activity_register_done
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getViewModel(): RegisterDoneViewModel {
       return registerDoneViewModel
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}