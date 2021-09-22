package com.shivam.brighterbees;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BadgesActivity extends AppCompatActivity {
    WebView badgeWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badges);
        badgeWeb = findViewById(R.id.badgeWeb);

        badgeWeb.setWebViewClient(new WebViewClient());
        badgeWeb.getSettings().setDomStorageEnabled(true);
        badgeWeb.getSettings().setLoadsImagesAutomatically(true);
        badgeWeb.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        badgeWeb.loadUrl("https://brighterbees.org/skill-badges/");

        WebSettings webSettings = badgeWeb.getSettings();
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
        if(badgeWeb.canGoBack()){
            badgeWeb.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}
