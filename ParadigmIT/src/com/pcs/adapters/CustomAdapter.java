package com.pcs.adapters;


import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.pcs.model.Companies;
import com.pcs.paradigmit.R;

public class CustomAdapter extends BaseAdapter{
	private Context context;
	private ArrayList<Companies> companies;
	private LayoutInflater layoutInflater;
	public CustomAdapter(Context context, ArrayList<Companies> companies) {
		super();
		this.context = context;
		this.companies = companies;
		layoutInflater = LayoutInflater.from(context);
	}
	@Override
	public int getCount() {
		return companies.size();
	}
	@Override
	public Object getItem(int position) {
		return companies.get(position);
	}
	@Override
	public long getItemId(int position) {
		return position;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if(convertView == null){
			convertView = layoutInflater.inflate(R.layout.listview, null);

			holder=new ViewHolder();

			holder.company_name=(TextView) convertView.findViewById(R.id.company_txt);


			convertView.setTag(holder);
		}
		else{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.company_name.setText(companies.get(position).getName());


		return convertView;
	}
	public class ViewHolder{
		public TextView company_name;


	}
}