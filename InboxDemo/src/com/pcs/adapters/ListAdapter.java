package com.pcs.adapters;

import com.pcs.inboxdemo.InboxActivity;
import com.pcs.inboxdemo.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter {

	private Context context;
	private LayoutInflater layoutInflater;
	private String[] names;
	private String[] data;

	public static Animation flipIconBack, flipContactBack, flipIconFront,
			flipContactFront;

	public ListAdapter(Context context, String[] names, String[] data) {
		this.context = context;
		this.names = names;
		this.data = data;
		layoutInflater = LayoutInflater.from(context);
//		flipContactBack = AnimationUtils.loadAnimation(context,
//				R.anim.flip_back);
//		flipContactBack.setAnimationListener(this);
		flipContactFront = AnimationUtils.loadAnimation(context,
				R.anim.flip_front);
	}

	@Override
	public int getCount() {

		return names.length;
	}

	@Override
	public Object getItem(int position) {

		return names[position];
	}

	@Override
	public long getItemId(int position) {

		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
		if (convertView == null) {
			convertView = layoutInflater.inflate(R.layout.list_item, null);
			holder = new ViewHolder();
			holder.nameTxt = (TextView) convertView.findViewById(R.id.mail);
			holder.dataTxt = (TextView) convertView.findViewById(R.id.content);
			holder.pic = (CheckBox) convertView.findViewById(R.id.image);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.pic.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Animation a = AnimationUtils.loadAnimation(context,
						R.anim.flip_back);
				a.setAnimationListener(new Test(holder));
				holder.pic.startAnimation(a);
			}
		});
		holder.nameTxt.setText(names[position]);
		holder.dataTxt.setText(data[position]);
		holder.pic.setBackgroundResource(R.drawable.android);

		return convertView;
	}

	public static class ViewHolder {
		public TextView nameTxt;
		public TextView dataTxt;
		public CheckBox pic;
	}

	public class Test implements AnimationListener {
		final ViewHolder holder;

		public Test(final ViewHolder holder) {
			this.holder = holder;
		}

		@Override
		public void onAnimationStart(Animation animation) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onAnimationEnd(Animation animation) {
			if (holder.pic.isChecked()) {
				holder.pic.setBackgroundResource(R.drawable.selected_img);
				holder.pic.startAnimation(flipContactFront);
			} else {
				holder.pic.setBackgroundResource(R.drawable.android);
				holder.pic.startAnimation(flipContactFront);
			}
		}

		@Override
		public void onAnimationRepeat(Animation animation) {

		}

	}

	

}
