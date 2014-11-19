package com.pcs.adapters;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckedTextView;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.pcs.expandables.ExpandableActivity;
import com.pcs.expandables.R;
/**
 * Custom Adapter used to add list of items to the Expandable list view
 * extends BaseExpandableListAdapter
 * @author pcs-05
 *
 */
public class ExpandableAdapter extends BaseExpandableListAdapter {

	private Context context;
	private ArrayList<Object> childItems;
	private LayoutInflater inflater;
	private ArrayList<String> parents, children;

	//Constructor
	public ExpandableAdapter(ArrayList<String> parents, ArrayList<Object> childern) {
		this.parents = parents;
		childItems = childern;
	}

	//Inflater is obtained using this method
	public void setInflater(LayoutInflater inflater, Activity activity) {
		this.inflater = inflater;
		this.context = activity;
	}

	@Override
	public int getGroupCount() {
		return parents.size();
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return ((ArrayList<String>) childItems.get(groupPosition)).size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		return null;
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return null;
	}

	@Override
	public long getGroupId(int groupPosition) {
		return 0;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return 0;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	//Returns the view with the Parent level View
	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {

		if(convertView==null){
			convertView = inflater.inflate(R.layout.child_layout, null);
		}

		((CheckedTextView) convertView).setText(parents.get(groupPosition));
		((CheckedTextView) convertView).setChecked(isExpanded);
		
		return convertView;
	}

	//Returns the view with Children level View
	@Override
	public View getChildView(int groupPosition, final int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {

		children = (ArrayList<String>) childItems.get(groupPosition);
		TextView textView = null;

		if (convertView == null) {
			convertView = inflater.inflate(R.layout.parent_layout, null);
		}

		textView = (TextView) convertView.findViewById(R.id.text_view);
		textView.setText(children.get(childPosition));

		convertView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				Toast.makeText(context, children.get(childPosition),
						Toast.LENGTH_SHORT).show();
			}
		});
		return convertView;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return false;
	}

}
