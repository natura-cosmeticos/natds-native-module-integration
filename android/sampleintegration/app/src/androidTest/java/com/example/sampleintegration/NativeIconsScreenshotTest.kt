package com.example.sampleintegration

import android.view.View
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.facebook.testing.screenshot.Screenshot
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import java.lang.annotation.Native

@RunWith(AndroidJUnit4::class)
class NativeIconsScreenshotTest {
    @get:Rule
    var activityTestRule = ActivityTestRule(NativeIconsActivity::class.java, false, false)
    lateinit var iconsActivity: NativeIconsActivity

    @Before
    fun setup() {
        iconsActivity = activityTestRule.launchActivity(null)
    }

    fun checkIcons() {
        Screenshot.snapActivity(iconsActivity).setName("Icons Activity").record()
    }
}