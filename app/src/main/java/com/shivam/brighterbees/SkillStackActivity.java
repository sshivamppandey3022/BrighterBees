package com.shivam.brighterbees;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SkillStackActivity extends AppCompatActivity {
    WebView skillWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill_stack);
        skillWeb = findViewById(R.id.skillWeb);

        skillWeb.setWebViewClient(new WebViewClient());
        skillWeb.getSettings().setDomStorageEnabled(true);
        skillWeb.getSettings().setLoadsImagesAutomatically(true);
        skillWeb.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        skillWeb.loadUrl("https://brighterbees.org/skill-stack/");

        WebSettings webSettings = skillWeb.getSettings();
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
        if(skillWeb.canGoBack()){
            skillWeb.goBack();
        }
        else {
        super.onBackPressed();
        }
    }
}
