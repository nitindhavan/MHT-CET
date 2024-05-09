package com.prosperminds.mhtcet

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.prosperminds.mhtcet.R


class MainActivity : AppCompatActivity() {
    lateinit var webview : WebView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()
        webview=findViewById(R.id.webview)
        val progressBar: ProgressBar=findViewById(R.id.progressBar)
        webview.webViewClient= WebViewClient(progressBar)
        webview.settings.javaScriptEnabled=true
        webview.loadUrl("https://exam-bullet.web.app/?origin=-NOENFrQ3MFRSIJRq-Ti&destiny=pointB")
    }
    override fun onBackPressed() {
        if (webview.canGoBack()) {
            webview.goBack()
        } else {
            super.onBackPressed()
        }
    }
    inner class WebViewClient(var progressBar: ProgressBar) : android.webkit.WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return false
        }
        override fun onPageFinished(view: WebView, url: String) {
            super.onPageFinished(view, url)
            progressBar.visibility = View.GONE
        }
    }
}