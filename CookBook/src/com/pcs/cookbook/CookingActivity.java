package com.pcs.cookbook;

import com.pcs.adapters.DoubleItemAdapter;
import com.pcs.adapters.SingleItemAdapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerCloseListener;
import android.widget.SlidingDrawer.OnDrawerOpenListener;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class CookingActivity extends Activity {

	private Button fridgeBtn, ovenBtn, fastBtn, settingsBtn;
	// fridge
	private Button ovenInFridgeBtn, fastInFridgeBtn, settingsInFridgeBtn;
	// oven
	private Button fridgeInOvenBtn, fastInOvenBtn, settingsInOvenBtn;
	// fast
	private Button fridgeInFastBtn, ovenInFastBtn, settingsInFastBtn;
	// settings
	private Button fridgeInSettingsBtn, fastInSettingsBtn, ovenInSettingsBtn;
	private ListView mListView;
	private SlidingDrawer mSlidingDrawerFridge, mSlidingDrawerOven,
			mSlidingDrawerFastSettings, mSlidingDrawerSettings;
	private TextView textView;
	private View handle_fridge;
	private ListView listView, fridgeListView, ovenListView, fastListView,
			settingsListView;

	private SingleItemAdapter singleItem;
	private DoubleItemAdapter doubleItem;

	private int count = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.base_layout);

		mSlidingDrawerFridge = (SlidingDrawer) findViewById(R.id.sliding_drawer_fridge);
		mSlidingDrawerOven = (SlidingDrawer) findViewById(R.id.sliding_drawer_oven);
		mSlidingDrawerFastSettings = (SlidingDrawer) findViewById(R.id.sliding_drawer_fast_settings);
		mSlidingDrawerSettings = (SlidingDrawer) findViewById(R.id.sliding_drawer_settings);
		color();

		fridgeBtn = (Button) findViewById(R.id.fridge_btn);
		ovenBtn = (Button) findViewById(R.id.oven_btn);
		fastBtn = (Button) findViewById(R.id.fast_btn);
		settingsBtn = (Button) findViewById(R.id.settings_btn);

		// fridge
		ovenInFridgeBtn = (Button) findViewById(R.id.fridge_oven_btn);
		fastInFridgeBtn = (Button) findViewById(R.id.fridge_fast_btn);
		settingsInFridgeBtn = (Button) findViewById(R.id.fridge_settings_btn);

		// oven
		fridgeInOvenBtn = (Button) findViewById(R.id.oven_fridge_btn);
		settingsInOvenBtn = (Button) findViewById(R.id.oven_settings_btn);
		fastInOvenBtn = (Button) findViewById(R.id.oven_fast_btn);

		// fast
		fridgeInFastBtn = (Button) findViewById(R.id.fast_fridge_btn);
		settingsInFastBtn = (Button) findViewById(R.id.fast_settings_btn);
		ovenInFastBtn = (Button) findViewById(R.id.fast_oven_btn);

		// settings
		fridgeInSettingsBtn = (Button) findViewById(R.id.settings_fridge_btn);
		ovenInSettingsBtn = (Button) findViewById(R.id.settings_oven_btn);
		fastInSettingsBtn = (Button) findViewById(R.id.settings_fast_btn);

		// ListViews
		listView = (ListView) findViewById(R.id.list_view);
		settingsListView = (ListView) findViewById(R.id.settings_list_view);
		fastListView = (ListView) findViewById(R.id.fast_list_view);
		ovenListView = (ListView) findViewById(R.id.oven_list_view);
		fridgeListView = (ListView) findViewById(R.id.fridge_list_view);

		mSlidingDrawerFridge
				.setOnDrawerOpenListener(new OnDrawerOpenListener() {

					@Override
					public void onDrawerOpened() {

						mSlidingDrawerOven.setVisibility(View.GONE);
						mSlidingDrawerFastSettings.setVisibility(View.GONE);
						mSlidingDrawerSettings.setVisibility(View.GONE);

						ovenInFridgeBtn.setVisibility(View.VISIBLE);
						fastInFridgeBtn.setVisibility(View.VISIBLE);
						settingsInFridgeBtn.setVisibility(View.VISIBLE);

					}
				});

		mSlidingDrawerFridge
				.setOnDrawerCloseListener(new OnDrawerCloseListener() {

					@Override
					public void onDrawerClosed() {
						mSlidingDrawerOven.setVisibility(View.VISIBLE);
						mSlidingDrawerFastSettings.setVisibility(View.VISIBLE);
						mSlidingDrawerSettings.setVisibility(View.VISIBLE);
						mSlidingDrawerFridge.setVisibility(View.VISIBLE);

						ovenInFridgeBtn.setVisibility(View.GONE);
						fastInFridgeBtn.setVisibility(View.GONE);
						settingsInFridgeBtn.setVisibility(View.GONE);
					}
				});

		mSlidingDrawerOven.setOnDrawerOpenListener(new OnDrawerOpenListener() {

			@Override
			public void onDrawerOpened() {
				mSlidingDrawerFridge.setVisibility(View.GONE);
				mSlidingDrawerFastSettings.setVisibility(View.GONE);
				mSlidingDrawerSettings.setVisibility(View.GONE);

				fridgeInOvenBtn.setVisibility(View.VISIBLE);
				fastInOvenBtn.setVisibility(View.VISIBLE);
				settingsInOvenBtn.setVisibility(View.VISIBLE);
			}
		});

		mSlidingDrawerOven
				.setOnDrawerCloseListener(new OnDrawerCloseListener() {

					@Override
					public void onDrawerClosed() {

						mSlidingDrawerFridge.setVisibility(View.VISIBLE);
						mSlidingDrawerOven.setVisibility(View.VISIBLE);
						mSlidingDrawerFastSettings.setVisibility(View.VISIBLE);
						mSlidingDrawerSettings.setVisibility(View.VISIBLE);

						fridgeInOvenBtn.setVisibility(View.GONE);
						fastInOvenBtn.setVisibility(View.GONE);
						settingsInOvenBtn.setVisibility(View.GONE);
					}
				});

		mSlidingDrawerFastSettings
				.setOnDrawerOpenListener(new OnDrawerOpenListener() {

					@Override
					public void onDrawerOpened() {
						mSlidingDrawerOven.setVisibility(View.GONE);
						mSlidingDrawerFridge.setVisibility(View.GONE);
						mSlidingDrawerSettings.setVisibility(View.GONE);

						fridgeInFastBtn.setVisibility(View.VISIBLE);
						ovenInFastBtn.setVisibility(View.VISIBLE);
						settingsInFastBtn.setVisibility(View.VISIBLE);
					}
				});

		mSlidingDrawerFastSettings
				.setOnDrawerCloseListener(new OnDrawerCloseListener() {

					@Override
					public void onDrawerClosed() {
						mSlidingDrawerOven.setVisibility(View.VISIBLE);
						mSlidingDrawerFastSettings.setVisibility(View.VISIBLE);
						mSlidingDrawerSettings.setVisibility(View.VISIBLE);
						mSlidingDrawerFridge.setVisibility(View.VISIBLE);

						fridgeInFastBtn.setVisibility(View.GONE);
						ovenInFastBtn.setVisibility(View.GONE);
						settingsInFastBtn.setVisibility(View.GONE);
					}
				});

		mSlidingDrawerSettings
				.setOnDrawerOpenListener(new OnDrawerOpenListener() {

					@Override
					public void onDrawerOpened() {
						mSlidingDrawerOven.setVisibility(View.GONE);
						mSlidingDrawerFastSettings.setVisibility(View.GONE);
						mSlidingDrawerFridge.setVisibility(View.GONE);

						fridgeInSettingsBtn.setVisibility(View.VISIBLE);
						ovenInSettingsBtn.setVisibility(View.VISIBLE);
						fastInSettingsBtn.setVisibility(View.VISIBLE);
					}
				});

		mSlidingDrawerSettings
				.setOnDrawerCloseListener(new OnDrawerCloseListener() {

					@Override
					public void onDrawerClosed() {
						mSlidingDrawerOven.setVisibility(View.VISIBLE);
						mSlidingDrawerFastSettings.setVisibility(View.VISIBLE);
						mSlidingDrawerSettings.setVisibility(View.VISIBLE);
						mSlidingDrawerFridge.setVisibility(View.VISIBLE);

						fridgeInSettingsBtn.setVisibility(View.GONE);
						ovenInSettingsBtn.setVisibility(View.GONE);
						fastInSettingsBtn.setVisibility(View.GONE);
					}
				});

	}

	private void color() {

		if (fridgeListView == null || fastListView == null
				|| settingsListView == null || ovenListView == null) {
			Log.i("Avinash", "null obtained");
		} else {
			colorFridge(4);
			colorOven(6);
			colorFast(12);
			colorSettings(9);
		}
	}

	private void colorFridge(int flag) {
		for (int i = 1; i < flag; i++) {
			if (i == 1) {
				singleItem = new SingleItemAdapter(getApplicationContext(),
						count);
				fridgeListView.setAdapter(singleItem);
				count = 2;
			} else {
				doubleItem = new DoubleItemAdapter(getApplicationContext(),
						count);
				fridgeListView.setAdapter(doubleItem);
				count = 1;
			}
		}
		singleItem = new SingleItemAdapter(getApplicationContext(), count);
		fridgeListView.setAdapter(singleItem);

	}

	private void colorOven(int flag) {
		for (int i = 1; i < flag; i++) {
			if (i == 1) {
				singleItem = new SingleItemAdapter(getApplicationContext(),
						count);
				ovenListView.setAdapter(singleItem);
				count = 2;
			} else {
				doubleItem = new DoubleItemAdapter(getApplicationContext(),
						count);
				ovenListView.setAdapter(doubleItem);
				count = 1;
			}
		}
		singleItem = new SingleItemAdapter(getApplicationContext(), count);
		ovenListView.setAdapter(singleItem);

	}

	private void colorFast(int flag) {

		for (int i = 1; i < flag; i++) {
			if (i == 1) {
				singleItem = new SingleItemAdapter(getApplicationContext(),
						count);
				fastListView.setAdapter(singleItem);
				count = 2;
			} else {
				doubleItem = new DoubleItemAdapter(getApplicationContext(),
						count);
				fastListView.setAdapter(doubleItem);
				count = 1;
			}
		}
		singleItem = new SingleItemAdapter(getApplicationContext(), count);
		fastListView.setAdapter(singleItem);
	}

	private void colorSettings(int flag) {

		for (int i = 1; i < flag; i++) {
			if (i == 1) {
				singleItem = new SingleItemAdapter(getApplicationContext(),
						count);
				settingsListView.setAdapter(singleItem);
				count = 2;
			} else {
				doubleItem = new DoubleItemAdapter(getApplicationContext(),
						count);
				settingsListView.setAdapter(doubleItem);
				count = 1;
			}
		}
		singleItem = new SingleItemAdapter(getApplicationContext(), count);
		settingsListView.setAdapter(singleItem);
	}

}
