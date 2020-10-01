package com.example.sampleintegration.data

import android.content.Context
import com.example.sampleintegration.model.Icon
import java.io.BufferedReader

class NativeIconsRepository(private val context: Context) {

    fun getIcons(): List<Icon> {
        val rawIconList = getIconsNamesFromFile()
        val iconsList = mutableListOf<Icon>()
        for (iconName in rawIconList) {
            val icon = Icon(
                context.resources.getIdentifier(iconName, "drawable", context.packageName),
                iconName)
            iconsList.add(icon)
        }
        return iconsList
    }

    private fun getIconsNamesFromFile(): List<String> {
        val reader = BufferedReader(context.assets.open("icons_map.txt").bufferedReader())
        val iconsList = mutableListOf<String>()
        reader.use { reader ->
            var line = reader.readLine()
            while (line != null) {
                iconsList.add(line)
                line = reader.readLine()
            }
        }
        return iconsList
    }
}