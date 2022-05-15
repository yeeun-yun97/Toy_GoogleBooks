package com.github.yeeun_yun97.clone.googlebook.ui.component

import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

class SjWebViewClient: WebViewClient() {
    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        return false
    }
}