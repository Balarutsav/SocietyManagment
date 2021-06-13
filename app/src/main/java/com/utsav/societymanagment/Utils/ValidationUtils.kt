package com.clotheslyne.customer.utils

import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.EditText
import com.clotheslyne.customer.utils.Constant.Companion.VALIDATION_EMAIL
import com.clotheslyne.customer.utils.Constant.Companion.VALIDATION_NAME
import com.clotheslyne.customer.utils.Constant.Companion.VALIDATION_PASS
import com.clotheslyne.customer.utils.Constant.Companion.VALIDATION_PHONE
import com.clotheslyne.customer.utils.Constant.Companion.VALIDATION_ZIP
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

object ValidationUtils {

    fun validateTIL(
        text: String?, errorMsg: String?, textInputLayout: TextInputLayout?, flag: Int = 0,
    ): Boolean {
        //flag = 0 validate nullOrEmpty
        //flag = 1 validate email
        //flag = 2 validate phone
        //flag = 3 validate password
        var isValid = true
        if (flag == VALIDATION_EMAIL) {
            if (isValidEmail(text!!)) {
                showTextInputLayoutError(errorMsg, textInputLayout!!)
                isValid = false
            }
        } else if (flag == VALIDATION_PHONE) {
            if (isValidMobile(text!!)) {
                showTextInputLayoutError(errorMsg, textInputLayout!!)
                isValid = false
            }
        } else {
            if (TextUtils.isEmpty(text)) {
                showTextInputLayoutError(errorMsg, textInputLayout!!)
                isValid = false
            } else {
                hideInputError(textInputLayout!!)
            }
        }
        return isValid
    }

    fun validateTIET(editText: EditText?, errorMsg: String?, flag: Int = 0): Boolean {
        //flag = 0 validate nullOrEmpty
        //flag = 1 validate email
        //flag = 2 validate phone
        //flag = 3 validate password
        //flag = 4 validate zip
        //flag = 5 validate name
        var isValid = true
        val value = editText?.text.toString().trim()
        if (flag == VALIDATION_EMAIL) {
            if (!isValidEmail(value)) {
                editText?.error = errorMsg
                editText?.requestFocus()
                isValid = false
            }
        } else if (flag == VALIDATION_PHONE) {
            if (!isValidMobile(value)) {
                editText?.error = errorMsg
                editText?.requestFocus()
                isValid = false
            }
        } else if (flag == VALIDATION_PASS) {
            if (!isValidPassword(value)) {
                editText?.error = errorMsg
                editText?.requestFocus()
                isValid = false
            }
        } else if (flag == VALIDATION_ZIP) {
            if (!isValidZipCode(value)) {
                editText?.error = errorMsg
                isValid = false
            }
        } else if (flag == VALIDATION_NAME) {
            if (!isValidName(value)) {
                editText?.error = errorMsg
                isValid = false
            }
        } else {
            if (TextUtils.isEmpty(value)) {
                editText?.error = errorMsg
                editText?.requestFocus()
                isValid = false
            }
        }
        return isValid
    }

    fun validateZipTiet(editText: EditText?, emptyMSg: String, validMsg: String?, icon: Drawable): Boolean {
        var isValid = true
        val value = editText?.text.toString().trim()
        if (value.isEmpty()) {
            editText?.error = emptyMSg
            isValid = false
        } else if (!isValidZipCode(value)) {
            icon.bounds = Rect(0, 0, icon.intrinsicWidth, icon.intrinsicHeight)
            editText!!.setError(validMsg, icon)
            isValid = false
        }
        return isValid
    }

    fun validateTIET(editText: EditText?, emptyMSg: String, validMsg: String?, flag: Int = 0): Boolean {
        //flag = 0 validate nullOrEmpty
        //flag = 1 validate email
        //flag = 2 validate phone
        //flag = 3 validate password
        //flag = 4 validate zip
        //flag = 5 validate name
        var isValid = true
        val value = editText?.text.toString().trim()
        if (value.isEmpty()) {
            editText?.error = emptyMSg
            editText?.clear()
            editText?.requestFocus()
            isValid = false
        } else if (flag == VALIDATION_EMAIL) {
            if (!isValidEmail(value)) {
                editText?.error = validMsg
                editText?.requestFocus()
                isValid = false
            }
        } else if (flag == VALIDATION_PHONE) {
            if (!isValidMobile(value)) {
                editText?.error = validMsg
                editText?.requestFocus()
                isValid = false
            }
        } else if (flag == VALIDATION_PASS) {
            if (!isValidPassword(value)) {
                editText?.error = validMsg
                editText?.requestFocus()
                isValid = false
            }
        } else if (flag == VALIDATION_ZIP) {
            if (!isValidZipCode(value)) {
                editText?.error = validMsg
                isValid = false
            }
        } else if (flag == VALIDATION_NAME) {
            if (!isValidName(value)) {
                editText?.error = validMsg
                isValid = false
            }
        } else {
            if (TextUtils.isEmpty(value)) {
                editText?.error = validMsg
                editText?.requestFocus()
                isValid = false
            }
        }
        return isValid
    }

    fun isValidEmail(target: CharSequence): Boolean =
        if (TextUtils.isEmpty(target)) {
            false
        } else {
            Patterns.EMAIL_ADDRESS.matcher(target).matches()
        }

    fun isValidPassword(target: CharSequence): Boolean =
        if (TextUtils.isEmpty(target)) {
            false
        } else {
            target.length >= Constant.MIN_PASSWORD_LENGTH
        }

    fun isValidMobile(phone: String) =
        if (!Pattern.matches("[a-zA-Z]+", phone)) {
            phone.length == 10
        } else false

    fun isValidZipCode(zipCode: String) = zipCode.length in 4..6

    fun isValidName(name: String) = name.length >= 2

    fun hideInputError(view: View) {
        (view as TextInputLayout).isErrorEnabled = false
    }

    fun showTextInputLayoutError(message: String?, view: View) {
        (view as TextInputLayout).errorIconDrawable = null
        view.error = message
    }

    fun String.isNullOrEmptyExt(): Boolean {
        return this.isNullOrEmpty()
    }

    fun EditText.clear() {
        setText("")
    }
}