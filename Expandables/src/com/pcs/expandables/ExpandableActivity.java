package com.pcs.expandables;

import java.util.ArrayList;

import android.app.ExpandableListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_expandable);

		ExpandableListView expandableList = getExpandableListView();

		//Adding attributes to expandable list
		expandableList.setDividerHeight(3);
		expandableList.setGroupIndicator(null);
		expandableList.setClickable(true);

		//Adding Parents and children 
		setParents();
		setChildren();

		//sending lists to adapter
		ExpandableAdapter adapter = new ExpandableAdapter(parentItems, childItems);
		//Accessing inflater method in adapter
		adapter.setInflater((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE), this);
		//Adding adapter to the list
		expandableList.setAdapter(adapter);
		//enabling on click listener to display toast
		expandableList.setOnChildClickListener(this);
	}


	//Adding DUmmy values as parent
		private void setParents() {
			parentItems.add("Facebook");
			parentItems.add("G+");
			parentItems.add("Orkut");
			parentItems.add("Twitter");
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

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.expandable, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
