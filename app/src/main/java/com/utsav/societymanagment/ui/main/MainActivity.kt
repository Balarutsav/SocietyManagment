package com.utsav.societymanagment.ui.Splash

import android.os.Bundle
import com.utsav.societymanagment.BR
import com.utsav.societymanagment.R
import com.utsav.societymanagment.base.BaseActivity
import com.utsav.societymanagment.databinding.ActivityMainBinding
import com.utsav.societymanagment.ui.main.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun getBindingVariable(): Int {
        return BR.mainViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }
}