package com.example.screenactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rotatescreen.R;

public class ScreenActivity extends Activity{

	private EditText streamEdt;
	private Button submitBtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.rotatescreen);

		streamEdt = (EditText) findViewById(R.id.stream_edt);

		submitBtn = (Button) findViewById(R.id.btn);
		submitBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(ScreenActivity.this, streamEdt.getText().toString(), Toast.LENGTH_LONG).show();
			}
		});

	}

}
