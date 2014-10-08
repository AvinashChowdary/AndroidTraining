package com.pcs.logindemo;

import com.pcs.constants.Constants;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity implements OnClickListener {

	private EditText usernameEdt;
	private EditText passwordEdt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_layout);

		usernameEdt = (EditText) findViewById(R.id.username);
		passwordEdt = (EditText) findViewById(R.id.passowrd);
		Button loginBtn = (Button) findViewById(R.id.login);

		loginBtn.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		if (usernameEdt != null && passwordEdt != null) {

			if ((usernameEdt.getText().toString().trim()
					.equals(Constants.LoginExtras.USERNAME))
					&& (passwordEdt.getText().toString().trim()
							.equals(Constants.LoginExtras.PASSWSORD))) {
				Intent mIntent = new Intent(LoginActivity.this,
						WelcomeActivity.class);
				mIntent.putExtra(Constants.LoginExtras.USERNAME, usernameEdt
						.getText().toString());
				startActivity(mIntent);
			} else {
				Toast.makeText(this,
						getResources().getString(R.string.login_fail),
						Toast.LENGTH_LONG).show();

			}

		} else {
			Toast.makeText(this, getResources().getString(R.string.login_null),
					Toast.LENGTH_LONG).show();
		}

	}

}
