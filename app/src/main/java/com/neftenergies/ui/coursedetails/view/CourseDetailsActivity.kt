package com.neftenergies.ui.coursedetails.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.library.baseAdapters.BR
import com.neftenergies.R
import com.neftenergies.base.BaseActivityWrapper
import com.neftenergies.databinding.ActivityCourseDetailsBinding
import com.neftenergies.databinding.ActivityHomeBinding
import com.neftenergies.ui.coursedetails.CourseDetailsNavigator
import com.neftenergies.ui.coursedetails.viewmodel.CourseDetailsViewModel
import com.neftenergies.ui.home.HomeNavigator
import com.neftenergies.ui.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CourseDetailsActivity : BaseActivityWrapper<ActivityCourseDetailsBinding, CourseDetailsNavigator, CourseDetailsViewModel>(),
CourseDetailsNavigator {
    private val courseDetailsViewModel: CourseDetailsViewModel by viewModels()
    override fun getLayoutID(): Int {
        return R.layout.activity_course_details
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getViewModel(): CourseDetailsViewModel {
        return courseDetailsViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}