package com.pcs.reminder;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TimePicker;

public class InputActivity extends Activity{

	private Button dateBtn;
	private Button timeBtn;
	private Button reminderBtn;
	private Button taskBtn;
	private EditText taskEdt;
	private TextView hiddenDate;
	private TextView hiddenTime;
	private TextView hiddenTask;
	private TextView hiddenError;
	private ProgressBar progressBar;
	private String dateset;
	private String timeset;
	private String taskset;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.form);

		dateBtn = (Button) findViewById(R.id.date_btn);
		taskBtn = (Button) findViewById(R.id.task_btn);
		reminderBtn = (Button) findViewById(R.id.add_task);
		timeBtn = (Button) findViewById(R.id.time_btn);
		taskEdt = (EditText) findViewById(R.id.task_edt);
		hiddenTime = (TextView) findViewById(R.id.hidden_time);
		hiddenDate = (TextView) findViewById(R.id.hidden_date);
		hiddenTask = (TextView) findViewById(R.id.hidden_task);
		hiddenError = (TextView) findViewById(R.id.hidden_error);

		progressBar = (ProgressBar) findViewById(R.id.progress);




		/**
		 * on Click Date button navigate to dateSetter() method
		 */
		dateBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				dateSetter();


			}
		});  

		/**
		 * on Click Time button navigate to timeSetter() method
		 */
		timeBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				timeSetter();

			}
		});

		/**
		 * on Click Task button set task to reminder
		 */
		taskBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String task = taskEdt.getText().toString();

				if(!TextUtils.isEmpty(task)){
					hiddenTask.setText(getResources().getString(R.string.entered_task)+task);
					taskset = hiddenTask.getText().toString();

					refresh();
				}

			}
		});

		/**
		 * on Clicking reminder button displaying details of the reminder
		 */

		reminderBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if(!TextUtils.isEmpty(dateset) && 
						!TextUtils.isEmpty(timeset) && 
						!TextUtils.isEmpty(taskset)){
					hiddenError.setVisibility(View.INVISIBLE);
					displayText();
				}
				else{
					hiddenError.setVisibility(View.VISIBLE);
					hiddenError.setText(getResources().getString(R.string.error));
				}
			}


		});



	}
	/**
	 * to dynamically set the progress bar
	 * using the Text.Utils to validate strings
	 */
	protected void refresh() {

		int a=1,b=1,c=1;

		Boolean datebool = TextUtils.isEmpty(dateset);
		Boolean timebool = TextUtils.isEmpty(timeset);
		Boolean taskbool = TextUtils.isEmpty(taskset);

		if(datebool){
			a=0;
		}
		if(timebool){
			b=0;
		}
		if(taskbool){
			c=0;
		}

		int sum=a+b+c;
		int progress=sum*33;
		progressBar.setProgress(progress);




	}

	/**
	 * To retreive time from calender instance 
	 */
	protected void timeSetter() {
		Calendar calendar = Calendar.getInstance();
		final int hour = calendar.get(Calendar.HOUR_OF_DAY);
		final int minute = calendar.get(Calendar.MINUTE);
		TimePickerDialog timePicker = new TimePickerDialog(InputActivity.this, new OnTimeSetListener() {

			@Override
			public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

				hiddenTime.setText(getResources().getString(R.string.entered_time)+hourOfDay+" : "+minute);
				timeset = hiddenTime.getText().toString();
				timeBtn.setText(timeset);
				refresh();

			}
		}, hour, minute, true);
		timePicker.show();

	}

	/**
	 * To retreive date from calender instance 
	 */	
	protected void dateSetter() {

		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int date = calendar.get(Calendar.DAY_OF_MONTH);

		DatePickerDialog datePicker = new DatePickerDialog(InputActivity.this,
				new OnDateSetListener(){

			@Override
			public void onDateSet(DatePicker view, int year,
					int monthOfYear, int dayOfMonth) {

				hiddenDate.setText(getResources().getString(R.string.entered_date)+dayOfMonth+"/"+monthOfYear+"/"+year);
				dateset = hiddenDate.getText().toString();
				dateBtn.setText(dateset);
				refresh();


			}

		}, year, month, date);
		datePicker.show();
	}


	/**
	 * to display the details of selected Reminder
	 */
	protected void displayText(){
		String task = taskEdt.getText().toString();


		hiddenDate.setVisibility(View.VISIBLE);
		hiddenTime.setVisibility(View.VISIBLE);
		hiddenTask.setVisibility(View.VISIBLE);


	}

}
