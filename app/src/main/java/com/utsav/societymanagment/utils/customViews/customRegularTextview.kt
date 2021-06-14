package com.cluttrfly.driver.ui.custom

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.ResourcesCompat
import com.cluttrfly.driver.R

class customRegularTextview : AppCompatTextView {
    constructor(context: Context) : super(context) {
        setFontTypeFace(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        setFontTypeFace(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        setFontTypeFace(context)
    }

    private fun setFontTypeFace(context: Context) {
        val face = ResourcesCompat.getFont(context, R.font.montserrat_regular)
        this.typeface = face
    }
}