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

public class ThirdActivity extends Activity {
	
	private Button phoneBtn;
	private EditText phoneEdt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.third);
		
		phoneEdt = (EditText) findViewById(R.id.edt_phone);
		
		
		phoneBtn = (Button) findViewById(R.id.phpne_btn);
		
		
		phoneBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(ThirdActivity.this, FirstActivity.class);
				intent.putExtra(Constants.DataExtras.PHONE,phoneEdt.getText().toString());
				setResult(RESULT_OK, intent);
				finish();
			}
		});
		
	}

}
