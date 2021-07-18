package com.utsav.societymanagment.ui.registration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.lifecycle.Observer
import com.utsav.societymanagment.BR
import com.utsav.societymanagment.R
import com.utsav.societymanagment.base.BaseActivity
import com.utsav.societymanagment.databinding.ActivityRegistrationBinding
import com.utsav.societymanagment.utils.Validation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegistrationActivity : BaseActivity<ActivityRegistrationBinding,RegistrationViewModel>(),RegistrationNavigator {

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_registration
    }

    override fun setObserver() {
        mViewModel.getValidationStatus().observe(this, Observer {
            Validation.showMessageDialog(activity,it)
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel.setNavigator(this)
    }

    override fun moveToLogin() {
        finish()
    }
}