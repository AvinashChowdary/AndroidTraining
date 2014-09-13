package com.pcs.adapter;

import java.util.ArrayList;

import com.pcs.helper.UserDetails;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

	private ArrayList<UserDetails> users;
	private Context mcontext;


	public CustomAdapter(Context context,
			ArrayList<UserDetails> userList) {

		mcontext=context;
		users =userList;
	}

	@Override
	public int getCount() {
		return users.size();
	}

	@Override
	public UserDetails getItem(int position) {
		return users.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView tv= new TextView(mcontext);
		tv.setText("CustomerName:"+users.get(position).getCustomername()+"\n Phone Number:"+users.get(position).getPhone()+"\nEmail:"+users.get(position).getEmail());
		tv.setPadding(20, 10, 5, 10);
		return tv;
	}


}