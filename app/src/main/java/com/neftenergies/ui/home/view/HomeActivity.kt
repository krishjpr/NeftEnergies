package com.neftenergies.ui.home.view


import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.neftenergies.BR
import com.neftenergies.R
import com.neftenergies.base.BaseActivityWrapper
import com.neftenergies.databinding.ActivityHomeBinding
import com.neftenergies.ui.home.HomeNavigator
import com.neftenergies.ui.home.view.adapter.CourseAdapter
import com.neftenergies.ui.home.view.adapter.JavaAdapter
import com.neftenergies.ui.home.view.adapter.SecurityAdapter
import com.neftenergies.ui.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_home.*

@AndroidEntryPoint
class HomeActivity : BaseActivityWrapper<ActivityHomeBinding, HomeNavigator, HomeViewModel>(),
    HomeNavigator {
    private val homeViewModel: HomeViewModel by viewModels()



    override fun getLayoutID(): Int {
       return R.layout.activity_home
    }

    override fun getBindingVariable(): Int {
       return BR.viewModel
    }

    override fun getViewModel(): HomeViewModel {
        return homeViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupUi()

    }

    private fun setupUi() {
        rvCourse.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        rvCourse.setHasFixedSize(true)
        val courseAdapter = CourseAdapter()
        rvCourse.adapter = courseAdapter


        rvJava.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        rvJava.setHasFixedSize(true)
        val javaAdapter = JavaAdapter()
        rvJava.adapter = javaAdapter


        rvSecurity.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        rvSecurity.setHasFixedSize(true)
        val securityAdapter = SecurityAdapter()
        rvSecurity.adapter = securityAdapter


    }

}