package com.pcs.datastore;

import com.example.datastore.R;
import com.pcs.constants.Constants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends Activity {
	
	private Button emailBtn;
	private EditText emailEdt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		
		emailEdt = (EditText) findViewById(R.id.edt_email);
		
		
		emailBtn = (Button) findViewById(R.id.email_btn);
		
		emailBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(SecondActivity.this, FirstActivity.class);
				intent.putExtra(Constants.DataExtras.NAME,emailEdt.getText().toString());
				setResult(Activity.RESULT_OK, intent);
				finish();
			}
		});
		
	}

}
