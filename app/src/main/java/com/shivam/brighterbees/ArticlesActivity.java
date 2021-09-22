package com.shivam.brighterbees;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ArticlesActivity extends AppCompatActivity {
    WebView articlesWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles);

        articlesWeb = findViewById(R.id.articlesWeb);


        articlesWeb.setWebViewClient(new WebViewClient());
        articlesWeb.getSettings().setDomStorageEnabled(true);
        articlesWeb.getSettings().setLoadsImagesAutomatically(true);
        articlesWeb.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        articlesWeb.loadUrl("https://brighterbees.org/articles/");

        WebSettings webSettings = articlesWeb.getSettings();
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
        if(articlesWeb.canGoBack()){
            articlesWeb.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}
