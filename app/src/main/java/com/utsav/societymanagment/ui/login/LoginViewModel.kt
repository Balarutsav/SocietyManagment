package com.utsav.societymanagment.ui.login

import com.utsav.societymanagment.base.BaseViewModel
import com.utsav.societymanagment.utils.ValidationStatus
import com.utsav.societymanagment.utils.isEmailValid
import com.utsav.societymanagment.utils.isPasswordValid
import javax.inject.Inject

class LoginViewModel @Inject constructor() : BaseViewModel<LoginNavigator>() {
    var emailAddress = ""
    var password = ""


    fun signIn() {
        if (isValidDetails()) {

        }
    }

    private fun isValidDetails(): Boolean {

        when {
            emailAddress.isEmpty() -> {
                sendError(ValidationStatus.EMPTYEMAIL)
            }
            password.isEmpty() -> {
                sendError(ValidationStatus.EmptyPassword)
            }
            !emailAddress.isEmailValid() -> {
                sendError(ValidationStatus.InvalidEmail)
            }
            !password.isPasswordValid() -> {
                sendError(ValidationStatus.InvalidPassword)
            }
            else -> {
                return true
            }
        }
        return false

    }

    fun sendError(error: ValidationStatus) {
        getValidationStatus().postValue(error)
    }


    fun fbSignIn() {

    }

    fun googleSignIn() {

    }

    fun signUp() {

    }

}


