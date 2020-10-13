package com.natura

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex

class SampleIntegrationApplication : Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}
