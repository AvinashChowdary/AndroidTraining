package com.pcs.notifications;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.pcs.constants.Constants;


public class BroadcastReceiver extends android.content.BroadcastReceiver{

	private static final int REQ_A=107;
	@Override
	public void onReceive(Context context, Intent intent) {
		
		
		
		String message = intent.getStringExtra(Constants.IntentExtras.MESSAGE);
		
		NotificationCompat.Builder notificationBuilder = 
				new NotificationCompat.Builder(context);
		
		notificationBuilder.setSmallIcon(R.drawable.app_icon);
		notificationBuilder.setContentTitle(context.getResources().getString(R.string.msg_title));
		notificationBuilder.setContentText(message);
		
		NotificationManager notificationManager = 
				(NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		
		Intent notificationIntent = new Intent(context , DownloadActivity.class);
		notificationIntent.putExtra(Constants.IntentExtras.MESSAGE, message);
		
		PendingIntent pendingIntent = 
				PendingIntent.getActivity(context, REQ_A, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
		
				
		notificationBuilder.setContentIntent(pendingIntent);
		notificationBuilder.setAutoCancel(true);
		
		notificationIntent.setFlags(notificationIntent.FLAG_ACTIVITY_NEW_TASK | notificationIntent.FLAG_ACTIVITY_CLEAR_TASK);
		
		notificationManager.notify(REQ_A, notificationBuilder.build());
		
		
		
	}

}
