package com.pcs.notifications;

import com.pcs.constants.Constants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
/**
 * This class is created with UI to take text as input
 * on clicking a button it moves to Broadcast Receiver
 * @author Avinash
 *
 */

public class BroadcastActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);

		final EditText msgEdt = (EditText) findViewById(R.id.msg_txt);
		Button sendBtn = (Button) findViewById(R.id.send_btn);
		

		sendBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				//Toast to show message arrived
				Toast.makeText(BroadcastActivity.this, getResources().getString(R.string.new_msg), Toast.LENGTH_LONG).show();
				//Intent for BroadcastReceiver
				Intent intent = new Intent();
				intent.setAction("com.pcs.BROADCAST");
				//Sending Message as an Extra on Intent
				intent.putExtra(Constants.IntentExtras.MESSAGE, msgEdt.getText().toString());
				//Sending Broadcast
				sendBroadcast(intent);		
			}
		});
		
	}

}
