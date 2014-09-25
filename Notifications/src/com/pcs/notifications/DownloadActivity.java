package com.pcs.notifications;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.pcs.constants.Constants;
/**
 * This class is used to Start a broadcast 
 * @author Avinash
 *
 */
public class DownloadActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.donwload_layout);
		Button downloadBtn = (Button) findViewById(R.id.download_btn);
		TextView txt = (TextView)findViewById(R.id.textView);
		txt.setText(getIntent().getStringExtra(Constants.IntentExtras.MESSAGE));
		
		downloadBtn.setOnClickListener(new OnClickListener() {

			
			@Override
			public void onClick(View v) {

				//Displaying toast for downloading
				Toast.makeText(DownloadActivity.this, getResources().getString(R.string.downloading_txt), Toast.LENGTH_LONG).show();
				Intent intent = new Intent();
				intent.setAction("com.pcs.DOWNLOAD");
				//Sending Broadcast
				sendBroadcast(intent);

			}
		});
	}
}
