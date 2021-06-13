package com.utsav.societymanagment.base;


import androidx.lifecycle.ViewModel
import java.lang.ref.WeakReference

open class BaseViewModel<N> : ViewModel() {
    lateinit var mNavigator: WeakReference<N>
    fun getNavigator(): N? {
        return mNavigator.get()
    }

    fun setNavigator(navigator: N) {
        mNavigator = WeakReference(navigator)
    }
}