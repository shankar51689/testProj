package com.example.mylibrary

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton

class CustomButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = android.R.attr.buttonStyle
) : AppCompatButton(context, attrs, defStyleAttr) {

    init {
        // Load custom attributes
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(
                it,
                R.styleable.CustomButton,
                defStyleAttr,
                0
            )

            try {
                // Retrieve and apply custom attributes
                applyCustomAttributes(typedArray)
            } finally {
                // Recycle the TypedArray to avoid memory leaks
                typedArray.recycle()
            }
        }

        // Add additional default behavior or styling here if needed
    }

    private fun applyCustomAttributes(typedArray: android.content.res.TypedArray) {
        // Retrieve custom text attribute
        val customText = typedArray.getString(R.styleable.CustomButton_customText)
        customText?.let {
            text = it
        }

        // Retrieve and apply custom background
        val customBackground = typedArray.getResourceId(
            R.styleable.CustomButton_customBackground,
            -1
        )
        if (customBackground != -1) {
            setBackgroundResource(customBackground)
        }

        // Retrieve and apply custom padding
        val customPadding = typedArray.getDimension(
            R.styleable.CustomButton_customPadding,
            0f
        ).toInt()
        if (customPadding > 0) {
            setPadding(customPadding, customPadding, customPadding, customPadding)
        }
    }
}
