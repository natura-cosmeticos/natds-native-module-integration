package com.example.sampleintegration

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.sampleintegration.data.NativeIconsRepository
import com.example.sampleintegration.model.Icon

class NativeIconsViewModel(application: Application): AndroidViewModel(application) {
    private val repository: NativeIconsRepository
    val icons: List<Icon>

    init {
        repository = NativeIconsRepository(application)
        icons = repository.getIcons()
    }

}