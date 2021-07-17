package com.utsav.societymanagment.utils.customViews

import android.content.Context
import android.util.AttributeSet
import android.view.ContextThemeWrapper
import androidx.core.content.res.ResourcesCompat

import com.google.android.material.textfield.TextInputLayout
import com.utsav.societymanagment.R

class CustomTextInputLayout : TextInputLayout {

    constructor(context: Context) : super(
        ContextThemeWrapper(
            context,
            R.style.OutlinedBoxStyle
        )
    ) {
        setFontTypeFace(context)
    }

    constructor(
        context: Context,
        attrs: AttributeSet?
    ) : super(ContextThemeWrapper(context, R.style.OutlinedBoxStyle), attrs) {
        setFontTypeFace(context)
    }

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int
    ) : super(
        ContextThemeWrapper(context, R.style.OutlinedBoxStyle),
        attrs,
        defStyleAttr
    ) {
        setFontTypeFace(context)
    }

    private fun setFontTypeFace(context: Context) {
        val face = ResourcesCompat.getFont(context, R.font.montserrat_regular)
        typeface = face
    }
}
