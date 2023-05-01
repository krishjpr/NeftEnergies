package com.neftenergies.utils

import android.app.Application
import android.text.TextUtils
import androidx.appcompat.app.AppCompatDelegate
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.moengage.core.MoECoreHelper
import com.neftenergies.utils.SharedPreferencesHelper.Companion.initializeInstance
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GramAppApplication : Application() {

    private var moEngageAppId: String? = null

    companion object{
        fun getAppContext(): GramAppApplication{
            return GramAppApplication()
        }




    }
    override fun onCreate() {
        super.onCreate()
        initializeInstance(this)
        val langIsoCode = LocaleManagerClass.getLangCodeFromPreferences(this)
        if (langIsoCode != null && !langIsoCode.equals("", ignoreCase = true)) {
            LocaleManagerClass.updateLocale(langIsoCode, resources)
        }

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)


        try {
            configureCrashReporting()
        } catch (e: Exception) {
        }
    }




    private fun configureCrashReporting() {
        if (!TextUtils.isEmpty(SharedPreferencesHelper.instance?.getString(SharedPreferencesKeys.UUIdKey)!!))
            FirebaseCrashlytics.getInstance()
                .setUserId(SharedPreferencesHelper.instance?.getString(SharedPreferencesKeys.UUIdKey)!!)

        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true)
    }


    fun userLogoutMoEngage() {
        MoECoreHelper.logoutUser(this)
    }

}
