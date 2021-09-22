package com.shivam.brighterbees;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class HomeActivity extends AppCompatActivity {
    WebView homeWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        homeWeb = findViewById(R.id.homeWeb);


        homeWeb.setWebViewClient(new WebViewClient());
        homeWeb.getSettings().setDomStorageEnabled(true);
        homeWeb.getSettings().setLoadsImagesAutomatically(true);
        homeWeb.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        homeWeb.loadUrl("https://brighterbees.org/signin/");

        WebSettings webSettings = homeWeb.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    public static class myWebClient extends WebViewClient{
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon){
            super.onPageStarted(view,url,favicon);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view,String url){
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public void onBackPressed() {
        if(homeWeb.canGoBack()){
            homeWeb.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}
