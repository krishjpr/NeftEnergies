package com.neftenergies.ui.home.viewmodel

import com.neftenergies.base.BaseViewModel
import com.neftenergies.data.repository.onboarding.OnBoardingRepository
import com.neftenergies.ui.courselist.view.CourseListActivity
import com.neftenergies.ui.home.HomeNavigator

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

 @HiltViewModel
class HomeViewModel @Inject constructor(
    private val onBoardingRepository: OnBoardingRepository
) : BaseViewModel<HomeNavigator>() {

fun courseList (){
    getNavigator()?.openAndFinishActivity(CourseListActivity::class.java)
}

}