package com.neftenergies.ui.coursedetails.viewmodel

import com.neftenergies.base.BaseViewModel
import com.neftenergies.data.repository.onboarding.OnBoardingRepository
import com.neftenergies.ui.coursedetails.CourseDetailsNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

    @HiltViewModel
    class CourseDetailsViewModel @Inject constructor(
        private val onBoardingRepository: OnBoardingRepository
    ) : BaseViewModel<CourseDetailsNavigator>() {

    }