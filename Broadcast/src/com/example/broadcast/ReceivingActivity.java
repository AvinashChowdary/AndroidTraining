package com.example.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ReceivingActivity extends BroadcastReceiver{
	
	
	@Override
	public void onReceive(Context context, Intent intent) {
		
		//on receiving the broadcast toast is displayed
		Toast.makeText(context, 
				R.string.toast_receive, Toast.LENGTH_LONG).show();
	}

}
