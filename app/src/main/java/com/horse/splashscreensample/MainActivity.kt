package com.horse.splashscreensample

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.window.SplashScreenView
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.splashscreen.SplashScreenViewProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initSplashScreen()
        setContentView(R.layout.activity_main)
    }

    private fun initSplashScreen() {
        var startMillis = SystemClock.uptimeMillis()
        val mSplashScreenView = installSplashScreen()
        mSplashScreenView.setKeepVisibleCondition {
            SystemClock.uptimeMillis() - startMillis < 1000 * 3
        }
    }
}