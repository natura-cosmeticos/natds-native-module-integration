package com.natura

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.natura.data.Icon
import com.natura.data.NativeIconsRepository

class NativeIconsViewModel(application: Application): AndroidViewModel(application) {
    private val repository: NativeIconsRepository
    val icons: List<Icon>

    init {
        repository = NativeIconsRepository(application)
        icons = repository.getIcons()
    }

}