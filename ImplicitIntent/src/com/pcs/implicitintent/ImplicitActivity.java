package com.pcs.implicitintent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ImplicitActivity extends Activity implements OnClickListener{

	private Button callBtn, contactsBtn, emailBtn, browserBtn, musicBtn; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout);

		callBtn = (Button) findViewById(R.id.call);
		contactsBtn = (Button) findViewById(R.id.contacts);
		emailBtn = (Button) findViewById(R.id.mail);
		browserBtn = (Button) findViewById(R.id.browser);
		musicBtn = (Button) findViewById(R.id.music);

		callBtn.setOnClickListener(this);
		contactsBtn.setOnClickListener(this);
		emailBtn.setOnClickListener(this);
		browserBtn.setOnClickListener(this);
		musicBtn.setOnClickListener(this);

	}
	@Override
	public void onClick(View v) {


		Intent intent = new Intent();

		switch (v.getId()) {

		case R.id.browser:
			intent.setAction(Intent.ACTION_VIEW);
			intent.setData(Uri.parse("http://www.apple.com"));
			startActivity(Intent.createChooser(intent,
					getResources().getString(R.string.chooser)));
			break;

		case R.id.call:
			intent.setAction(Intent.ACTION_CALL);
			intent.setData(Uri.parse("tel:9494401747"));
			startActivity(Intent.createChooser(intent,
					getResources().getString(R.string.chooser)));
			break;

		case R.id.contacts:
			intent.setAction(Intent.ACTION_VIEW);
			intent.setData(Uri.parse("content://contacts/people"));
			startActivity(Intent.createChooser(intent,
					getResources().getString(R.string.chooser)));

			break;

		case R.id.mail:
			intent.setAction(Intent.ACTION_SEND);
			startActivity(Intent.createChooser(intent,
					getResources().getString(R.string.chooser)));
			break;

		case R.id.music:
			intent.setAction(Intent.ACTION_MEDIA_BUTTON);
			startActivity(Intent.createChooser(intent,
					getResources().getString(R.string.chooser)));
			break;

		default:
			break;
		}

	}


}
