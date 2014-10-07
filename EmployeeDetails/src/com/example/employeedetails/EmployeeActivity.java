package com.example.employeedetails;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


import com.pcs.constants.Constants;
import com.pcs.model.Employee;

public class EmployeeActivity extends Activity {

	private EditText idEdt;
	private EditText nameEdt;
	private EditText designationEdt;
	private Button sendBtn; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		//obtaining views
		idEdt = (EditText) findViewById(R.id.id);
		nameEdt = (EditText) findViewById(R.id.name);
		designationEdt = (EditText) findViewById(R.id.designation);
		sendBtn = (Button) findViewById(R.id.send);
		//on click listener sends the parcel object
		sendBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent mIntent = new Intent(EmployeeActivity.this,
						DisplayingActivity.class);
				//setting values to employee object using setters
				Employee mEmployee = new Employee();
				mEmployee.setId(idEdt.getText().toString());
				mEmployee.setName(nameEdt.getText().toString());
				mEmployee.setDesignation(designationEdt.getText().toString());	
				//using constant as key to send intent
				mIntent.putExtra(Constants.EmployeeExtras.EMPLOYEE, mEmployee);
				startActivity(mIntent);
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.employee, menu);
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
