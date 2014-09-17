package com.pcs.contacts;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.pcs.adapters.CustomAdapter;
import com.pcs.model.Contacts;

public class DialogActivity extends Activity {


	private Button addBtn;
	private ArrayList<Contacts> contactslist;
	private ListView listView;
	private LayoutInflater layoutInflater;
	private AlertDialog alertDialog;
	private Button createBtn;
	private Button cancelBtn;
	private EditText nameEdt;
	private EditText phoneEdt;
	private EditText emailEdt;
	private View view;
	private View editView;
	private Contacts contact = new Contacts();

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		addBtn = (Button) findViewById(R.id.add_btn);
		contactslist =   new ArrayList<Contacts>();
		listView = (ListView) findViewById(R.id.listview);
		layoutInflater = LayoutInflater.from(DialogActivity.this);


		listView.setOnItemClickListener(new OnItemClickListener() {

			/**
			 * To call when user clicks on a contact
			 */
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				String call = "tel:"+contactslist.get(position).getPhone();
				Intent intent = new Intent(Intent.ACTION_CALL);
				intent.setData(Uri.parse(call));
				startActivity(intent);

			}
		});

		/**
		 * Click listener to show call,message and 
		 * email options when user long presses the item
		 */

		listView.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					final int position, long id) {

				AlertDialog.Builder alert = new AlertDialog.Builder(DialogActivity.this);

				alert.setTitle(R.string.choose);
				alert.setItems(R.array.choices, new android.content.DialogInterface.OnClickListener() {

					/**
					 * To perform actions when user selects one
					 * among the list in the Dialog
					 */

					@Override
					public void onClick(DialogInterface dialog, int which) {
						switch (which) {
						case 0:
							String call = "tel:"+contactslist.get(position).getPhone();
							Intent intent = new Intent(Intent.ACTION_CALL);
							intent.setData(Uri.parse(call));
							startActivity(intent);
							break;

						case 1:
							Toast.makeText(DialogActivity.this, getResources().getString(R.string.msg_toast)+phoneEdt.getText().toString(), Toast.LENGTH_LONG).show();
							break;


						case 2:
							Toast.makeText(DialogActivity.this, getResources().getString(R.string.mail_toast)+emailEdt.getText().toString(), Toast.LENGTH_LONG).show();
							break;
						default:
							break;
						}
					}
				});






				alert.create();
				alert.show();

				return false;
			}


		});


		/**
		 * This click listener is used
		 * To add a new contact 
		 */
		addBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				AlertDialog.Builder dialog = new AlertDialog.Builder(DialogActivity.this);
				dialog.setTitle(R.string.dialog_title);

				view = layoutInflater.inflate(R.layout.dialog, null);
				dialog.setView(view);

				alertDialog = dialog.create();
				alertDialog.show();


				createBtn = (Button) view.findViewById(R.id.create_btn);
				cancelBtn = (Button) view.findViewById(R.id.cancel_btn);

				nameEdt = (EditText) view.findViewById(R.id.name_edt);
				phoneEdt = (EditText) view.findViewById(R.id.phone_edt);
				emailEdt = (EditText) view.findViewById(R.id.email_edt);


				createBtn.setOnClickListener(new OnClickListener() {


					/**
					 * To add the data from entry fields to
					 * list view
					 */
					@Override
					public void onClick(View v) {

						if(nameEdt.getText().toString()==null || 
								phoneEdt.getText().toString()==null || 
								emailEdt.getText().toString()==null){
							Toast.makeText(DialogActivity.this, 
									getResources().getString(R.string.exception), 
									Toast.LENGTH_LONG).show();
						}


						contact.setName(nameEdt.getText().toString());
						contact.setPhone(phoneEdt.getText().toString());
						contact.setEmail(emailEdt.getText().toString());

						contactslist.add(contact);
						CustomAdapter adapter = new CustomAdapter(DialogActivity.this,
								contactslist);

						listView.setAdapter(adapter);
						alertDialog.dismiss();

					}
				});

				/**
				 * To make the dilog disappear on clicking cancel
				 */
				cancelBtn.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						alertDialog.dismiss();

					}
				});

			}
		});
	}
}
