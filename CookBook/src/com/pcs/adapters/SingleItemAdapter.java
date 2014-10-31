package com.pcs.adapters;

import com.pcs.cookbook.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class SingleItemAdapter extends BaseAdapter {

	private Context context;
	private int colors;
	private LayoutInflater inflater;

	public SingleItemAdapter(Context context, int colors) {
		this.context = context;
		this.colors = colors;
		inflater = LayoutInflater.from(context);

	}

	@Override
	public int getCount() {
		return colors;
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
		ViewHolder holder;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.single_item, null);
			holder = new ViewHolder();
			holder.image = (ImageView) convertView
					.findViewById(R.id.single_img);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		if (colors == 1)
			holder.image.setBackgroundColor(context.getResources().getColor(
					R.color.a));

		if (colors == 2)
			holder.image.setBackgroundColor(context.getResources().getColor(
					R.color.f));

		return convertView;
	}

	public class ViewHolder {
		public ImageView image;

	}

}
