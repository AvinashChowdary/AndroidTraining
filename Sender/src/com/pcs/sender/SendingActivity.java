package com.pcs.sender;

import com.pcs.constants.Constants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SendingActivity extends Activity implements OnClickListener{

	private Button textBtn;
	private Button imageBtn;
	private Button webBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.sending);

		textBtn = (Button) findViewById(R.id.textBtn);
		imageBtn = (Button) findViewById(R.id.imageBtn);
		webBtn = (Button) findViewById(R.id.browseBtn);

		textBtn.setOnClickListener(this);
		imageBtn.setOnClickListener(this);
		webBtn.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.textBtn:
			Intent txtIntent = new Intent(Constants.InentExtras.TEXT);
			startActivity(txtIntent);
			break;

		case R.id.imageBtn:
			Intent imageIntent =  new Intent(Constants.InentExtras.IMAGE);
			startActivity(imageIntent);
			break;

		case R.id.browseBtn:
			Intent webIntent = new Intent(Constants.InentExtras.WEB);
			startActivity(webIntent);
			break;

		default:
			break;
		}

	}


}