
package com.utsav.societymanagment.utils
import android.util.Log
import androidx.databinding.library.BuildConfig


object AppLog {
    fun v(tag: String?, msg: String?) {
        if (BuildConfig.DEBUG) {
            Log.v(tag, msg!!)
        }
    }

    fun d(tag: String?, msg: String?) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, msg!!)
        }
    }

    fun i(tag: String?, msg: String?) {
        if (BuildConfig.DEBUG) {
            Log.i(tag, msg!!)
        }
    }

    fun w(tag: String?, msg: String?) {
        if (BuildConfig.DEBUG) {
            Log.w(tag, msg!!)
        }
    }

    fun e(tag: String?, msg: String?) {
        if (BuildConfig.DEBUG) {
            Log.e(tag, msg!!)
        }
    }

}