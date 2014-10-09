package com.pcs.contacts;

import android.app.Activity;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pcs.provider.ContactProvider;

public class ContactsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button addBtn = (Button) findViewById(R.id.add);
				
		addBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
					
				   ContentValues values = new ContentValues();
				   
				   values.put(ContactProvider.NAME,((EditText) findViewById(R.id.name)).getText().toString());
				   values.put(ContactProvider.EMAIL,((EditText) findViewById(R.id.email)).getText().toString());
				   values.put(ContactProvider.NUMBER,((EditText) findViewById(R.id.number)).getText().toString());
				   values.put(ContactProvider.HOME,((EditText) findViewById(R.id.home)).getText().toString());
				   
				   Uri uri = getContentResolver().insert(
						      ContactProvider.CONTENT_URI, values);
				   Toast.makeText(getBaseContext(), 
						      uri.toString(), Toast.LENGTH_LONG).show();
				
			}
		});
		
		
	}
}
