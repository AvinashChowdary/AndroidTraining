package com.pcs.notifications;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class BroadcastActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);

		EditText msgEdt = (EditText) findViewById(R.id.msg_txt);
		Button sendBtn = (Button) findViewById(R.id.send_btn);

		sendBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent intent = new Intent();
				intent.setAction("com.pcs.BROADCAST");
				sendBroadcast(intent);		
			}
		});

	}

}
