package com.neftenergies.ui.passwordchanged.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.neftenergies.BR
import com.neftenergies.R
import com.neftenergies.base.BaseActivityWrapper
import com.neftenergies.databinding.ActivityPasswordChangedBinding
import com.neftenergies.ui.passwordchanged.PasswordChangedNavigator
import com.neftenergies.ui.passwordchanged.viewmodel.PasswordChangedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PasswordChangedActivity :BaseActivityWrapper <ActivityPasswordChangedBinding,PasswordChangedNavigator,PasswordChangedViewModel>(),
    PasswordChangedNavigator {

    private val passwordChangedViewModel : PasswordChangedViewModel by viewModels()
    override fun getLayoutID(): Int {
        return R.layout.activity_password_changed
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getViewModel(): PasswordChangedViewModel {
       return passwordChangedViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}