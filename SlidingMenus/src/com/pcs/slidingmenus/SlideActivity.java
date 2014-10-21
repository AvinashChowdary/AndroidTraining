package com.pcs.slidingmenus;


import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.pcs.adapters.SlidingListAdapter;
import com.pcs.fragments.HomeFragment;
import com.pcs.fragments.LikesFragment;
import com.pcs.fragments.MessagesFragment;
import com.pcs.fragments.ProfileFragment;
import com.pcs.fragments.TasksFragment;

public class SlideActivity extends FragmentActivity implements
OnItemClickListener {

	private DrawerLayout drawerLayout = null;
	private ListView listView = null;
	private ActionBarDrawerToggle actionBarDrawerToggle = null;
	private String[] slideList = null;
	android.support.v4.app.Fragment fragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slide_layout);

		slideList = new String[] { "Home", "Profile", "Messages", "Likes",
		"Tasks" };

		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

		listView = (ListView) findViewById(R.id.sliding_menu);
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setDisplayShowHomeEnabled(true);
		getActionBar().setDisplayShowTitleEnabled(true);

		SlidingListAdapter adapter = new SlidingListAdapter(
				getApplicationContext(), slideList);
		listView.setAdapter(adapter);

		actionBarDrawerToggle = new ActionBarDrawerToggle(SlideActivity.this,
				drawerLayout, R.drawable.menu, R.string.open, R.string.close) {

			public void onDrawerClosed(View view) {
				super.onDrawerClosed(view);
			}

			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
			}
		};

		drawerLayout.setDrawerListener(actionBarDrawerToggle);

		listView.setOnItemClickListener(this);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		actionBarDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		actionBarDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		selectItem(position);

	}

	private void selectItem(int position) {
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

		switch (position) {
		case 0:
			fragment = new HomeFragment();
			ft.replace(R.id.container, fragment);

			break;
		case 1:
			fragment = new ProfileFragment();
			ft.replace(R.id.container, fragment);

			break;
		case 2:
			fragment = new MessagesFragment();
			ft.replace(R.id.container, fragment);

			break;
		case 3:
			fragment = new LikesFragment();
			ft.replace(R.id.container, fragment);

			break;
		case 4:
			fragment = new TasksFragment();
			ft.replace(R.id.container, fragment);

			break;
		}

		ft.commit();
		listView.setItemChecked(position, true);
		setTitle(slideList[position]);
		drawerLayout.closeDrawer(listView);
	}

}
