package com.example.javatest;

import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class DeepLinkActivity extends AppCompatActivity {

    private TextView tvData;
    private String scheme = "";
    private String host = "";
    private List<String> params;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deeplink_activity);
        tvData = findViewById(R.id.tv_data);
        getDataFromBrowser();
    }

    /**
     * 从deep link中获取数据
     */
    private void getDataFromBrowser() {
        Uri data = getIntent().getData();
        try {
            scheme = data.getScheme(); // "will"
            host = data.getHost(); // "share"
            params = data.getPathSegments();
            String testId = params.get(0); // "uuid"
            tvData.setText("Scheme: " + scheme + "\n" + "host: " + host + "\n" + "params: " + testId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
