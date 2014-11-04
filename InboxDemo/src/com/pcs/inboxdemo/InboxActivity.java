package com.pcs.inboxdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.pcs.adapters.ListAdapter;

public class InboxActivity extends Activity {

	private ImageView topImg;
	private ImageView listImg;
	private ImageView img;
	private ListView listView;

	private String[] names = { "Avinash", "Sailika", "Dharma", "Anitha",
			"Kalyani" };
	private String[] data = { "Hi, How are you ?", "What are you doing ?",
			"Did u complete your task for today", "Tomorrow is a holiday",
			"Collect 60rs each for Bday party" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);

		topImg = (ImageView) findViewById(R.id.not_flipped_img);
		listView = (ListView) findViewById(R.id.list_view);

		ListAdapter adapter = new ListAdapter(getApplicationContext(), names,
				data);
		listView.setAdapter(adapter);

	}

}
