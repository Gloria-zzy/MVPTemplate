package com.example.javatest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mylibrary.LogUtil;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "MainActivity";

    private Button btnWebView;
    private Button btnOpenQQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initAction();

        test4Annotation(null);
    }

    private void initView() {
        btnWebView = findViewById(R.id.btn_webview);
        btnOpenQQ = findViewById(R.id.btn_open_qq);
    }

    private void initAction() {
        btnWebView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(new Intent(MainActivity.this, Class.forName("com.example.javatest.WebViewActivity")));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        btnOpenQQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "mqqwpa://im/chat?chat_type=wpa&uin=847214223";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                if (getPackageManager().resolveActivity(intent, 0) != null){
                    // 系统中存在该activity
                    LogUtil.INSTANCE.d(TAG, "jump to qq");
                    startActivity(intent);
                }else{
                    // 系统中不存在该activity
                    LogUtil.INSTANCE.e(TAG, "无法打开qq");
                    Toast.makeText(getApplicationContext(), "无法打开qq", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void test4Annotation(@Nullable String s){
        Log.d(TAG, "");
    }
}