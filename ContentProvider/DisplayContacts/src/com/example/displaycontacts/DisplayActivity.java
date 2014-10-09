package com.example.displaycontacts;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class DisplayActivity extends Activity {

	private ContentResolver contentResolver;
	private Uri mUri;
	private Cursor mCursor;
	private ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display);

		listView = (ListView) findViewById(R.id.listview);

		contentResolver = getContentResolver();

		mUri = Uri.parse("content://com.pcs.provider.ContactProvider/contact");
		getContentResolver().registerContentObserver(mUri, false, mObserver);

		Button displayBtn = (Button) findViewById(R.id.display);
		Button deleteBtn = (Button) findViewById(R.id.delete);
		retreive(listView);

		displayBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				retreive(listView);

			}
		});

		deleteBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				delete();

			}
		});
	}

	private ContentObserver mObserver = new ContentObserver(new Handler()) {
		@Override
		public void onChange(boolean selfChange) {
			super.onChange(selfChange);
			retreive(listView);
		}

		public void onChange(boolean selfChange, Uri uri) {
			retreive(listView);
		};
	};

	@SuppressWarnings("deprecation")
	private void retreive(final ListView listView) {

		mCursor = contentResolver.query(mUri, null, null, null, null);

		if (mCursor != null) {
			SimpleCursorAdapter adapter = new SimpleCursorAdapter(
					getBaseContext(), R.layout.adapter, mCursor, new String[] {
							"_id", "_name", "_email", "_phone", "_home" },
					new int[] { R.id.id, R.id.name, R.id.email, R.id.number,
							R.id.home, });
			listView.setAdapter(adapter);
		} else {
			Toast.makeText(getBaseContext(),
					getResources().getString(R.string.no_contacts),
					Toast.LENGTH_LONG).show();
		}

	}

	private void delete() {

		int count = contentResolver.delete(mUri, null, null);
		if (count > 0) {
			Toast.makeText(
					getBaseContext(),
					count + " "
							+ getResources().getString(R.string.delete_toast),
					Toast.LENGTH_LONG).show();
		} else {
			Toast.makeText(getBaseContext(),
					getResources().getString(R.string.not_deleted),
					Toast.LENGTH_LONG).show();
		}

	}

}
