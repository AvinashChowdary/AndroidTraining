package com.pcs.notifications;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BroadcastReceiver extends android.content.BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		
		Toast.makeText(context, "BroadcastReceiver Started.", Toast.LENGTH_LONG).show();
	}

}
