package com.southmp3.android;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.facebook.widget.LikeView;
import com.southmp3.R;
import com.southmp3.constants.Constants;
import com.southmp3.fragment.ContactFragment;
import com.southmp3.fragment.HomeFragment;
import com.southmp3.fragment.SearchFragment;
import com.southmp3.fragment.TeluguSongsFragment;

public class HomeActivity extends Activity {

	private String[] mListitems;

	private DrawerLayout mDrawerLayout;

	private ListView mDrawerList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		getActionBar().setHomeButtonEnabled(true);
		mListitems = getResources().getStringArray(R.array.nav_drawer_items);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) mDrawerLayout.findViewById(R.id.left_drawer);

		// Set the adapter for the list view
		mDrawerList.setAdapter(new ArrayAdapter<String>(this,
				R.layout.drawer_list_item, mListitems));
		// Set the list's click listener
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		Fragment fragment = new HomeFragment();
		loadFragment(fragment);
	}

	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView parent, View view, int position,
				long id) {
			Fragment fragment = null;
			switch (position) {
			case Constants.HOME:
				fragment = new HomeFragment();
				loadFragment(fragment);
				break;
			case Constants.TELUGU_SONGS:
				fragment = new TeluguSongsFragment();
				loadFragment(fragment);
				break;
			case Constants.SEARCH:
				fragment = new SearchFragment();
				loadFragment(fragment);
				break;
			case Constants.CONTACT:
				fragment = new ContactFragment();
				loadFragment(fragment);
				break;
			case Constants.SHARE:
				try {
					Intent mIntent = new Intent(Intent.ACTION_SEND);
					mIntent.setType("text/plain");
					mIntent.putExtra(Intent.EXTRA_SUBJECT, "South Mp3");
					String sAux = "\nAll New App for Telugu Songs\n";
					sAux = sAux
							+ "https://play.google.com/store/apps/details?id="
							+ HomeActivity.this.getPackageName() + "\n\n";
					mIntent.putExtra(Intent.EXTRA_TEXT, sAux);
					startActivity(Intent.createChooser(mIntent, "Share Via"));
				} catch (Exception e) { // e.toString();
				}
				break;
			case Constants.RATE:
				Uri uri = Uri.parse("market://details?id="
						+ HomeActivity.this.getPackageName());
				Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
				try {
					startActivity(goToMarket);
				} catch (ActivityNotFoundException e) {
					startActivity(new Intent(
							Intent.ACTION_VIEW,
							Uri.parse("http://play.google.com/store/apps/details?id="
									+ HomeActivity.this.getPackageName())));
				}
				break;
			default:
				break;
			}
			mDrawerLayout.closeDrawer(mDrawerList);
		}
	}

	private void loadFragment(Fragment fragment) {

		if (fragment != null) {
			FragmentManager fragmentManager = getFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.content_frame, fragment).commit();

		} else {
			// error in creating fragment
			Log.e("MainActivity", "Error in creating fragment");
		}
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			if (mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
				mDrawerLayout.closeDrawers();
			} else {
				mDrawerLayout.openDrawer(Gravity.LEFT);
			}
			break;

		default:
			break;
		}

		return super.onMenuItemSelected(featureId, item);
	}
	
	@Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        LikeView.handleOnActivityResult(HomeActivity.this, requestCode, resultCode, data);
        Log.i("Faceboook", "OnActivityResult...");
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		return super.onOptionsItemSelected(item);
	}
}
