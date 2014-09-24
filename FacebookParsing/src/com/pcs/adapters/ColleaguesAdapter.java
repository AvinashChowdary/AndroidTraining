package com.pcs.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.facebookparsing.R;
import com.pcs.model.Colleagues;

public class ColleaguesAdapter extends BaseAdapter{

	private ArrayList<Colleagues> colleaguesList;
	private Context mContext;
	private LayoutInflater layoutInflater;


	public ColleaguesAdapter(Context context, ArrayList<Colleagues> colleagues) {

		mContext = context;
		colleaguesList = colleagues;
		layoutInflater = LayoutInflater.from(mContext);
	}
	@Override
	public int getCount() {

		return colleaguesList.size();
	}

	@Override
	public Colleagues getItem(int position) {

		return colleaguesList.get(position);
	}

	@Override
	public long getItemId(int position) {

		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Holder holder = null;
		if(convertView == null){

			holder = new Holder();

			convertView = layoutInflater.inflate(R.layout.listview_layout, null);

			holder.name = (TextView) convertView.findViewById(R.id.name_txt);
			holder.gender = (TextView) convertView.findViewById(R.id.gender_txt);
			holder.id = (TextView) convertView.findViewById(R.id.id_txt);
			holder.locale = (TextView) convertView.findViewById(R.id.locale_txt);

			convertView.setTag(holder);
		}
		else{
			holder = (Holder)convertView.getTag();
		}
		
		Colleagues obj = getItem(position);
		
		if(obj!=null){
		holder.name.setText(obj.getName());
		holder.gender.setText(obj.getGender());
		holder.id.setText(obj.getId());
		holder.locale.setText(obj.getLocale());
		}
		return convertView;
	}
	
	public class Holder{
		public TextView name;
		public TextView gender;
		public TextView id;
		public TextView locale;
	}
}
	
	




