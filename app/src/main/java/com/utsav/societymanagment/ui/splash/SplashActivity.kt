package com.utsav.societymanagment.ui.splash

import android.os.Bundle
import android.os.CountDownTimer
import com.utsav.societymanagment.BR
import com.utsav.societymanagment.R
import com.utsav.societymanagment.base.BaseActivity
import com.utsav.societymanagment.databinding.ActivitySplashBinding
import com.utsav.societymanagment.ui.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>(), SplashNavigator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        moveToLogin()
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun moveToLogin() {
        object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

                //here you can have your logic to set text to edittext
            }

            override fun onFinish() {
                startActivityWithFinish(LoginActivity::class.java,null)
            }
        }.start()
    }

    override fun moveToHome() {

    }

    override fun setObserver() {

    }
}