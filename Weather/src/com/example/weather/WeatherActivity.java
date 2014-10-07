package com.example.weather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class WeatherActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_layout);
		//obtaining views
		EditText nameEdt = (EditText) findViewById(R.id.name);
		EditText pwdEdt = (EditText) findViewById(R.id.password);
		Button sendBtn = (Button) findViewById(R.id.sendBtn);
		//verifying if the values are null or not
		if(nameEdt.getText().toString()!=null 
				&& pwdEdt.getText().toString()!=null){

			sendBtn.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					//moving from login to weather page
					Intent mIntent = new Intent(WeatherActivity.this,
							CityActivity.class);
					startActivity(mIntent);

				}
			});
		}
	}

	
}
