package com.utsav.societymanagment.ui.registration

import com.utsav.societymanagment.base.BaseViewModel
import com.utsav.societymanagment.ui.login.LoginNavigator
import com.utsav.societymanagment.utils.ValidationStatus
import com.utsav.societymanagment.utils.isEmailValid
import com.utsav.societymanagment.utils.isMobileNoValid
import com.utsav.societymanagment.utils.isPasswordValid
import javax.inject.Inject

class RegistrationViewModel @Inject constructor() : BaseViewModel<RegistrationNavigator>() {
    var emailAddress = ""
    var password = ""
    var firstName = ""
    var phoneNumber = ""
    var lastName = ""
    var confirmPassword = ""


    fun signIn() {
        getNavigator()?.moveToLogin()
    }

    private fun isValidDetails(): Boolean {

        when {
            firstName.isEmpty() -> {
                sendError(ValidationStatus.EMPTY_FIRSTNAME)
            }

            lastName.isEmpty() -> {
                sendError(ValidationStatus.EMPTY_LASTNAME)
            }


            emailAddress.isEmpty() -> {
                sendError(ValidationStatus.EMPTYEMAIL)
            }
            !emailAddress.isEmailValid() -> {
                sendError(ValidationStatus.InvalidEmail)
            }

            phoneNumber.isEmpty() -> {
                sendError(ValidationStatus.EMPTY_PHONE_NUMBER)
            }
            !phoneNumber.isMobileNoValid() -> {
                sendError(ValidationStatus.VALID_PHONE_NUMBER)
            }

            password.isEmpty() -> {
                sendError(ValidationStatus.EmptyPassword)
            }

            !password.isPasswordValid() -> {
                sendError(ValidationStatus.InvalidPassword)
            }

            confirmPassword.isEmpty() -> {
                sendError(ValidationStatus.EMPTY_CONFIRM_PASSWORD)
            }
            (!password.equals(confirmPassword)) -> {
                sendError(ValidationStatus.PASSWORD_AND_CONFIRM_PASSWORD_NOT_MATCH)
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
        if (isValidDetails()) {

        }
    }

}


