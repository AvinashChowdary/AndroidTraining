package com.pcs.contacts;

import java.util.ArrayList;


import com.pcs.adapter.CustomAdapter;
import com.pcs.helper.UserDetails;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;


public class ContactActivity extends Activity{

	
	private UserDetails userobj;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contacts);

		ListView listView = (ListView)findViewById(R.id.listview);

		ArrayList<UserDetails> userList = new ArrayList<UserDetails>();
		CustomAdapter adapter = new CustomAdapter(ContactActivity.this, userList);


		userobj = new UserDetails();

		userobj.setCustomername("Avinash");
		userobj.setPhone("9494401747");
		userobj.setEmail("avinash.ravilla@pcs.com");

		userList.add(userobj);

		userobj = new UserDetails();

		userobj.setCustomername("Dharma");
		userobj.setPhone("9886717839");
		userobj.setEmail("dharma.seerapu@pcs.com");

		userList.add(userobj);

		userobj = new UserDetails();

		userobj.setCustomername("Harish");
		userobj.setPhone("999999999");
		userobj.setEmail("kumar.vanka@pcs.com");

		userList.add(userobj);

		listView.setAdapter(adapter);
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(ContactActivity.this, userobj.getCustomername()+"\n"+userobj.getPhone()+"\n"+userobj.getEmail(), Toast.LENGTH_LONG).show();
				
			}
			
		});

	}

}