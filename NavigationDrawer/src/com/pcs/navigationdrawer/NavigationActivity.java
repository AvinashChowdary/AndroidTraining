package com.pcs.navigationdrawer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ImageView;

import com.pcs.adapters.ExpandableListAdapter;

/**
 * Sliding menu along with expandable list view is implemented in this class
 * @author pcs-05
 *
 */
public class NavigationActivity extends FragmentActivity {

	private DrawerLayout mDrawerLayout;
	private ImageView homeImg;
	private ExpandableListView expandableListView;
	private HashMap<String, List<String>> children;
	private ExpandableListAdapter expandableListAdapter;
	private List<String> parents;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_navigation);

		//Getting home buttton and adding on click listner
		//to open drawer on clicking the home button
		homeImg = (ImageView) findViewById(R.id.home);
		homeImg.setOnClickListener(homeOnclickListener);

		//Calling own method to initiate drawer 
		setUpDrawer();
	}


	//Initializing, setting attributes, adding adapters are done in this method
	private void setUpDrawer() {

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

		//Adding Listener to drawer
		mDrawerLayout.setDrawerListener(mDrawerListener);

		expandableListView = (ExpandableListView) findViewById(R.id.expandable_list);
		
		//Adding data
		prepareListData();
		
		//Adding Adapter
		expandableListAdapter = new ExpandableListAdapter(this, parents,
				children);

		//Setting adapter to list
		expandableListView.setAdapter(expandableListAdapter);

		mDrawerLayout.closeDrawer(expandableListView);
		
		//Adding listener to each child in the list
		expandableListView.setOnChildClickListener(new OnChildClickListener() {
			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				switch (groupPosition) {
				case 0:
					switch (childPosition) {
					case 0:
						break;
					case 1:
						break;
					case 2:
						break;
					default:
						break;
					}
					break;

				case 1:
					switch (childPosition) {
					case 0:
						break;
					case 1:
						break;
					case 2:
					default:
						break;
					}
					break;

				case 2:
					switch (childPosition) {
					case 0:

						break;
					case 1:
						break;
					case 2:
						break;
					default:
						break;
					}
					break;

				default:
					break;
				}

				mDrawerLayout.closeDrawer(expandableListView);
				return false;
			}
		});
	}
	
	//Opening Drawer on clicking home button
	View.OnClickListener homeOnclickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			if (mDrawerLayout.isDrawerOpen(expandableListView)) {
				mDrawerLayout.closeDrawer(expandableListView);
			} else {
				mDrawerLayout.openDrawer(expandableListView);
			}
		}
	};

	private OnItemClickListener mDrawerItemClickedListener = new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position,
				long arg3) {

			switch (position) {
			case 0:

				break;
			case 1:

				break;
			case 2:

				break;
			default:
				return;
			}

			mDrawerLayout.closeDrawer(expandableListView);
		}
	};

	//Own implemented Drawer listener
	private DrawerListener mDrawerListener = new DrawerListener() {

		@Override
		public void onDrawerStateChanged(int status) {

		}

		@Override
		public void onDrawerSlide(View view, float slideArg) {

		}

		@Override
		public void onDrawerOpened(View view) {
		}

		@Override
		public void onDrawerClosed(View view) {
		}
	};
	//Adding Dummy data
	private void prepareListData() {
		parents = new ArrayList<String>();
		children = new HashMap<String, List<String>>();

		// Adding Parent data
		parents.add("Facebook");
		parents.add("G+");
		parents.add("Orkut");
		parents.add("Twitter");

		// Adding facebook child data
		List<String> facebook = new ArrayList<String>();
		facebook.add("Like");
		facebook.add("Comment");
		facebook.add("Share");
		
		// Adding gPlus child data
		List<String> gPlus = new ArrayList<String>();
		gPlus.add("Like");
		gPlus.add("Post");
		gPlus.add("Hangouts");
		
		// Adding orkut child data
		List<String> orkut = new ArrayList<String>();
		orkut.add("Oops! Removed");
		orkut.add("Scraps");
		orkut.add("Communities");
		
		// Adding twitter child data
		List<String> twitter = new ArrayList<String>();
		twitter.add("Tweet");
		twitter.add("ReTweet");
		twitter.add("Follow");

		//Adding each child to parents
		children.put(parents.get(0), facebook);
		children.put(parents.get(1), orkut);
		children.put(parents.get(2), orkut);
		children.put(parents.get(3), twitter);
	}


}
