package com.pcs.notifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NotifyOnBoot extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {

		String action = intent.getAction();

		if(action.equalsIgnoreCase("android.intent.action.BOOT_COMPLETED"))
		{

			Intent mIntent = new Intent(context, NotificationActivity.class);  
			mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(mIntent);  
		}
	}

}