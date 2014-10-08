package com.pcs.logindemo;

import com.pcs.constants.Constants;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class WelcomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);

		TextView welcomeTxt = (TextView) findViewById(R.id.welcome_txt);

		welcomeTxt.setText(getResources().getString(R.string.welcome_msg) + " "
				+ getIntent().getStringExtra(Constants.LoginExtras.USERNAME));
	}

}
