package com.pcs.opener;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

public class OpeningActivity extends Activity {
	
	
	private TextView txtView;
	private ImageView imageView;
	private WebView webView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.opener);
		
		txtView = (TextView) findViewById(R.id.textview);
		imageView = (ImageView) findViewById(R.id.imageview);
		webView = (WebView) findViewById(R.id.webview);
		
		
	}

}
