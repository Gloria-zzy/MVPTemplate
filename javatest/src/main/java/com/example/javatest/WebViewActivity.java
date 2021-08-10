package com.example.javatest;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebViewActivity extends AppCompatActivity {

    WebView web_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        web_main = (WebView) findViewById(R.id.wv_main);

        web_main.loadUrl("file:///android_asset/deeplink.html");
//        web_main.loadUrl("https://www.baidu.com/");

        web_main.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                if (url.startsWith("will://")) {
                    Uri uri = Uri.parse(url);
                    Log.e("---------scheme: ", uri.getScheme() + "host: " + uri.getHost() + "Id: " + uri.getPathSegments().get(0));
                    Toast.makeText(WebViewActivity.this, "打开新的页面", Toast.LENGTH_LONG).show();
                    return true; //返回true，代表要拦截这个url
                }
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
    }
}