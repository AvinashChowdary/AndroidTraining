package com.pcs.cookbook;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SlidingDrawer;
import android.widget.TextView;

public class CookingActivity extends Activity implements OnClickListener {

	private Button fridgeBtn, ovenBtn, fastBtn, settingsBtn;
	private ListView mListView;
	private SlidingDrawer mSlidingDrawerFridge, mSlidingDrawerOven, mSlidingDrawerFastSettings, mSlidingDrawerSettings;
	private TextView textView;
	private Handler handle_fridge;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.base_layout);



		mSlidingDrawerFridge = (SlidingDrawer) findViewById(R.id.sliding_drawer_fridge);
		mSlidingDrawerOven = (SlidingDrawer) findViewById(R.id.sliding_drawer_oven);
		mSlidingDrawerFastSettings = (SlidingDrawer) findViewById(R.id.sliding_drawer_fast_settings);
		mSlidingDrawerSettings = (SlidingDrawer) findViewById(R.id.sliding_drawer_settings);
		
		fridgeBtn = (Button) findViewById(R.id.fridge_btn);
		ovenBtn = (Button) findViewById(R.id.oven_btn);
		fastBtn = (Button) findViewById(R.id.fast_settings_btn);
		settingsBtn = (Button) findViewById(R.id.settings_btn);
		textView = (TextView)findViewById(R.id.text_view);

		fridgeBtn.setOnClickListener(this);
		ovenBtn.setOnClickListener(this);
		fastBtn.setOnClickListener(this);
		settingsBtn.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.fridge_btn:
			textView.setText("Friz");
			break;

		case R.id.oven_btn:
			textView.setText("Oven");
			break;

		case R.id.fast_settings_btn:
			textView.setText("Fast Settings");
			break;

		case R.id.settings_btn:
			textView.setText("Settings");
			break;

		default:
			break;
		}
	}

}