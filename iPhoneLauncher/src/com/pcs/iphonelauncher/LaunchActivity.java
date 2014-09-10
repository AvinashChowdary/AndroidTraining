package com.pcs.iphonelauncher;

import android.app.Activity;
import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LaunchActivity extends Activity implements OnClickListener{

	private Button callBtn;
	private Button contactsBtn;
	private Button mailBtn;
	private Button safariBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.launch);

		callBtn = (Button) findViewById(R.id.call);
		contactsBtn = (Button) findViewById(R.id.contacts);
		mailBtn = (Button) findViewById(R.id.mail);
		safariBtn = (Button) findViewById(R.id.safari);

		callBtn.setOnClickListener(this);
		contactsBtn.setOnClickListener(this);
		mailBtn.setOnClickListener(this);
		safariBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		
		Intent intent = new Intent();
		
		switch (v.getId()) {
		case R.id.call:
			intent.setAction(Intent.ACTION_DIAL);
			startActivity(intent);
			break;

		case R.id.contacts:
			intent.setAction(Intent.ACTION_PICK);
			
			startActivity(intent);
			break;

		case R.id.mail:
			intent.setAction(Intent.ACTION_SEND);
			intent.setType("text/plain");
			startActivity(intent);
			break;

		case R.id.safari:
			intent.setAction(Intent.ACTION_VIEW);
			intent.setData(Uri.parse("https://www.apple.com"));
			startActivity(intent);
			break;

		default:
			break;
		}

	}



}
