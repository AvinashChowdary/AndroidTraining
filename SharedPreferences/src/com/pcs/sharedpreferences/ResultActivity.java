package com.pcs.sharedpreferences;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.pcs.constants.Constants;

public class ResultActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result_layout);
		
		TextView resultTxt = (TextView) findViewById(R.id.result_name);
		Button logoutBtn = (Button) findViewById(R.id.logout);
		
		resultTxt.setText(getResources().getString(R.string.welcome_msg)+" "+getIntent().getStringExtra(Constants.IntentExtras.NAME));
		
		logoutBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				moveTaskToBack(true);
				ResultActivity.this.finish();
			}
		});
	}

}
