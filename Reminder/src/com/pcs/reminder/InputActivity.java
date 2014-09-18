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
	private EditText taskEdt;
	private TextView hiddenDate;
	private TextView hiddenTime;
	private TextView hiddenTask;
	private ProgressBar progressBar;
	private String dateset;
	private String timeset;
	private String taskset;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.form);

		dateBtn = (Button) findViewById(R.id.date_btn);
		reminderBtn = (Button) findViewById(R.id.add_task);
		timeBtn = (Button) findViewById(R.id.time_btn);
		taskEdt = (EditText) findViewById(R.id.task_edt);
		hiddenTime = (TextView) findViewById(R.id.hidden_time);
		hiddenDate = (TextView) findViewById(R.id.hidden_date);
		hiddenTask = (TextView) findViewById(R.id.hidden_task);

		progressBar = (ProgressBar) findViewById(R.id.progress);





		dateBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				dateSetter();


			}
		});  

		timeBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				timeSetter();

			}
		});

		reminderBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				getText();
			}
		});



	}

	protected void refresh() {

		Boolean datebool = TextUtils.isEmpty(dateset);;
		Boolean timebool = TextUtils.isEmpty(timeset);
		Boolean taskbool = TextUtils.isEmpty(taskset);

		if(!datebool){
			if(!timebool){
				if(!taskbool){
					progressBar.setProgress(100);
				}
				else{
					progressBar.setProgress(66);
				}

			}
			else if(!taskbool){
				progressBar.setProgress(66);
			}
			else{
				progressBar.setProgress(33);
			}
		}

		else if(!timebool){
			if(!taskbool){
				progressBar.setProgress(66);
			}
			else{
				progressBar.setProgress(33);
			}
		}
		else if(!taskbool){

			progressBar.setProgress(33);

		}





	}

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



	protected void getText(){
		String task = taskEdt.getText().toString();

		if(!TextUtils.isEmpty(task)){
			hiddenTask.setText(getResources().getString(R.string.entered_task)+task);

			taskset = hiddenTask.getText().toString();
			hiddenDate.setVisibility(View.VISIBLE);
			hiddenTime.setVisibility(View.VISIBLE);
			hiddenTask.setVisibility(View.VISIBLE);
		}
		refresh();

	}

}
