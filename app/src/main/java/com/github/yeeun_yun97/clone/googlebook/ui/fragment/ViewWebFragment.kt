package com.github.yeeun_yun97.clone.googlebook.ui.fragment

import android.os.Bundle
import android.util.Log
import com.github.yeeun_yun97.clone.googlebook.R
import com.github.yeeun_yun97.clone.googlebook.databinding.FragmentViewWebBinding
import com.github.yeeun_yun97.clone.googlebook.ui.component.SjWebViewClient

class ViewWebFragment : BasicFragment<FragmentViewWebBinding>() {

    companion object {
        fun newInstance(url: String): ViewWebFragment {
            val fragment = ViewWebFragment()
            fragment.arguments = Bundle().apply {
                putString("url", url)
            }
            Log.d("프래그먼트 생성", url)
            return fragment
        }
    }


    override fun layoutId(): Int = R.layout.fragment_view_web
    override fun onCreateView() {
        val url = requireArguments().getString("url")
        binding.webView.loadUrl(url!!)
        binding.webView.webViewClient = SjWebViewClient()
    }


}