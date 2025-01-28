package com.example.mylibrary.components


import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import com.example.mylibrary.R
import android.graphics.Color
import android.widget.LinearLayout
import androidx.core.content.ContextCompat

class ButtonView(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    private var buttonTextColor: Int = Color.WHITE
    private var buttonBackgroundColor: Int = Color.BLUE
    private var buttonTextSize: Float = 8f
    private var isRoundCorners: Boolean = false
    private var btnText: String = ""
    // Initialize the button
    private val button: Button = Button(context)

    init {
        addView(button)

        // Load custom attributes from XML
        val typedArray = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.ButtonView,
            0, 0
        )

        // Get the button text color, background color, text size, and rounded corner flag
        buttonTextColor = typedArray.getColor(R.styleable.ButtonView_buttonTextColor, buttonTextColor)
        buttonBackgroundColor = typedArray.getColor(R.styleable.ButtonView_buttonBackgroundColor, buttonBackgroundColor)
        buttonTextSize = typedArray.getDimension(R.styleable.ButtonView_buttonTextSize, buttonTextSize)
        isRoundCorners = typedArray.getBoolean(R.styleable.ButtonView_isRoundCorners, false)
        btnText = typedArray.getString(R.styleable.ButtonView_text) ?: ""
        typedArray.recycle()

        // Apply the customization to the button
        button.setTextColor(buttonTextColor)
        button.setBackgroundColor(buttonBackgroundColor)
        button.textSize = buttonTextSize
        button.text = btnText

        // If round corners are enabled, set the rounded background
        if (isRoundCorners) {
            val drawable = ContextCompat.getDrawable(context, R.drawable.button_rounded)!!
            button.background = drawable
        } else {
            button.setBackgroundColor(buttonBackgroundColor) // Default background color
        }

        // Apply some padding to make sure the button is visible and has space for the text
        button.setPadding(16, 8, 16, 8)

        // Default fallback logic in case the color is transparent
        if (buttonTextColor == Color.TRANSPARENT) {
            buttonTextColor = Color.WHITE // Default text color if not set
        }
        if (buttonBackgroundColor == Color.TRANSPARENT) {
            buttonBackgroundColor = Color.BLUE // Default background color if not set
        }

        if (button.text.isNullOrEmpty()) {
            button.text = "Click me"
        }
    }

    // This will allow users to change the text color dynamically
    fun setButtonTextColor(color: Int) {
        buttonTextColor = color
        button.setTextColor(color)
    }

    // This will allow users to change the background color dynamically
    fun setButtonBackgroundColor(color: Int) {
        buttonBackgroundColor = color
        button.setBackgroundColor(color)
    }

    // This will allow users to adjust the button text size dynamically
    fun setButtonTextSize(size: Float) {
        buttonTextSize = size
        button.textSize = size
    }

    // This will allow users to toggle rounded corners dynamically
    fun setRoundCorners(enabled: Boolean) {
        isRoundCorners = enabled
        if (enabled) {
            val drawable = ContextCompat.getDrawable(context, R.drawable.button_rounded)!!
            button.background = drawable
        } else {
            button.setBackgroundColor(buttonBackgroundColor) // Set background color again
        }
    }

    // Expose the internal button for accessing via findViewById
    fun getButton(): Button {
        return button
    }
}


