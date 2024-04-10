package com.softcg.eduplanner

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MvvmEduPlannerApp:Application() {
    override fun onCreate() {
        super.onCreate()
    }
}