package com.utsav.societymanagment.utils

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.Window
import androidx.appcompat.widget.AppCompatTextView
import com.utsav.societymanagment.R

object Dialog {
    fun displayDialogSingleButton(
        activity: Activity, message: String?,
        activityFinish: Boolean
    ) {
        val dialog = Dialog(activity)
        try {
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.setCancelable(false)
        } catch (e: Exception) {

        }
        dialog.setContentView(R.layout.dialog_toast_alert)
        dialog.setCancelable(false)
        val tvOk: AppCompatTextView = dialog.findViewById(R.id.tv_ok)
        val tvMessage:AppCompatTextView  = dialog.findViewById(R.id.tv_text)
        tvMessage.text = message
        tvOk.setOnClickListener {
            dialog.dismiss()
            if (activityFinish) {
                activity.finish()
            }
        }
        try {
            dialog.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}