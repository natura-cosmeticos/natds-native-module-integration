package com.natura

import androidx.recyclerview.widget.RecyclerView
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.*
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.facebook.testing.screenshot.Screenshot
import kotlinx.android.synthetic.main.activity_native_icons.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NativeIconsScreenshotTest {
    @get:Rule
    var activityTestRule = ActivityTestRule(NativeIconsActivity::class.java, false, false)
    lateinit var iconsActivity: NativeIconsActivity

    @Before
    fun setup() {
        iconsActivity = activityTestRule.launchActivity(null)
    }

    @Test
    fun checkIcons() {
        val totalIcons = iconsActivity.iconsRecyclerView.adapter?.itemCount ?: 0

        for(i in 0..totalIcons) {
            onView(withId(R.id.iconsRecyclerView))
                .perform(scrollToPosition<RecyclerView.ViewHolder>(i))
            Screenshot.snapActivity(iconsActivity).setName("Icons Activity $i").record()
        }
    }
}
