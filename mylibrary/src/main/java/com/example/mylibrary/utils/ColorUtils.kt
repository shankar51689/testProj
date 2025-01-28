package com.example.mylibrary.utils

import android.content.Context
import androidx.core.content.ContextCompat
import com.example.mylibrary.R

object ColorUtils {

    fun getPrimaryColor(context: Context): Int {
        return ContextCompat.getColor(context, R.color.colorPrimary)
    }

    fun getSecondaryColor(context: Context): Int {
        return ContextCompat.getColor(context, R.color.colorSecondary)
    }

    fun getErrorColor(context: Context): Int {
        return ContextCompat.getColor(context, R.color.colorError)
    }
}
