package com.utsav.societymanagment.base;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import javax.inject.Inject

abstract class BaseFragment<T : ViewDataBinding, V : ViewModel> : Fragment() {
    @Inject
    lateinit var mViewModel: V
    lateinit var binding: T

    abstract fun getBindingVariable(): Int
    abstract fun getLayoutId(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        performDataBinding(inflater, container!!)
        return binding.root
    }

    private fun performDataBinding(inflater: LayoutInflater, container: ViewGroup) {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        binding.setVariable(getBindingVariable(), mViewModel)
        binding.executePendingBindings()
    }
}