package com.pcs.reminder;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.os.Bundle;
import android.transition.Visibility;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class InputActivity extends Activity{

	private Button dateBtn;
	private Button timeBtn;
	private EditText taskEdt;
	private TextView hiddenTxt;
	private ProgressBar progressBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.form);

		dateBtn = (Button) findViewById(R.id.date_btn);
		timeBtn = (Button) findViewById(R.id.time_btn);
		taskEdt = (EditText) findViewById(R.id.task_edt);
		hiddenTxt = (TextView) findViewById(R.id.hidden_txt);
		progressBar = (ProgressBar) findViewById(R.id.progress);

		Calendar calendar = Calendar.getInstance();
		final int year = calendar.get(Calendar.YEAR);
		final int month = calendar.get(Calendar.MONTH);
		final int date = calendar.get(Calendar.DAY_OF_MONTH);

		dateBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {


				DatePickerDialog datePicker = new DatePickerDialog(InputActivity.this,
						new OnDateSetListener(){

					@Override
					public void onDateSet(DatePicker view, int year,
							int monthOfYear, int dayOfMonth) {

						hiddenTxt.setVisibility(View.VISIBLE);
						hiddenTxt.setText("Task set on Date : "+date+"/"+month+1+"/"+year);
						progressBar.setProgress(34);
					}

				}, year, month+1, date);
				datePicker.show();
			}

		});  

	}


}
