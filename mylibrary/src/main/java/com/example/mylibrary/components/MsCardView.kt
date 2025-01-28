package com.example.mylibrary.components

import android.content.Context
import android.util.AttributeSet
import androidx.cardview.widget.CardView
import com.example.mylibrary.utils.ColorUtils

class CardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : android.widget.FrameLayout(context, attrs, defStyleAttr) {

    init {
        val cardView = CardView(context)
        cardView.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        addView(cardView)

        cardView.setCardBackgroundColor(ColorUtils.getSecondaryColor(context))
        cardView.setContentPadding(16, 16, 16, 16)
    }
}
