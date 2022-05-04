package com.github.yeeun_yun97.clone.googlebook.ui.activity

import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.github.yeeun_yun97.clone.googlebook.R
import com.github.yeeun_yun97.clone.googlebook.databinding.ActivityMainBinding
import com.github.yeeun_yun97.clone.googlebook.ui.activity.basic.BasicActivity
import com.github.yeeun_yun97.clone.googlebook.ui.fragment.ListBookFragment
import com.github.yeeun_yun97.clone.googlebook.ui.fragment.ListFavFragment

class MainActivity : BasicActivity<ActivityMainBinding>() {
    private val listBookFragment = ListBookFragment()
    private val listFavFragment = ListFavFragment()

    override fun homeFragment(): Fragment {
        binding.bottomNavigationView.selectedItemId = R.id.book
        return listBookFragment
    }

    override fun viewBindingInflate(inflater: LayoutInflater): ActivityMainBinding =
        ActivityMainBinding.inflate(inflater)

    override fun onCreate() {
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.book -> {
                    replaceFragmentTo(listBookFragment)
                    true
                }
                R.id.fav -> {
                    replaceFragmentTo(listFavFragment)
                    true
                }
                else -> false
            }
        }


    }

}