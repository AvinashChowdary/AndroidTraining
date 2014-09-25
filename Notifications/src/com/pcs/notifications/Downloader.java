package com.pcs.notifications;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;


/**
 * This class is used to start a notification along with progress
 * @author Avinash
 *
 */
public class Downloader extends BroadcastReceiver{
	private static final int REQ_B=108;
	@Override
	public void onReceive(Context context, Intent intent) {

		
		//NotificationCompat for the activity context
		final NotificationCompat.Builder notificationBuilder = 
				new NotificationCompat.Builder(context);
		//Adding icon, Title, Text for Notification
		notificationBuilder.setSmallIcon(R.drawable.app_icon);
		notificationBuilder.setContentTitle(context.getResources().getString(R.string.download_txt));
		notificationBuilder.setContentText(context.getResources().getString(R.string.downloading_txt));
		//Getting Notification Manager
		final NotificationManager notificationManager = 
				(NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		
		Intent notificationIntent = new Intent(context , DownloadActivity.class);
		
		
		PendingIntent pendingIntent = 
				PendingIntent.getActivity(context, REQ_B, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
		
				
		notificationBuilder.setContentIntent(pendingIntent);
		notificationBuilder.setAutoCancel(true);
		//Setting Flags to ensure that new activity is not started
				//Removing Top Activity from stack
				//creating new task
		notificationIntent.setFlags(notificationIntent.FLAG_ACTIVITY_NEW_TASK | notificationIntent.FLAG_ACTIVITY_CLEAR_TASK);
		
		//using threads for displaying progress
		new Thread(new Runnable() {
			@Override
			public void run() {
				int count;

				for (count = 0; count <= 100; count++) {
					notificationBuilder.setProgress(100, count, false);

					notificationManager.notify(REQ_B, notificationBuilder.build());
					try {

						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				notificationBuilder.setContentText("Download complete").setProgress(0,0,false);
				notificationManager.notify(REQ_B, notificationBuilder.build());
			}
		}).start();
		 
	}

}
