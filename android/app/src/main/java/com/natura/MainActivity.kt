package com.natura

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rn_sample_android_lib.RNSampleActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.natura.sellingcartlibrary.SellingCartLibraryActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = getString(R.string.main_page_title)

        nativebutton.setOnClickListener {
            startActivity(Intent(this, NativeIconsActivity::class.java))
        }

        reactNative1button.setOnClickListener {
            startActivity(Intent(this, SellingCartLibraryActivity::class.java))
        }

        reactNative2button.setOnClickListener {
            startActivity(Intent(this, RNSampleActivity::class.java))
        }
    }
}