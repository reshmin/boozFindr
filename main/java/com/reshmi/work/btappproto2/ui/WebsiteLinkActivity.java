package com.reshmi.work.btappproto2.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.reshmi.work.btappproto2.R;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebsiteLinkActivity extends AppCompatActivity {
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website_link);

        mWebView = (WebView) findViewById(R.id.eventDetailsWebView);
        //mWebView.getSettings().setJavaScriptEnabled(true);
        //Need to get the id of the item selected from the previous activity and extract
        //the website url from the data model (EventDetails.getWebsiteUrl)
        mWebView.loadUrl("www.google.com");

    }

}







