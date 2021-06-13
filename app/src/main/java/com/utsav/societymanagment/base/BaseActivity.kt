
package com.utsav.societymanagment.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.utsav.societymanagment.R
import com.utsav.societymanagment.utils.hideKeyboard
import javax.inject.Inject

abstract class BaseActivity<T : ViewDataBinding, V : ViewModel> : AppCompatActivity() {

    @Inject
    lateinit var mViewModel: V
    lateinit var binding: T

    abstract fun getBindingVariable(): Int
    abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()
    }

    private fun performDataBinding() {
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        binding.setVariable(getBindingVariable(), mViewModel)
        binding.executePendingBindings()
    }

    fun startActivityWithFinish(target: Class<*>, bundle: Bundle?) {
        //Call new activity with finish current activity
        val intent = Intent(this, target)
        bundle?.let { intent.putExtras(it) }
        startActivity(intent)
        overridePendingTransition(R.anim.right_in, R.anim.left_out)
        finish()
    }

    fun startActivityWithOutFinish(target: Class<*>, bundle: Bundle?) {
        //Call new activity with finish current activity
        val intent = Intent(this, target)
        bundle?.let { intent.putExtras(it) }
        startActivity(intent)
        overridePendingTransition(R.anim.right_in, R.anim.left_out)
    }
    fun startActivityWithclearallactivities(target: Class<*>, bundle: Bundle?) {
        //Call new activity with finish current activity
        val intent = Intent(this, target)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        bundle?.let { intent.putExtras(it) }
        startActivity(intent)
        overridePendingTransition(R.anim.right_in, R.anim.left_out)
    }


    open fun startActivityWithNewTaskAnimation(target: Class<*>?) {
        //Call new activity with new task(finish all activity)
        val intent = Intent(this, target)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        overridePendingTransition(R.anim.left_in, R.anim.right_out)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.left_in, R.anim.right_out)
    }

    override fun onResume() {
        super.onResume()
        hideKeyboard()
    }

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        val view = currentFocus
        val ret = super.dispatchTouchEvent(event)

        if (view is EditText) {
            val w = currentFocus
            val scrcoords = IntArray(2)
            w!!.getLocationOnScreen(scrcoords)
            event?.let {
                val x: Float = event.rawX + w.left - scrcoords[0]
                val y: Float = event.rawY + w.top - scrcoords[1]
                if (event.action == MotionEvent.ACTION_UP && (x < w.left || x >= w.right || y < w.top || y > w.bottom)) {
                    val imm =
                        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(window.currentFocus!!.windowToken, 0)
                }
            }
        }
        return ret
    }
}