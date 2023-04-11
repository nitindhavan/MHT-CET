package com.exambullet.mhtcet

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var webview : WebView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()
        webview=findViewById(R.id.webview)
        webview.webViewClient= WebViewClient()
        webview.settings.javaScriptEnabled=true
        webview.loadUrl("exam-bullet.web.app/?origin=-NOENFrQ3MFRSIJRq-Ti&destiny=pointB")
    }
    override fun onBackPressed() {
        if (webview.canGoBack()) {
            webview.goBack()
        } else {
            super.onBackPressed()
        }
    }
}