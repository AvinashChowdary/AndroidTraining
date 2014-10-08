package com.pcs.contacts;

import com.pcs.provider.ContactProvider;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ContactsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button addBtn = (Button) findViewById(R.id.add);
		Button getBtn = (Button) findViewById(R.id.get);
		
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
		
		getBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String URL = "content://com.pcs.provider.Contacts/contact";
			      Uri students = Uri.parse(URL);
			      Cursor c = managedQuery(students, null, null, null, "name");
			      if (c.moveToFirst()) {
			         do{
			            Toast.makeText(ContactsActivity.this, 
			            c.getString(c.getColumnIndex(ContactProvider.ID)) + 
			            ", " +  c.getString(c.getColumnIndex( ContactProvider.NAME)) + 
			            ", " + c.getString(c.getColumnIndex( ContactProvider.NUMBER))+","+
			            c.getString(c.getColumnIndex( ContactProvider.HOME)), 
			            Toast.LENGTH_SHORT).show();
			         } while (c.moveToNext());
			      }
			   }
				
		});
	}
}
