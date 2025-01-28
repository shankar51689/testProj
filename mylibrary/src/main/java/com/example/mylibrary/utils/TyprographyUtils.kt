package com.example.mylibrary.utils


import android.content.Context
import com.example.mylibrary.R

object TypographyUtils {

    fun getHeadingFontSize(context: Context): Float {
        return context.resources.getDimension(R.dimen.text_size_large)
    }

    fun getBodyFontSize(context: Context): Float {
        return context.resources.getDimension(R.dimen.text_size_small)
    }

    fun getSmallFontSize(context: Context): Float {
        return context.resources.getDimension(R.dimen.text_size_smaller)
    }
}
