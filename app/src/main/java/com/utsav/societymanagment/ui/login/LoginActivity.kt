package com.utsav.societymanagment.ui.login

import android.os.Bundle
import androidx.lifecycle.Observer
import com.utsav.societymanagment.BR
import com.utsav.societymanagment.R
import com.utsav.societymanagment.base.BaseActivity
import com.utsav.societymanagment.databinding.ActivityLoginBinding
import com.utsav.societymanagment.ui.registration.RegistrationActivity
import com.utsav.societymanagment.utils.Validation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(), LoginNavigator {

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel.setNavigator(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }



    override fun setObserver() {
        mViewModel.getValidationStatus().observe(this, Observer {
            Validation.showMessageDialog(activity, it)
        })
    }

    override fun moveToSignup() {
        startActivityWithOutFinish(RegistrationActivity::class.java)
    }

    override fun moveToForgotPassword() {

    }
}