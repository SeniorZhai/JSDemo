package com.zoe.js;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint({ "SetJavaScriptEnabled", "JavascriptInterface" }) 
public class MainActivity extends Activity {
	
	private WebView contentView = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		contentView = (WebView)findViewById(R.id.webview);
		contentView.getSettings().setJavaScriptEnabled(true);
		contentView.loadUrl("file:///android_asset/web.html");
		contentView.addJavascriptInterface(this, "zoe");
		Button button1 = (Button)findViewById(R.id.button1);
		Button button2 = (Button)findViewById(R.id.button2);
		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				contentView.loadUrl("javascript:fun1()");
			}
		});
		button2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				contentView.loadUrl("javascript:fun2('参数')");
			}
		});
	}
	public void startFunction() {
		Toast.makeText(this, "js调用了java函数", Toast.LENGTH_SHORT).show();
		runOnUiThread(new Runnable() {
			@Override
			public void run() {

			}
		});
	}
	public void startFunction(final String str) {
		Toast.makeText(this, "js调用了java函数，并传参："+str, Toast.LENGTH_SHORT).show();
		runOnUiThread(new Runnable() {
			@Override
			public void run() {

			}
		});
	}
}
