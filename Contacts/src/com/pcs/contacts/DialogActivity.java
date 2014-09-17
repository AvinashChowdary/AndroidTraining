package com.pcs.contacts;

import java.util.ArrayList;


import com.pcs.model.Contacts;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class DialogActivity extends Activity {


	private Button addBtn;
	private ArrayList<Contacts> contactslist;
	private ListView listView;
	private LayoutInflater layoutInflater;
	private Button createBtn;
	private Button cancelBtn;
	private EditText nameEdt;
	private EditText phoneEdt;
	private EditText emailEdt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		addBtn = (Button) findViewById(R.id.add_btn);
		contactslist =   new ArrayList<Contacts>();
		listView = (ListView) findViewById(R.id.listview);
		layoutInflater = LayoutInflater.from(DialogActivity.this);

		addBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				AlertDialog.Builder dialog = new AlertDialog.Builder(DialogActivity.this);
				dialog.setTitle(R.string.dialog_title);

				View view = layoutInflater.inflate(R.layout.dialog, null);
				dialog.setView(view);

				dialog.create();
				dialog.show();

				createBtn = (Button) view.findViewById(R.id.create_btn);
				cancelBtn = (Button) view.findViewById(R.id.cancel_btn);
				
				nameEdt = (EditText) view.findViewById(R.id.name_edt);
				phoneEdt = (EditText) view.findViewById(R.id.phone_edt);
				emailEdt = (EditText) view.findViewById(R.id.email_edt);
				
				
				createBtn.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						

					}
				});

				cancelBtn.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						finish();

					}
				});

			}
		});
	}
}
