package com.pcs.parcel;

import com.pcs.helper.Constants;
import com.pcs.model.Employee;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SendingActivity extends Activity {
	
	private EditText name_edt;
	private EditText empid_edt;
	private EditText dept_edt;
	private EditText salary_edt;
	private Button submitBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sending);
		
		name_edt = (EditText) findViewById(R.id.name_edt);
		empid_edt = (EditText) findViewById(R.id.empid_edt);
		dept_edt = (EditText) findViewById(R.id.dept_edt);
		salary_edt = (EditText) findViewById(R.id.salary_edt);
		submitBtn = (Button) findViewById(R.id.submit_btn);
		
		submitBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SendingActivity.this, ReceivingActivity.class);
				Employee emp = new Employee();
				emp.setName(name_edt.getText().toString());
				emp.setEmpid(empid_edt.getText().toString());
				emp.setDept(dept_edt.getText().toString());
				emp.setSalary(salary_edt.getText().toString());
				intent.putExtra(Constants.IntentExtras.EMP_DETAILS, emp);
				startActivity(intent);
			}
		});
	}

}
