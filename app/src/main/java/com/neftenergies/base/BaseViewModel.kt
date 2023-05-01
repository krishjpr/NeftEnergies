package com.neftenergies.base

import com.neftenergies.utils.SharedPreferencesHelper
import com.neftenergies.utils.SharedPreferencesKeys
import android.Manifest
import android.location.Geocoder
import androidx.lifecycle.ViewModel
import com.moengage.core.Properties
import com.moengage.core.analytics.MoEAnalyticsHelper
import kotlinx.coroutines.Job
import java.lang.ref.WeakReference
import java.util.*


open class BaseViewModel<N : BaseNavigator>() : ViewModel() {

    private var mNavigator: WeakReference<N?> = WeakReference(null)


    internal fun setNavigator(navigator: N?) {
        mNavigator = WeakReference(navigator)
    }



    fun getNavigator() = mNavigator.get()

    internal fun Job?.cancelIfActive() = this?.takeIf { it.isActive }?.cancel()


    fun getGeoCoder(): Geocoder? {
        return getNavigator()?.getGeoCoder()
    }

}