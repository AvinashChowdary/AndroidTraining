package com.pcs.sender;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.pcs.constants.Constants;

public class SendingActivity extends Activity implements OnClickListener{


	private Button imageBtn;
	private Button webpageBtn;
	private Button textBtn;


	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.sending);

		imageBtn = (Button) findViewById(R.id.image);
		textBtn = (Button) findViewById(R.id.text);
		webpageBtn = (Button) findViewById(R.id.webpage);

		textBtn.setOnClickListener(this);
		imageBtn.setOnClickListener(this);		
		webpageBtn.setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {


		switch (v.getId()) {
		case R.id.image:
			
			Intent imageIntent=new Intent(Constants.IntentExtras.IMAGE);
			imageIntent.addCategory(Intent.CATEGORY_LAUNCHER);
			startActivity(imageIntent);


			break;
		case R.id.text:
			Intent textIntent=new Intent(Constants.IntentExtras.TEXT);
			textIntent.addCategory(Intent.CATEGORY_LAUNCHER);
			startActivity(textIntent);
			break;

		case R.id.webpage:
			Intent webpageIntent=new Intent(Constants.IntentExtras.WEBPAGE);
			webpageIntent.addCategory(Intent.CATEGORY_LAUNCHER);
			startActivity(webpageIntent);
			break;

		default:
			break;
		}

	}
}
