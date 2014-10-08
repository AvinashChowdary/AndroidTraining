package com.pcs.notifications;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

@SuppressLint("NewApi")
public class NotificationActivity extends Activity {

	private static final int REQ_A = 107;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.notification_layout);

		// NotificationCompat for the activity context
		NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(
				this);

		// Adding icon, Title, Text for Notification
		notificationBuilder.setSmallIcon(R.drawable.ic_launcher);
		notificationBuilder.setContentTitle(NotificationActivity.this
				.getResources().getString(R.string.msg_title));
		notificationBuilder.setContentText(NotificationActivity.this
				.getResources().getString(R.string.message));

		NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
		String[] msgs = new String[3];
		msgs[0] = new String("Hi");
		msgs[1] = new String("Hello");
		msgs[2] = new String("How are you");

		inboxStyle.setBigContentTitle(NotificationActivity.this.getResources()
				.getString(R.string.msg_title));

		int len = msgs.length;
		for (int i = 0; i < len; i++) {

			inboxStyle.addLine(msgs[i]);
		}
		// Moves the big view style object into the notification object.
		notificationBuilder.setStyle(inboxStyle);

		// Getting Notification Manager
		NotificationManager notificationManager = (NotificationManager) NotificationActivity.this
				.getSystemService(Context.NOTIFICATION_SERVICE);
		// Intent for Notification
		Intent notificationIntent = new Intent(NotificationActivity.this,
				NotificationActivity.class);

		// Pending Intent using the Notification Intent
		PendingIntent pendingIntent = PendingIntent.getActivity(
				NotificationActivity.this, REQ_A, notificationIntent,
				PendingIntent.FLAG_UPDATE_CURRENT);

		// Setting Pending Intent to Notification Builder
		notificationBuilder.setContentIntent(pendingIntent);
		notificationBuilder.setAutoCancel(true);

		// Setting Flags to ensure that new activity is not started
		// Removing Top Activity from stack
		// creating new task
		notificationIntent.setFlags(notificationIntent.FLAG_ACTIVITY_NEW_TASK
				| notificationIntent.FLAG_ACTIVITY_CLEAR_TASK);

		// Notifying notification
		notificationManager.notify(REQ_A, notificationBuilder.build());

	}

}
