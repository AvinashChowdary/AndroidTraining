package com.pcs.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.pcs.slidingmenus.R;
/**
 * Adapter to set a list to the sliding menu
 */
public class SlidingListAdapter extends BaseAdapter {

	private Context context;
	private String[] list;
	private LayoutInflater inflater;

	public SlidingListAdapter(Context applicationContext, String[] slideList) {

		context = applicationContext;
		list = slideList;

	}

	@Override
	public int getCount() {

		return list.length;
	}

	@Override
	public Object getItem(int position) {

		return position;
	}

	@Override
	public long getItemId(int position) {

		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		//inflating layout
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		convertView = inflater.inflate(R.layout.sliding_list_xml, null);
		//Finding and adding text to textview
		TextView textView = (TextView) convertView.findViewById(R.id.item);
		textView.setText(list[position]);

		return convertView;
	}

}
