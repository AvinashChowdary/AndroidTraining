package com.example.employeedetails;

import com.pcs.constants.Constants;
import com.pcs.model.Employee;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayingActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display_layout);
		//getting parcel from the intent
		Employee mEmp = getIntent().getParcelableExtra(Constants.EmployeeExtras.EMPLOYEE);
		TextView idTxt = (TextView) findViewById(R.id.result_id);
		
		if(mEmp!=null){
			//using toString method to display in the textView
			idTxt.setText(mEmp.toString());
		}
	}
}
