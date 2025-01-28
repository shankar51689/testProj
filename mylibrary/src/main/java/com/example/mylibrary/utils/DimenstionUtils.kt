package com.example.mylibrary.utils

import android.content.Context
import androidx.core.content.ContextCompat
import com.example.mylibrary.R

object DimensionUtils {

    fun getButtonPadding(context: Context): Int {
        return context.resources.getDimensionPixelSize(R.dimen.button_padding)
    }

    fun getCardMargin(context: Context): Int {
        return context.resources.getDimensionPixelSize(R.dimen.card_margin)
    }
}
