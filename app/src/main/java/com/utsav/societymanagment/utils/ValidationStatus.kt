package com.utsav.societymanagment.utils

import android.app.Activity
import android.content.Context

/**
 * Provides the status of a login request.
 */
enum class ValidationStatus {
    EmptyUsername,
    EmptyPassword,
    EMPTYEMAIL,
    InvalidEmail,
    InvalidPassword,
    Error,
    Loading,
    Success
}
object Validation{
    fun showMessageDialog(activity:Activity,validationStatus: ValidationStatus){
        val message=getMessage(validationStatus)
        activity.showSingleButtonMsg(message,false)
        AppLog.e("Validation message",message)
    }

    private fun getMessage(it: ValidationStatus): String {
        when(it){
            ValidationStatus.InvalidEmail->{
                return "Please enter valid email address"
            }
            ValidationStatus.EMPTYEMAIL->{
               return "Please enter email"
            }
            ValidationStatus.EmptyPassword->{
                return "Please enter password"
            }
            ValidationStatus.InvalidPassword->{
                return  "Password Must Contain 8 chars"
            }
            ValidationStatus.EmptyUsername -> TODO()
            ValidationStatus.Error -> TODO()
            ValidationStatus.Loading -> TODO()
            ValidationStatus.Success -> TODO()
        }
    }
}
