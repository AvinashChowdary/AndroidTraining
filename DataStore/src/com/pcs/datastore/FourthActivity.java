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

public class FourthActivity extends Activity {
	
	private Button addressBtn;
	private EditText addressEdt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fourth);
		
		addressEdt = (EditText) findViewById(R.id.edt_address);
		
		addressBtn = (Button) findViewById(R.id.address_btn);
		
		addressBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(FourthActivity.this, FirstActivity.class);
				intent.putExtra(Constants.DataExtras.EMAIL,addressEdt.getText().toString());
				setResult(RESULT_OK, intent);
				finish();
				
			}
		});
		
	}

}
