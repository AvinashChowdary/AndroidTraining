package com.example.scheduledexecutorservice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

	private ScheduledExecutorService scheduledExecutorService;

	private ScheduledFuture<?> scheduledFuture;

	private int count = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.start_btn).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				scheduledExecutorService = Executors.newScheduledThreadPool(5);
				scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(
						new Runnable() {

							@Override
							public void run() {
								Log.e("Count", count++ + "");
							}
						}, 1, 2, TimeUnit.SECONDS);
			}
		});

		findViewById(R.id.stop_btn).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				scheduledFuture.cancel(true);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
