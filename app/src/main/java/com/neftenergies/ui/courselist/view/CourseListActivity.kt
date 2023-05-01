package com.neftenergies.ui.courselist.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.neftenergies.BR
import com.neftenergies.R
import com.neftenergies.base.BaseActivityWrapper
import com.neftenergies.databinding.ActivityListDetailsBinding
import com.neftenergies.ui.coursedetails.CourseListNavigator
import com.neftenergies.ui.coursedetails.viewmodel.CourseListViewModel
import com.neftenergies.ui.home.view.adapter.CourseListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_list_details.*

@AndroidEntryPoint
class CourseListActivity : BaseActivityWrapper<ActivityListDetailsBinding, CourseListNavigator, CourseListViewModel>(),
    CourseListNavigator {
    private val courseListViewModel: CourseListViewModel by viewModels()


    override fun getLayoutID(): Int {
     return R.layout.activity_list_details
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getViewModel(): CourseListViewModel {
       return courseListViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupUi()

    }

    private fun setupUi() {

        rvCourseList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        rvCourseList.setHasFixedSize(true)
        val courseListAdapter = CourseListAdapter()
        rvCourseList.adapter = courseListAdapter

    }
}