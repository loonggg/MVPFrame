package com.loonggg.mvpframe.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.loonggg.mvpframe.R;
import com.loonggg.mvpframe.ui.newstop.NewsTopActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(this, NewsTopActivity.class));
    }
}
