package com.utsav.societymanagment.utils

import android.app.Activity

/**
 * Provides the status of a login request.
 */
enum class ValidationStatus {
    EmptyUsername,
    EmptyPassword,
    EMPTYEMAIL,
    EMPTY_FIRSTNAME,
    EMPTY_LASTNAME,
    EMPTY_PHONE_NUMBER,
    VALID_PHONE_NUMBER,
    EMPTY_CONFIRM_PASSWORD,
    PASSWORD_AND_CONFIRM_PASSWORD_NOT_MATCH,
    InvalidEmail,
    InvalidPassword,
    Error,
    Loading,
    Success
}

object Validation {
    fun showMessageDialog(activity: Activity, validationStatus: ValidationStatus) {
        val message = getMessage(validationStatus)
        if (message.isNotEmpty()) {
            activity.showSingleButtonMsg(message, false)
        }
        AppLog.e("Validation message", message)
    }

    private fun getMessage(it: ValidationStatus): String {
        return when (it) {
            ValidationStatus.InvalidEmail -> "Please enter valid email address"

            ValidationStatus.EMPTYEMAIL -> "Please enter email"

            ValidationStatus.EmptyPassword -> "Please enter password"

            ValidationStatus.InvalidPassword -> "Password Must Contain 8 chars"

            ValidationStatus.EMPTY_FIRSTNAME -> "Please enter first name"

            ValidationStatus.EMPTY_LASTNAME -> "Please enter last name"

            ValidationStatus.EMPTY_PHONE_NUMBER -> "Please enter phone number"

            ValidationStatus.VALID_PHONE_NUMBER -> "Please enter valid phone number"

            ValidationStatus.EMPTY_CONFIRM_PASSWORD -> "Please enter confirm password"

            ValidationStatus.PASSWORD_AND_CONFIRM_PASSWORD_NOT_MATCH -> "Password and confirm password not match"
            else -> ""
        }
    }
}
