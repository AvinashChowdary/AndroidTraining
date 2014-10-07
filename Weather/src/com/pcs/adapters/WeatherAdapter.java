package com.pcs.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.weather.R;
import com.pcs.model.WeatherModel;

public class WeatherAdapter extends BaseAdapter {

	private ArrayList<WeatherModel> weatherList;
	private Context mContext;
	private LayoutInflater layoutInflater;


	public WeatherAdapter(Context context, ArrayList<WeatherModel> weather) {

		mContext = context;
		weatherList = weather;
		layoutInflater = LayoutInflater.from(mContext);
	}
	@Override
	public int getCount() {

		return weatherList.size();
	}

	@Override
	public WeatherModel getItem(int position) {

		return weatherList.get(position);
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
			convertView = layoutInflater.inflate(R.layout.listview, null);

			holder.city = (TextView) convertView.findViewById(R.id.list_city);
			holder.temp = (TextView) convertView.findViewById(R.id.list_temp);
			holder.humidity = (TextView) convertView.findViewById(R.id.list_hum);
			holder.minTemp = (TextView) convertView.findViewById(R.id.list_min);
			holder.maxTemp = (TextView) convertView.findViewById(R.id.list_max);

			convertView.setTag(holder);
		}

		else{
			holder = (Holder)convertView.getTag();
		}

		WeatherModel obj = getItem(position);

		if(obj!=null){
			holder.city.setText(obj.getCity());
			holder.temp.setText(obj.getTemp());
			holder.humidity.setText(obj.getHumidity());
			holder.minTemp.setText(obj.getMinTemp());
			holder.maxTemp.setText(obj.getMaxTemp());
		}
		return convertView; 


	}

	public class Holder{
		public TextView city;
		public TextView temp;
		public TextView humidity;
		public TextView minTemp;
		public TextView maxTemp;
	}

}
