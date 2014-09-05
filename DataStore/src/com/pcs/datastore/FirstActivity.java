package com.pcs.datastore;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.example.datastore.R;
import com.pcs.constants.Constants;

public class FirstActivity extends Activity {

	private Button firstBtn;
	private Button secondBtn;
	private Button thirdBtn;
	public static final int REQ_A=101;
	public static final int REQ_B=102;
	public static final int REQ_C=103;
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.first);

		firstBtn = (Button) findViewById(R.id.first_btn);
		secondBtn = (Button) findViewById(R.id.second_btn);
		thirdBtn =  (Button) findViewById(R.id.third_btn);

		firstBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
				startActivityForResult(intent,REQ_A);

			}
		});
		secondBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent second_intent = new Intent(FirstActivity.this, ThirdActivity.class);
				startActivityForResult(second_intent,REQ_B);
			}
		});
		thirdBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent third_intent = new Intent(FirstActivity.this, FourthActivity.class);
				startActivityForResult(third_intent,REQ_C);

			}
		});
	}


	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		super.onActivityResult(requestCode, resultCode, data);

		if(requestCode == REQ_A){
			String value = data.getExtras().getString(Constants.DataExtras.NAME);
			Toast.makeText(FirstActivity.this,value,Toast.LENGTH_LONG).show();
		}

		if(requestCode == REQ_B){
			String value = data.getExtras().getString(Constants.DataExtras.PHONE);
			Toast.makeText(FirstActivity.this,value,Toast.LENGTH_LONG).show();
		}

		if(requestCode == REQ_C){
			String value = data.getExtras().getString(Constants.DataExtras.EMAIL);
			Toast.makeText(FirstActivity.this,value,Toast.LENGTH_LONG).show();
		}
	}

}
