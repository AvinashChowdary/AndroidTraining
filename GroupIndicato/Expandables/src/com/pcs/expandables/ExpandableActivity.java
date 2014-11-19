package com.pcs.expandables;

import java.util.ArrayList;

import android.app.ExpandableListActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.widget.ExpandableListView;

import com.pcs.adapters.ExpandableAdapter;
/**
 * Main activity used to add expandable listview
 * @author pcs-05
 *
 */
public class ExpandableActivity extends ExpandableListActivity {

	private ArrayList<String> parentItems = new ArrayList<String>();
	private ArrayList<Object> childItems = new ArrayList<Object>();
	private ExpandableListView expandableList;
	private ExpandableAdapter expAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_expandable);

		expandableList = getExpandableListView();

		//Display Metrics
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		int width = metrics.widthPixels; 

		//Adding attributes to expandable list
		expandableList.setDividerHeight(3);

		expandableList.setIndicatorBoundsRelative(width-GetPixelFromDips(45), width-GetPixelFromDips(15));
		expandableList.setGroupIndicator(getResources().getDrawable(R.drawable.selector));
		expandableList.setClickable(true);

		//Adding Parents and children 
		setParents();
		setChildren();

		//sending lists to adapter
		expAdapter = new ExpandableAdapter(parentItems, childItems);
		//Accessing inflater method in adapter
		expAdapter.setInflater((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE), this);
		//Adding adapter to the list
		expandableList.setAdapter(expAdapter);
		
		//enabling on click listener to display toast
		expandableList.setOnChildClickListener(this);
	}

	public int GetPixelFromDips(float pixels) {
		// Get the screen's density scale 
		final float scale = getResources().getDisplayMetrics().density;
		// Convert the dps to pixels, based on density scale
		return (int) (pixels * scale + 0.5f);

	}

	//Adding DUmmy values as parent
	private void setParents() {
		parentItems.add("Facebook");
		parentItems.add("G+");
		parentItems.add("Orkut");
		parentItems.add("Twitter");
		parentItems.add("Bongu");
		parentItems.add("Bhoshanam");
	}

	//Adding Dummy values as children
	private void setChildren() {
		//Facebook Children
		ArrayList<String> child = new ArrayList<String>();
		child.add("Like");
		child.add("Comment");
		child.add("Share");
		child.add("Poke");
		childItems.add(child);

		//G+ Children
		child = new ArrayList<String>();
		child.add("Follow");
		child.add("Post");
		child.add("Upload");
		childItems.add(child);

		//Orkut Children
		child = new ArrayList<String>();
		child.add("Oops!! Removed");
		childItems.add(child);

		//Twitter Children
		child = new ArrayList<String>();
		child.add("Follow");
		child.add("Tweet");
		child.add("ReTweet");
		childItems.add(child);

		child = new ArrayList<String>();
		childItems.add(child);

		child = new ArrayList<String>();
		childItems.add(child);

	}

}
