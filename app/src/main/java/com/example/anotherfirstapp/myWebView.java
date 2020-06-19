package com.example.anotherfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class myWebView extends AppCompatActivity {

    private static final String TAG = "myWebView";
    private WebView webView;
    private String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_web_view);

        try{
            url = getIntent().getStringExtra("url");
        }catch (NullPointerException e){
            Log.d(TAG, "onCreate: NullPointer Exception");
        }
        webView = (WebView)findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().getJavaScriptEnabled();
        webView.loadUrl(url);
    }

    @Override
    public void onBackPressed() {
        boolean a = webView.canGoBack();
        Log.d(TAG, "canGoback " + Boolean.toString(a));
        if(webView.canGoBack()){
            webView.goBack();
        } else{
            super.onBackPressed();
        }
    }
}
