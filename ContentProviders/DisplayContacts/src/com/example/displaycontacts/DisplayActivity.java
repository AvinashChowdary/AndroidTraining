package com.example.displaycontacts;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class DisplayActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display);

		final ListView listView = (ListView) findViewById(R.id.listview);
		Button displayBtn = (Button) findViewById(R.id.display);

		displayBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				ContentResolver contentResolver = getContentResolver();

				Uri mUri = Uri
						.parse("content://com.pcs.provider.ContactProvider/contact");

				Cursor mCursor = contentResolver.query(mUri, null, null, null,
						null);

				while (mCursor.moveToNext()) {
					SimpleCursorAdapter adapter = new SimpleCursorAdapter(
							getBaseContext(), R.layout.adapter, mCursor,
							new String[] { "_id", "_name", "_email", "_phone",
									"_home" }, new int[] { R.id.id, R.id.name,
									R.id.email, R.id.number, R.id.home, });
					listView.setAdapter(adapter);
				}

			}
		});
	}

}
