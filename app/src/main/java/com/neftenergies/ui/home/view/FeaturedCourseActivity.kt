package com.neftenergies.ui.home.view

import android.os.Bundle
import androidx.activity.viewModels
import com.neftenergies.BR
import com.neftenergies.R
import com.neftenergies.base.BaseActivityWrapper
import com.neftenergies.databinding.ActivityHomeBinding
import com.neftenergies.ui.home.HomeNavigator
import com.neftenergies.ui.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeaturedCourseActivity : BaseActivityWrapper<ActivityHomeBinding, HomeNavigator, HomeViewModel>(),
    HomeNavigator {
    private val homeViewModel: HomeViewModel by viewModels()
    override fun getLayoutID(): Int {
       return R.layout.item_home_featured_courses
    }

    override fun getBindingVariable(): Int {
       return BR.viewModel
    }

    override fun getViewModel(): HomeViewModel {
        return homeViewModel
    }

}
