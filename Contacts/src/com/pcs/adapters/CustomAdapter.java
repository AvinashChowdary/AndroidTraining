package com.pcs.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pcs.contactmanager.R;
import com.pcs.model.Contacts;

public class CustomAdapter extends BaseAdapter{

	private Context context;
	private ArrayList<Contacts> contacts;
	private LayoutInflater layoutInflater;
	public CustomAdapter(Context context, ArrayList<Contacts> contacts) {
		super();
		this.context = context;
		this.contacts = contacts;
		layoutInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {

		return contacts.size();
	}

	@Override
	public Object getItem(int position) {

		return contacts.get(position);
	}

	@Override
	public long getItemId(int position) {

		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if(convertView == null){
			convertView = layoutInflater.inflate(R.layout.gridview, null);

			holder=new ViewHolder();

			holder.name=(TextView) convertView.findViewById(R.id.name);
			holder.phone = (TextView)convertView.findViewById(R.id.phone);
			holder.email = (TextView)convertView.findViewById(R.id.email);
			holder.pic = (ImageView) convertView.findViewById(R.id.pic);

			convertView.setTag(holder);
		}
		else{

			holder = (ViewHolder) convertView.getTag();
		}
		holder.name.setText(contacts.get(position).getName());
		holder.phone.setText(contacts.get(position).getPhone());
		holder.email.setText(contacts.get(position).getEmail());
		holder.pic.setImageResource(R.drawable.callpic);

		return convertView;
	}
	
	/**
	 * This class is used to create a holder 
	 * @author Avinash
	 */
	public class ViewHolder{
		public TextView name;
		public TextView email;
		public TextView phone;
		public ImageView pic;
	}
	
	/**
	 * This method is used to add a single contact object
	 * @param contact
	 */
	public void addUser(Contacts contact){
		if(contacts!=null){
			contacts.add(contact); 
		}
		else{
			throw new IllegalArgumentException("Details Should not be Null");
			
		}
		notifyDataSetChanged();
	}

}



