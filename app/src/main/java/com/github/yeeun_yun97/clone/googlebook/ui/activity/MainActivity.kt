package com.github.yeeun_yun97.clone.googlebook.ui.activity

import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.github.yeeun_yun97.clone.googlebook.databinding.ActivityMainBinding
import com.github.yeeun_yun97.clone.googlebook.ui.activity.basic.BasicActivity
import com.github.yeeun_yun97.clone.googlebook.ui.fragment.ListBookFragment

class MainActivity : BasicActivity<ActivityMainBinding>() {

    override fun homeFragment(): Fragment = ListBookFragment()

    override fun viewBindingInflate(inflater: LayoutInflater): ActivityMainBinding =
        ActivityMainBinding.inflate(inflater)

    override fun onCreate() {}

}