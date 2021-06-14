package com.cluttrfly.driver.ui.custom

import android.content.Context
import android.os.Build
import android.text.InputType
import android.text.method.PasswordTransformationMethod
import android.util.AttributeSet
import android.view.View
import android.widget.EditText
import androidx.core.content.res.ResourcesCompat
import com.cluttrfly.driver.R
import com.google.android.material.textfield.TextInputEditText

class CustomTextInputEditText : TextInputEditText {
    constructor(context: Context) : super(context) {
        setFontTypeFace(context)
    }

    constructor(
        context: Context,
        attrs: AttributeSet?
    ) : super(context, attrs) {
        setFontTypeFace(context)
    }

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int
    ) : super(context, attrs, defStyleAttr) {
        setFontTypeFace(context)
    }

    private fun setFontTypeFace(context: Context) {
        textAlignment = View.TEXT_ALIGNMENT_VIEW_START
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            importantForAutofill = View.IMPORTANT_FOR_AUTOFILL_NO
        }
        val face = ResourcesCompat.getFont(context, R.font.montserrat_medium)
        this.typeface = face
        if (inputType == 129) {
            transformationMethod = MyPasswordTransformationMethod()
        }

    }
}

class MyPasswordTransformationMethod : PasswordTransformationMethod() {
    override fun getTransformation(source: CharSequence?, view: View?): CharSequence {
        return PasswordCharSequence(source)
    }

    class PasswordCharSequence(source: CharSequence?) : CharSequence {
        private val mSource = source
        override val length: Int = 100

        override fun get(index: Int): Char {
            return '*'
        }

        override fun subSequence(startIndex: Int, endIndex: Int): CharSequence {
            return mSource!!.subSequence(startIndex, endIndex)
        }
    }
}
