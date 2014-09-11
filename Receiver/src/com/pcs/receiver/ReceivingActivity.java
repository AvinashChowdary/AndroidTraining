package com.pcs.receiver;




import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.pcs.constants.Constants;


public class ReceivingActivity extends Activity {

	private TextView txtView;
	private ImageView imageView;
	private WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.receiver);
		
		txtView = (TextView) findViewById(R.id.text);
		imageView = (ImageView) findViewById(R.id.image);
		webView = (WebView) findViewById(R.id.web);

		String action = getIntent().getAction();

		if(action.equals(Constants.InentExtras.TEXT)){

			txtView.setVisibility(TextView.VISIBLE);
			txtView.setText(R.string.messgae_txt);

		}

		else if(action.equals(Constants.InentExtras.TEXT)){

			imageView.setVisibility(ImageView.VISIBLE);
			imageView.setImageResource(R.drawable.showimage);

		}

		else if(action.equals(Constants.InentExtras.TEXT)){

			webView.setVisibility(WebView.VISIBLE);
			webView.loadUrl("www.paradigmcreatives.com");

		}

	}

}
