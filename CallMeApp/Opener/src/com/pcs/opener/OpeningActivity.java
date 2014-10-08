package com.pcs.opener;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.pcs.constants.Constants;

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
		
		String action = getIntent().getAction();
		
		if(Constants.IntentExtras.TEXT.equals(action)){
			txtView.setVisibility(TextView.VISIBLE);
			txtView.setText(R.string.msg_txt);
			
		}
		else if( Constants.IntentExtras.IMAGE.equals(action)){
			imageView.setVisibility(View.VISIBLE);
			imageView.setBackgroundResource(R.drawable.imageview);
			
		}
		else if( Constants.IntentExtras.WEBPAGE.equals(action)){
			webView.setVisibility(View.VISIBLE);
			webView.loadUrl("www.developer.android.com");
			
		}
		
		
	}

}
