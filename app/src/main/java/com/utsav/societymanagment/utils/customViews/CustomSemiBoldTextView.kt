package com.utsav.societymanagment.utils.customViews


import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.ResourcesCompat
import com.utsav.societymanagment.R


class CustomSemiBoldTextView : AppCompatTextView {
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
        val face = ResourcesCompat.getFont(context, R.font.montserrat_semi_bold)
        this.typeface = face
    }
}