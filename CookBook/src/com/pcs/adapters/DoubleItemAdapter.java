package com.pcs.adapters;

import com.pcs.adapters.SingleItemAdapter.ViewHolder;
import com.pcs.cookbook.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class DoubleItemAdapter extends BaseAdapter {

	private Context context;
	private int colors;
	private LayoutInflater inflater;
	private int count = 0;

	public DoubleItemAdapter(Context context, int colors) {
		this.context = context;
		this.colors = colors;
		inflater = LayoutInflater.from(context);
		count = count + 1;
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
			holder.leftImage = (ImageView) convertView
					.findViewById(R.id.left_img);
			holder.rightImage = (ImageView) convertView
					.findViewById(R.id.right_img);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		if (colors == 1){
			holder.leftImage.setBackgroundColor(context.getResources()
					.getColor(R.color.b));
			holder.rightImage.setBackgroundColor(context.getResources().getColor(
					R.color.c));
		}
		
		if (colors == 2){
			holder.leftImage.setBackgroundColor(context.getResources()
					.getColor(R.color.d));
			holder.rightImage.setBackgroundColor(context.getResources().getColor(
					R.color.e));
		}
		
		
		return convertView;
	}

	public class ViewHolder {
		public ImageView leftImage;
		public ImageView rightImage;

	}
}
