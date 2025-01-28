package com.example.mylibrary.utils

import android.content.Context
import com.example.mylibrary.R

object ThemeManager {
    fun applyTheme(context: Context, isDarkMode: Boolean) {
        val theme = if (isDarkMode) R.style.Theme_Custom_Dark else R.style.Theme_Custom_Light
        context.setTheme(theme)
    }
}