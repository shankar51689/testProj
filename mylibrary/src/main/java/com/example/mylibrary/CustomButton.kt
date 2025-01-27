package com.example.mylibrary

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton

class CustomButton(context: Context, attrs: AttributeSet) : AppCompatButton(context, attrs) {

    init {
        // Retrieve custom attributes
        val typedArray = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CustomButton,
            0, 0
        )

        // Retrieve the custom attributes and apply them
        try {
            val customText = typedArray.getString(R.styleable.CustomButton_customText)
            val customBackground = typedArray.getResourceId(R.styleable.CustomButton_customBackground, -1)
            val customPadding = typedArray.getDimension(R.styleable.CustomButton_customPadding, 0f)

            // Apply custom text if available
            if (customText != null) {
                text = customText
            }

            // Apply custom background if available
            if (customBackground != -1) {
                setBackgroundResource(customBackground)
            }

            // Apply custom padding if available
            setPadding(customPadding.toInt(), customPadding.toInt(), customPadding.toInt(), customPadding.toInt())

        } finally {
            // Recycle the TypedArray to avoid memory leaks
            typedArray.recycle()
        }
    }
}
