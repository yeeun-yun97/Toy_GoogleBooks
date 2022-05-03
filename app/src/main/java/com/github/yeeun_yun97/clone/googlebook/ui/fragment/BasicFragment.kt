package com.github.yeeun_yun97.clone.googlebook.ui.fragment

import androidx.databinding.ViewDataBinding
import com.github.yeeun_yun97.clone.googlebook.R
import com.github.yeeun_yun97.clone.ynmodule.ui.fragment.DataBindingBasicFragment

abstract class BasicFragment<V : ViewDataBinding> : DataBindingBasicFragment<V>() {
    override fun fragmentContainer(): Int = R.id.fragmentContainer
}