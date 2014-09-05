
package com.example.edittextdemo;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class EditTextDemo extends Activity {
	public static final String TAG ="EditTextDemo";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edittextdemo);
		EditText usernameedt = (EditText) findViewById(R.id.UserName);
		EditText passwordedt = (EditText) findViewById(R.id.Password);
		String username = usernameedt.getText().toString();
		String password = passwordedt.getText().toString();
		Log.d(TAG,"Username"+username);
		Log.d(TAG,"Password"+password);
		
		
	}

}
