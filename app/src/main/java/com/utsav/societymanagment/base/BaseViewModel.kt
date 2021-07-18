package com.utsav.societymanagment.base;


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.utsav.societymanagment.utils.ValidationStatus
import java.lang.ref.WeakReference

open class BaseViewModel<N> : ViewModel() {
    lateinit var mNavigator: WeakReference<N>
    fun getNavigator(): N? {
        return mNavigator.get()

    }

    private val validationObserver = MutableLiveData<ValidationStatus>()
    fun getValidationStatus(): MutableLiveData<ValidationStatus> {
        return validationObserver
    }
    fun setNavigator(navigator: N) {
        mNavigator = WeakReference(navigator)
    }
}