package com.pcs.notifications;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.pcs.constants.Constants;

/**
 * This class is used to receive message and send a Notification
 * @author Avinash
 *
 */
public class BroadcastReceiver extends android.content.BroadcastReceiver{

	private static final int REQ_A=107;
	@Override
	public void onReceive(Context context, Intent intent) {


		//Getting Message from Intent
		String message = intent.getStringExtra(Constants.IntentExtras.MESSAGE);

		//NotificationCompat for the activity context
		NotificationCompat.Builder notificationBuilder = 
				new NotificationCompat.Builder(context);
		//Adding icon, Title, Text for Notification
		notificationBuilder.setSmallIcon(R.drawable.app_icon);
		notificationBuilder.setContentTitle(context.getResources().getString(R.string.msg_title));
		notificationBuilder.setContentText(message);

		//Getting Notification Manager
		NotificationManager notificationManager = 
				(NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

		//Intent for Notification
		Intent notificationIntent = new Intent(context , DownloadActivity.class);
		notificationIntent.putExtra(Constants.IntentExtras.MESSAGE, message);

		//Pending Intent using the Notification Intent
		PendingIntent pendingIntent = 
				PendingIntent.getActivity(context, REQ_A, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

		//Setting Pending Intent to Notification Builder
		notificationBuilder.setContentIntent(pendingIntent);
		notificationBuilder.setAutoCancel(true);
		
		//Setting Flags to ensure that new activity is not started
		//Removing Top Activity from stack
		//creating new task
		notificationIntent.setFlags(notificationIntent.FLAG_ACTIVITY_NEW_TASK | notificationIntent.FLAG_ACTIVITY_CLEAR_TASK);

		//Notifying notification
		notificationManager.notify(REQ_A, notificationBuilder.build());



	}

}
