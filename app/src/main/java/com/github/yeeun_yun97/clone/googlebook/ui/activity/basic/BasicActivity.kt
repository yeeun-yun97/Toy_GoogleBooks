package com.github.yeeun_yun97.clone.googlebook.ui.activity.basic

import androidx.viewbinding.ViewBinding
import com.github.yeeun_yun97.clone.googlebook.R
import com.github.yeeun_yun97.clone.ynmodule.ui.activity.ViewBindingBasicActivity

abstract class BasicActivity<B : ViewBinding> : ViewBindingBasicActivity<B>() {
    override fun fragmentContainer(): Int = R.id.fragmentContainer

}