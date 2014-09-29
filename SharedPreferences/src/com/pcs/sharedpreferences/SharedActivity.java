package com.pcs.sharedpreferences;

import com.pcs.sharedpreferences.R;
import com.pcs.constants.Constants;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SharedActivity extends Activity{

	private  EditText nameEdt;
	private EditText pwdEdt;
	private SharedPreferences mSharedPreferences; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.shared_layout);

		nameEdt = (EditText) findViewById(R.id.name);
		pwdEdt = (EditText) findViewById(R.id.pwd);
		Button loginBtn = (Button) findViewById(R.id.login);

		mSharedPreferences = getPreferences(MODE_PRIVATE);

		if(mSharedPreferences.contains(Constants.IntentExtras.NAME)){
			
			if(mSharedPreferences.contains(Constants.IntentExtras.PASSWORD)){
			
				Intent mIntent = new Intent(getBaseContext(), ResultActivity.class);
				
				mIntent.putExtra(Constants.IntentExtras.NAME, 
						mSharedPreferences.getString(Constants.IntentExtras.NAME, null));
				
				startActivity(mIntent);
			}
		}

			loginBtn.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {


					Editor editor = mSharedPreferences.edit();

					editor.putString(Constants.IntentExtras.NAME, nameEdt.getText().toString());
					editor.putString(Constants.IntentExtras.PASSWORD, pwdEdt.getText().toString());

					editor.commit();

					Intent mIntent = new Intent(getBaseContext(), ResultActivity.class);
					mIntent.putExtra(Constants.IntentExtras.NAME, nameEdt.getText().toString());
					startActivity(mIntent);
				}
			});
		}

	}
