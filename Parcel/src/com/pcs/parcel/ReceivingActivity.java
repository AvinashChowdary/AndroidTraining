package com.pcs.parcel;

import com.pcs.helper.Constants;
import com.pcs.model.Employee;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;



public class ReceivingActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.receiving);

		Employee emp = getIntent().getParcelableExtra(Constants.IntentExtras.EMP_DETAILS);
		TextView txt = (TextView) findViewById(R.id.data);
		
		
		if(emp != null)
		{
			txt.setText(emp.toString());
		}
	}
}
